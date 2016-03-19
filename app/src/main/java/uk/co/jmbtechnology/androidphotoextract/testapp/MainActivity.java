package uk.co.jmbtechnology.androidphotoextract.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.PrintWriter;
import java.io.StringWriter;

import uk.co.jmbtechnology.androidphotoextract.PhotoExtractResponse;
import uk.co.jmbtechnology.androidphotoextract.PhotoExtractWorkerGetIntent;
import uk.co.jmbtechnology.androidphotoextract.PhotoExtractRequest;
import uk.co.jmbtechnology.androidphotoextract.PhotoExtractRequestBuilder;

/**
  * @url https://github.com/JMB-Technology-Limited/AndroidPhotoExtract
  * @license Open Source - BSD
  **/
public class MainActivity extends FragmentActivity {

    protected final int LOADER_ID = 1;

    private int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private PhotoExtractRequest photoExtractRequest;

    private String report;

    /**
     *
     * BASIC INTRO - STEP 1
     * Set up a request object with what you want back, get the intent, start it.
     **/
    public void onClickExtract(View view) {
        PhotoExtractRequestBuilder photoExtractRequestBuilder = new PhotoExtractRequestBuilder()
            .setReturnRawDebugInformation(true)
            .setReturnFileName(true)
            .setReturnFileNameInAppFilesDir(((CheckBox)findViewById(R.id.request_filename_app)).isChecked())
            .setReturnFileNameInExternalStorage(((CheckBox)findViewById(R.id.request_filename_external)).isChecked())
            .setReturnDimensions(true)
            .setReturnMIMEType(true)
            .setReturnEXIF(true)
            .setReturnThumbnail(true)
            .setReturnThumbnailSize(400);
        photoExtractRequest = photoExtractRequestBuilder.build();
        PhotoExtractWorkerGetIntent photoExtractWorker = new PhotoExtractWorkerGetIntent(this);
        Intent intent = photoExtractWorker.getIntent(photoExtractRequest);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    protected Intent resultsIntent;

    /**
     *
     * BASIC INTRO - STEP 2
     * Get back the intent result. Start a background process to get the data you wanted.
     **/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            resultsIntent = data;

            getSupportLoaderManager().restartLoader(LOADER_ID, null, loaderCallBacks).forceLoad();

        }
    }

    LoaderManager.LoaderCallbacks<LoaderResult> loaderCallBacks = new LoaderManager.LoaderCallbacks<LoaderResult>(){

        /**
         *
         * BASIC INTRO - STEP 3
         * In this background process call the library, which does all the processing.
         **/
        @Override
        public Loader<LoaderResult> onCreateLoader(int id, Bundle args) {
            return new uk.co.jmbtechnology.androidphotoextract.testapp.Loader(MainActivity.this, photoExtractRequest, resultsIntent);
        }
        
        /**
         *
         * BASIC INTRO - STEP 4
         * Get the data you wanted back!
         **/
        @Override
        public void onLoadFinished(Loader<LoaderResult> loader, LoaderResult data) {
            findViewById(R.id.send_report).setVisibility(View.VISIBLE);
            if (data.isResponse()) {
                // Got data!
                PhotoExtractResponse photoExtractResponse = data.getResponse();

                // raw info

                TextView rawDebugInfoTextView = (TextView) findViewById(R.id.raw_debug_information);
                rawDebugInfoTextView.setText(photoExtractResponse.getRawDebugInformation());

                report = getString(R.string.activity_main_raw_debug_info) + "\n\n" + photoExtractResponse.getRawDebugInformation() + "\n\n";

                // filename

                TextView filenameTextView = (TextView) findViewById(R.id.filename);
                if (photoExtractResponse.hasFilename()) {
                    filenameTextView.setText(photoExtractResponse.getFilename());
                    report += getString(R.string.activity_main_filename) + "\n\n" + photoExtractResponse.getFilename() + "\n\n";
                } else {
                    filenameTextView.setText("Not returned");
                }


                // filename app

                TextView filenameAppFilesTextView = (TextView) findViewById(R.id.filename_app_files);
                if (photoExtractResponse.hasFilenameInAppFiles()) {
                    filenameAppFilesTextView.setText(photoExtractResponse.getFilenameInAppFiles());
                    report += getString(R.string.activity_main_filename_app) + "\n\n" + photoExtractResponse.getFilenameInAppFiles() + "\n\n";
                } else {
                    filenameAppFilesTextView.setText("Not returned");
                }

                // filename external storage

                TextView filenameExternalStorageTextView = (TextView) findViewById(R.id.filename_external_storage);
                if (photoExtractResponse.hasFilenameInExternalStorage()) {
                    filenameExternalStorageTextView.setText(photoExtractResponse.getFilenameInExternalStorage());
                    report += getString(R.string.activity_main_filename_external_storage) + "\n\n" + photoExtractResponse.getFilenameInExternalStorage() + "\n\n";
                } else {
                    filenameExternalStorageTextView.setText("Not returned");
                }

                // width x height

                TextView widthTextView = (TextView) findViewById(R.id.width_x_height);
                if (photoExtractResponse.hasWidthHeight()) {
                    widthTextView.setText(photoExtractResponse.getWidth() + " x " + photoExtractResponse.getHeight());
                    report += getString(R.string.activity_main_width_height) + "\n\n" + photoExtractResponse.getWidth() + " x " + photoExtractResponse.getHeight() + "\n\n";
                } else {
                    widthTextView.setText("Not returned");
                }

                // mime type

                TextView MimeTypeTextView = (TextView) findViewById(R.id.mime_type);
                if (photoExtractResponse.hasMIMEType()) {
                    MimeTypeTextView.setText(photoExtractResponse.getMIMEType());
                    report += getString(R.string.activity_main_mime_type) + "\n\n" + photoExtractResponse.getEXIFOrientation() + "\n\n";
                } else {
                    MimeTypeTextView.setText("Not returned");
                }

                // exif make

                TextView EXIFMakeTextView = (TextView) findViewById(R.id.exif_make);
                if (photoExtractResponse.hasEXIFMake()) {
                    EXIFMakeTextView.setText(photoExtractResponse.getEXIFMake());
                    report += getString(R.string.activity_main_exif_make) + "\n\n" + photoExtractResponse.getEXIFMake() + "\n\n";
                } else {
                    EXIFMakeTextView.setText("Not returned");
                }

                // exif orientation

                TextView EXIFOrientationTextView = (TextView) findViewById(R.id.exif_orientation);
                if (photoExtractResponse.hasEXIFOrientation()) {
                    EXIFOrientationTextView.setText(Integer.toString(photoExtractResponse.getEXIFOrientation()));
                    report += getString(R.string.activity_main_exif_orientation) + "\n\n" + photoExtractResponse.getEXIFOrientation() + "\n\n";
                } else {
                    EXIFOrientationTextView.setText("Not returned");
                }

                // thumbnail

                ImageView thumbnailImageView = (ImageView) findViewById(R.id.thumbnail);
                if (photoExtractResponse.hasThumbnail()) {
                    thumbnailImageView.setVisibility(View.VISIBLE);
                    thumbnailImageView.setImageBitmap(photoExtractResponse.getThumbnail());
                    report += getString(R.string.activity_main_thumbnail) + "\n\nGot\n\n";
                } else {
                    thumbnailImageView.setVisibility(View.GONE);
                }
            } else if (data.isError()) {
                // Got error!
                TextView rawDebugInfoTextView = (TextView) findViewById(R.id.raw_debug_information);
                StringWriter errors = new StringWriter();
                data.getError().getOriginalThrowable().printStackTrace(new PrintWriter(errors));
                report = data.getError().getOriginalThrowable().toString() + "\n\n" +
                        errors.toString() + "\n\n" +
                        data.getError().getRawDebugInformation();
                rawDebugInfoTextView.setText(report);

                Toast.makeText(getBaseContext(), R.string.activity_main_error, Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onLoaderReset(Loader<LoaderResult> loader) {

        }
    };


    public void onClickSendReport(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.activity_main_send_report_subject));
        intent.putExtra(Intent.EXTRA_TEXT, report);
        startActivity(Intent.createChooser(intent, getString(R.string.activity_main_send_report_chooser_title)));
    }

}
