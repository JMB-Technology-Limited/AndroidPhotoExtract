package uk.co.jmbtechnology.androidphotoextract;

/**
  * @url https://github.com/JMB-Technology-Limited/AndroidPhotoExtract
  * @license Open Source - BSD
  **/
public class PhotoExtractRequestBuilder {


    protected boolean returnRawDebugInformation = false;

    protected boolean returnFileName = false;

    protected boolean returnFileNameInAppFilesDir = false;

    protected String fileNameInAppFilesPrefix = "/photoExtract/";

    protected boolean returnFileNameInExternalStorage = false;

    protected String fileNameInExternalStoragePrefix = "/photoExtract/";

    protected boolean returnDimensions = false;

    protected boolean returnMIMEType = false;

    protected boolean returnEXIF = false;

    protected boolean returnThumbnail = false;

    protected int returnThumbnailSize = 400;

    public boolean isReturnRawDebugInformation() {
        return returnRawDebugInformation;
    }

    public void setReturnRawDebugInformation(boolean returnRawDebugInformation) {
        this.returnRawDebugInformation = returnRawDebugInformation;
    }

    public boolean isReturnFileName() {
        return returnFileName;
    }

    public void setReturnFileName(boolean returnFileName) {
        this.returnFileName = returnFileName;
    }

    public boolean isReturnDimensions() {
        return returnDimensions;
    }

    public void setReturnDimensions(boolean returnDimensions) {
        this.returnDimensions = returnDimensions;
    }

    public boolean isReturnMIMEType() {
        return returnMIMEType;
    }

    public void setReturnMIMEType(boolean returnMIMEType) {
        this.returnMIMEType = returnMIMEType;
    }

    public boolean isReturnEXIF() {
        return returnEXIF;
    }

    public void setReturnEXIF(boolean returnEXIF) {
        this.returnEXIF = returnEXIF;
    }

    public boolean isReturnThumbnail() {
        return returnThumbnail;
    }

    public void setReturnThumbnail(boolean returnThumbnail) {
        this.returnThumbnail = returnThumbnail;
    }

    public int getReturnThumbnailSize() {
        return returnThumbnailSize;
    }

    public void setReturnThumbnailSize(int returnThumbnailSize) {
        this.returnThumbnailSize = returnThumbnailSize;
    }

    public String getFileNameInAppFilesPrefix() {
        return fileNameInAppFilesPrefix;
    }

    public void setFileNameInAppFilesPrefix(String fileNameInAppFilesPrefix) {
        this.fileNameInAppFilesPrefix = fileNameInAppFilesPrefix;
    }

    public String getFileNameInExternalStoragePrefix() {
        return fileNameInExternalStoragePrefix;
    }

    public void setFileNameInExternalStoragePrefix(String fileNameInExternalStoragePrefix) {
        this.fileNameInExternalStoragePrefix = fileNameInExternalStoragePrefix;
    }

    public boolean isReturnFileNameInAppFilesDir() {
        return returnFileNameInAppFilesDir;
    }

    public void setReturnFileNameInAppFilesDir(boolean returnFileNameInAppFilesDir) {
        this.returnFileNameInAppFilesDir = returnFileNameInAppFilesDir;
    }

    public boolean isReturnFileNameInExternalStorage() {
        return returnFileNameInExternalStorage;
    }

    public void setReturnFileNameInExternalStorage(boolean returnFileNameInExternalStorage) {
        this.returnFileNameInExternalStorage = returnFileNameInExternalStorage;
    }

    public PhotoExtractRequest build() {
        PhotoExtractRequest photoExtractRequest = new PhotoExtractRequest(
                returnRawDebugInformation,
                returnFileName,
                returnFileNameInAppFilesDir,
                fileNameInAppFilesPrefix,
                returnFileNameInExternalStorage,
                fileNameInExternalStoragePrefix,
                returnDimensions,
                returnMIMEType,
                returnEXIF,
                returnThumbnail,
                returnThumbnailSize
        );
        return photoExtractRequest;
    }
}
