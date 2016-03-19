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

    public PhotoExtractRequestBuilder setReturnRawDebugInformation(boolean returnRawDebugInformation) {
        this.returnRawDebugInformation = returnRawDebugInformation;
        return this;
    }

    public boolean isReturnFileName() {
        return returnFileName;
    }

    public PhotoExtractRequestBuilder setReturnFileName(boolean returnFileName) {
        this.returnFileName = returnFileName;
        return this;
    }

    public boolean isReturnDimensions() {
        return returnDimensions;
    }

    public PhotoExtractRequestBuilder setReturnDimensions(boolean returnDimensions) {
        this.returnDimensions = returnDimensions;
        return this;
    }

    public boolean isReturnMIMEType() {
        return returnMIMEType;
    }

    public PhotoExtractRequestBuilder setReturnMIMEType(boolean returnMIMEType) {
        this.returnMIMEType = returnMIMEType;
        return this;
    }

    public boolean isReturnEXIF() {
        return returnEXIF;
    }

    public PhotoExtractRequestBuilder setReturnEXIF(boolean returnEXIF) {
        this.returnEXIF = returnEXIF;
        return this;
    }

    public boolean isReturnThumbnail() {
        return returnThumbnail;
    }

    public PhotoExtractRequestBuilder setReturnThumbnail(boolean returnThumbnail) {
        this.returnThumbnail = returnThumbnail;
        return this;
    }

    public int getReturnThumbnailSize() {
        return returnThumbnailSize;
    }

    public PhotoExtractRequestBuilder setReturnThumbnailSize(int returnThumbnailSize) {
        this.returnThumbnailSize = returnThumbnailSize;
        return this;
    }

    public String getFileNameInAppFilesPrefix() {
        return fileNameInAppFilesPrefix;
    }

    public PhotoExtractRequestBuilder setFileNameInAppFilesPrefix(String fileNameInAppFilesPrefix) {
        this.fileNameInAppFilesPrefix = fileNameInAppFilesPrefix;
        return this;
    }

    public String getFileNameInExternalStoragePrefix() {
        return fileNameInExternalStoragePrefix;
    }

    public PhotoExtractRequestBuilder setFileNameInExternalStoragePrefix(String fileNameInExternalStoragePrefix) {
        this.fileNameInExternalStoragePrefix = fileNameInExternalStoragePrefix;
        return this;
    }

    public boolean isReturnFileNameInAppFilesDir() {
        return returnFileNameInAppFilesDir;
    }

    public PhotoExtractRequestBuilder setReturnFileNameInAppFilesDir(boolean returnFileNameInAppFilesDir) {
        this.returnFileNameInAppFilesDir = returnFileNameInAppFilesDir;
        return this;
    }

    public boolean isReturnFileNameInExternalStorage() {
        return returnFileNameInExternalStorage;
    }

    public PhotoExtractRequestBuilder setReturnFileNameInExternalStorage(boolean returnFileNameInExternalStorage) {
        this.returnFileNameInExternalStorage = returnFileNameInExternalStorage;
        return this;
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
