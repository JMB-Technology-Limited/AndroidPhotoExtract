package uk.co.jmbtechnology.androidphotoextract;


import android.graphics.Bitmap;

/**
 *
 * Immutable Object
 *
 * @url https://github.com/JMB-Technology-Limited/AndroidPhotoExtract
 * @license Open Source - BSD
 **/
public class PhotoExtractResponse {

    protected String filename = null;

    protected String rawDebugInformation = "";

    protected Integer height = null;

    protected Integer width = null;

    protected String MIMEType = null;

    protected String EXIFMake = null;

    protected Integer EXIFOrientation = null;

    protected Bitmap thumbnail = null;


    public PhotoExtractResponse(PhotoExtractResponseInProgress photoExtractResponseInProgress) {
        this.filename = photoExtractResponseInProgress.getFilename();
        this.rawDebugInformation = photoExtractResponseInProgress.getRawDebugInformation();
        this.height = photoExtractResponseInProgress.getHeight();
        this.width = photoExtractResponseInProgress.getWidth();
        this.MIMEType = photoExtractResponseInProgress.getMIMEType();
        this.EXIFMake = photoExtractResponseInProgress.getEXIFMake();
        this.EXIFOrientation = photoExtractResponseInProgress.getEXIFOrientation();
        this.thumbnail = photoExtractResponseInProgress.getThumbnail();
    }

    public String getRawDebugInformation() {
        return rawDebugInformation;
    }

    public String getFilename() {
        return filename;
    }

    public boolean hasFilename() {
        return filename != null;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    public boolean hasWidthHeight() {
        return width != null;
    }

    public String getMIMEType() {
        return MIMEType;
    }

    public boolean hasMIMEType() {
        return MIMEType != null;
    }

    public String getEXIFMake() {
        return EXIFMake;
    }

    public boolean hasEXIFMake() {
        return EXIFMake != null;
    }

    public Integer getEXIFOrientation() {
        return EXIFOrientation;
    }

    public boolean hasEXIFOrientation() {
        return EXIFOrientation != null;
    }

    public Bitmap getThumbnail() {
        return thumbnail;
    }

    public boolean hasThumbnail() {
        return thumbnail != null;
    }
}
