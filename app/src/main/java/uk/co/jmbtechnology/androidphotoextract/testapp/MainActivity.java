package uk.co.jmbtechnology.androidphotoextract.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.View;
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

    private PhotoExtractRequestBuilder photoExtractRequestBuilder;
    private PhotoExtractRequest photoExtractRequest;
    private PhotoExtractWorkerGetIntent photoExtractWorker;

    /**
     *
     * BASIC INTRO - STEP 1
     * Set up a request object with what you want back, get the intent, start it.
     **/
    public void onClickExtract(View view) {
        photoExtractRequestBuilder = new PhotoExtractRequestBuilder();
        photoExtractRequestBuilder.setReturnRawDebugInformation(true);
        photoExtractRequestBuilder.setReturnFileName(true);
        photoExtractRequestBuilder.setReturnDimensions(true);
        photoExtractRequestBuilder.setReturnMIMEType(true);
        photoExtractRequestBuilder.setReturnEXIF(true);
        photoExtractRequestBuilder.setReturnThumbnail(true);
        photoExtractRequestBuilder.setReturnThumbnailSize(400);
        photoExtractRequest = photoExtractRequestBuilder.build();
        photoExtractWorker = new PhotoExtractWorkerGetIntent(this);
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
            if (data.isResponse()) {
                // Got data!
                PhotoExtractResponse photoExtractResponse = data.getResponse();

                TextView rawDebugInfoTextView = (TextView) findViewById(R.id.raw_debug_information);
                rawDebugInfoTextView.setText(photoExtractResponse.getRawDebugInformation());

                TextView filenameTextView = (TextView) findViewById(R.id.filename);
                if (photoExtractResponse.hasFilename()) {
                    filenameTextView.setText(photoExtractResponse.getFilename());
                } else {
                    filenameTextView.setText("Not returned");
                }

                TextView widthTextView = (TextView) findViewById(R.id.width_x_height);
                if (photoExtractResponse.hasWidthHeight()) {
                    widthTextView.setText(photoExtractResponse.getWidth() + " x " + photoExtractResponse.getHeight());
                } else {
                    widthTextView.setText("Not returned");
                }

                TextView MimeTypeTextView = (TextView) findViewById(R.id.mime_type);
                if (photoExtractResponse.hasMIMEType()) {
                    MimeTypeTextView.setText(photoExtractResponse.getMIMEType());
                } else {
                    MimeTypeTextView.setText("Not returned");
                }

                TextView EXIFMakeTextView = (TextView) findViewById(R.id.exif_make);
                if (photoExtractResponse.hasEXIFMake()) {
                    EXIFMakeTextView.setText(photoExtractResponse.getEXIFMake());
                } else {
                    EXIFMakeTextView.setText("Not returned");
                }

                TextView EXIFOrientationTextView = (TextView) findViewById(R.id.exif_orientation);
                if (photoExtractResponse.hasEXIFOrientation()) {
                    EXIFOrientationTextView.setText(Integer.toString(photoExtractResponse.getEXIFOrientation()));
                } else {
                    EXIFOrientationTextView.setText("Not returned");
                }

                ImageView thumbnailImageView = (ImageView) findViewById(R.id.thumbnail);
                if (photoExtractResponse.hasThumbnail()) {
                    thumbnailImageView.setVisibility(View.VISIBLE);
                    thumbnailImageView.setImageBitmap(photoExtractResponse.getThumbnail());
                } else {
                    thumbnailImageView.setVisibility(View.GONE);
                }
            } else if (data.isError()) {
                // Got error!
                TextView rawDebugInfoTextView = (TextView) findViewById(R.id.raw_debug_information);
                StringWriter errors = new StringWriter();
                data.getError().getOriginalThrowable().printStackTrace(new PrintWriter(errors));
                rawDebugInfoTextView.setText(
                        data.getError().getOriginalThrowable().toString() +"\n\n" +
                        errors.toString()+"\n\n"+
                        data.getError().getRawDebugInformation()
                );

                Toast.makeText(getBaseContext(), R.string.activity_main_error, Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onLoaderReset(Loader<LoaderResult> loader) {

        }
    };

}
