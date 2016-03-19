package uk.co.jmbtechnology.androidphotoextract;


import android.app.ActivityManager;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;

import java.io.IOException;

import uk.co.jmbtechnology.androidphotoextract.PhotoExtractRequest;


/**
  * @url https://github.com/JMB-Technology-Limited/AndroidPhotoExtract
  * @license Open Source - BSD
  **/
public class PhotoExtractResponseInProgress {

    protected String filename = null;

    protected String rawDebugInformation = "";

    protected Integer height = null;

    protected Integer width = null;

    protected String MIMEType = null;

    protected String EXIFMake = null;

    protected Integer EXIFOrientation = null;

    protected Bitmap thumbnail = null;

    public String getRawDebugInformation() {
        return rawDebugInformation;
    }

    /**
    * @TargetApi(Build.VERSION_CODES.KITKAT)
    **/
    public void process(Context context, Uri uri, PhotoExtractRequest photoExtractRequest) throws PhotoExtractError {
        rawDebugInformation += "URI:\n" + uri.toString() + "\n";


        // Thanks to http://stackoverflow.com/questions/19834842/android-gallery-on-kitkat-returns-different-uri-for-intent-action-get-content/
        final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;

        if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
            // ExternalStorageProvider
            if (isExternalStorageDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                if ("primary".equalsIgnoreCase(type)) {
                    filename =  Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            }
            // DownloadsProvider
            else if (isDownloadsDocument(uri)) {

                final String id = DocumentsContract.getDocumentId(uri);
                final Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));

                filename = getDataColumn(context, contentUri, null, null);
            }
            // MediaProvider
            else if (isMediaDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    final String selection = "_id=?";
                    final String[] selectionArgs = new String[] {
                            split[1]
                    };

                    filename =  getDataColumn(context, contentUri, selection, selectionArgs);

                }

            }
        }
        // MediaStore (and general)
        else if ("content".equalsIgnoreCase(uri.getScheme())) {

            // Return the remote address
            if (isGooglePhotosUri(uri)) {
                filename = uri.getLastPathSegment();
            } else {
                filename = getDataColumn(context, uri, null, null);
            }
        }
        // File
        else if (uri.getScheme().equalsIgnoreCase("file")) {
            filename = uri.getPath();
        }


        if (filename == null) {
            return;
        }

        if (photoExtractRequest.isReturnDimensions() || photoExtractRequest.isReturnMIMEType() || photoExtractRequest.isReturnThumbnail()) {
            //Log.v("CODE", "Decode Bounds Let's Go");
            BitmapFactory.Options opts = new BitmapFactory.Options();
            opts.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(filename, opts);
            //Log.v("CODE"," H = " + opts.outHeight);
            //Log.v("CODE", " W = " + opts.outWidth);
            //Log.v("CODE"," MT = " + opts.outMimeType);
            if (opts.outHeight > 0) {
                height = opts.outHeight;
            }
            if (opts.outWidth > 0) {
                width = opts.outWidth;
            }
            MIMEType = opts.outMimeType;
        }

        if (photoExtractRequest.isReturnEXIF() || photoExtractRequest.isReturnThumbnail()) {
            try {
                ExifInterface exifInterface = new ExifInterface(filename);

                EXIFMake = exifInterface.getAttribute(ExifInterface.TAG_MAKE);
                //localPhoto.setExifModel(exifInterface.getAttribute(ExifInterface.TAG_MODEL));
                //localPhoto.setExifFNumber(exifInterface.getAttribute("FNumber"));
                //localPhoto.setExifExposureTime(exifInterface.getAttribute("ExposureTime"));
                //localPhoto.setExifFocalLength(exifInterface.getAttribute(ExifInterface.TAG_FOCAL_LENGTH));
                //localPhoto.setExifISO(exifInterface.getAttribute("ISOSpeedRatings"));
                int o = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
                if (o == ExifInterface.ORIENTATION_NORMAL) {
                    EXIFOrientation = 0;
                } else if (o == ExifInterface.ORIENTATION_ROTATE_90) {
                    EXIFOrientation = 90;
                } else if (o == ExifInterface.ORIENTATION_ROTATE_180) {
                    EXIFOrientation = 180;
                } else if (o == ExifInterface.ORIENTATION_ROTATE_270) {
                    EXIFOrientation = 270;
                }

                //EXIFGPSDecoder egd = new EXIFGPSDecoder(exifInterface);
                //if (egd.isValid()) {
                //    localPhoto.setLocation(egd.getLatitude(), egd.getLongitude());
                //}

            } catch (IOException e) {
                throw new PhotoExtractError(e, rawDebugInformation);
            }

        }

        if (photoExtractRequest.isReturnThumbnail()) {

            try {

                //Log.i("THUMB_CURRENTSCALEWIDTH",Integer.toString(newEntryFilenameDetailsLoaderData.getWidth()));
                //Log.i("THUMB_CURRENTSCALEHEIGHT",Integer.toString(newEntryFilenameDetailsLoaderData.getHeight()));

                int factor = 1;
                while ( Math.max(height / (factor * 2), width / (factor * 2)) > photoExtractRequest.getReturnThumbnailSize()) {
                    factor = factor * 2;
                }

                //Log.i("THUMB_FACTOR OF",Integer.toString(factor));


                //Log.i("THUMB_NEWSCALEWIDTH",Integer.toString(newEntryFilenameDetailsLoaderData.getWidth() / factor));
                //Log.i("THUMB_NEWSCALEHEIGHT",Integer.toString(newEntryFilenameDetailsLoaderData.getHeight() / factor));

                BitmapFactory.Options optsThumbnail = new BitmapFactory.Options();
                optsThumbnail.inSampleSize = factor;
                thumbnail = BitmapFactory.decodeFile(filename, optsThumbnail);

                if ( EXIFOrientation != null && EXIFOrientation > 0) {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(EXIFOrientation);
                    thumbnail = Bitmap.createBitmap(thumbnail, 0, 0, thumbnail.getWidth(), thumbnail.getHeight(), matrix, true);
                }

            } catch (OutOfMemoryError e) {
                throw new PhotoExtractError(e, rawDebugInformation);
            } finally {
                // do not do
                // if (bitmap != null) bitmap.recycle();
                // because we might have passed the bitmap elsewhere!
            }



        }

    }


    public static String getDataColumn(Context context, Uri uri, String selection,
                                       String[] selectionArgs) {
        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {
                column
        };

        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, null);
            if (cursor != null && cursor.moveToFirst()) {
                final int index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public String getFilename() {
        return filename;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    public String getMIMEType() {
        return MIMEType;
    }

    public String getEXIFMake() {
        return EXIFMake;
    }

    public Integer getEXIFOrientation() {
        return EXIFOrientation;
    }

    public Bitmap getThumbnail() {
        return thumbnail;
    }
}
