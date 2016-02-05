package uk.co.httpjmbtechnology.androidphotoextract;


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

    public PhotoExtractRequest(
            boolean returnRawDebugInformation,
            boolean returnFileName,
            boolean returnDimensions,
            boolean returnMIMEType,
            boolean returnEXIF,
            boolean returnThumbnail,
            int returnThumbnailSize) {
        this.returnRawDebugInformation = returnRawDebugInformation;
        this.returnFileName = returnFileName;
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
}
