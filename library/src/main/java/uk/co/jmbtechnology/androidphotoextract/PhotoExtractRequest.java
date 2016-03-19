package uk.co.jmbtechnology.androidphotoextract;


/**
 *
 *
 * Immutable Object!
 *
 *
 * @url https://github.com/JMB-Technology-Limited/AndroidPhotoExtract
 * @license Open Source - BSD
 **/
public class PhotoExtractRequest {

    protected boolean returnRawDebugInformation = false;

    protected boolean returnFileName = false;

    protected boolean returnDimensions = false;

    protected boolean returnMIMEType = false;

    protected boolean returnEXIF = false;

    protected boolean returnThumbnail = false;

    protected int returnThumbnailSize = 400;

    protected boolean returnFileNameInAppFilesDir = false;

    protected String fileNameInAppFilesPrefix = "/photoExtract/";

    protected boolean returnFileNameInExternalStorage = false;

    protected String fileNameInExternalStoragePrefix = "/photoExtract/";

    public PhotoExtractRequest(
            boolean returnRawDebugInformation,
            boolean returnFileName,
            boolean returnFileNameInAppFilesDir,
            String fileNameInAppFilesPrefix,
            boolean returnFileNameInExternalStorage,
            String fileNameInExternalStoragePrefix,
            boolean returnDimensions,
            boolean returnMIMEType,
            boolean returnEXIF,
            boolean returnThumbnail,
            int returnThumbnailSize) {
        this.returnRawDebugInformation = returnRawDebugInformation;
        this.returnFileName = returnFileName;
        this.returnFileNameInAppFilesDir = returnFileNameInAppFilesDir;
        this.fileNameInAppFilesPrefix = fileNameInAppFilesPrefix;
        this.returnFileNameInExternalStorage = returnFileNameInExternalStorage;
        this.fileNameInExternalStoragePrefix = fileNameInExternalStoragePrefix;
        this.returnDimensions = returnDimensions;
        this.returnMIMEType = returnMIMEType;
        this.returnEXIF = returnEXIF;
        this.returnThumbnail = returnThumbnail;
        this.returnThumbnailSize = returnThumbnailSize;
    }

    public boolean isReturnRawDebugInformation() {
        return returnRawDebugInformation;
    }

    public boolean isReturnFileName() {
        return returnFileName;
    }

    public boolean isReturnDimensions() {
        return returnDimensions;
    }

    public boolean isReturnMIMEType() {
        return returnMIMEType;
    }

    public boolean isReturnEXIF() {
        return returnEXIF;
    }

    public boolean isReturnThumbnail() {
        return returnThumbnail;
    }

    public int getReturnThumbnailSize() {
        return returnThumbnailSize;
    }

    public String getFileNameInAppFilesPrefix() {
        return fileNameInAppFilesPrefix;
    }

    public String getFileNameInExternalStoragePrefix() {
        return fileNameInExternalStoragePrefix;
    }

    public boolean isReturnFileNameInAppFilesDir() {
        return returnFileNameInAppFilesDir;
    }

    public boolean isReturnFileNameInExternalStorage() {
        return returnFileNameInExternalStorage;
    }
}
