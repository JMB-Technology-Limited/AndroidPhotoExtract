package uk.co.jmbtechnology.androidphotoextract.testapp;

import uk.co.jmbtechnology.androidphotoextract.PhotoExtractError;
import uk.co.jmbtechnology.androidphotoextract.PhotoExtractResponse;

/**
  * @url https://github.com/JMB-Technology-Limited/AndroidPhotoExtract
  * @license Open Source - BSD
  **/
public class LoaderResult {

    protected PhotoExtractResponse photoExtractResponse = null;

    protected PhotoExtractError photoExtractError = null;

    public LoaderResult(PhotoExtractResponse photoExtractResponse) {
        this.photoExtractResponse = photoExtractResponse;
    }

    public LoaderResult(PhotoExtractError photoExtractError) {
        this.photoExtractError = photoExtractError;
    }

    public PhotoExtractResponse getResponse() {
        return photoExtractResponse;
    }

    public boolean isResponse() {
        return photoExtractResponse != null;
    }

    public PhotoExtractError getError() {
        return photoExtractError;
    }

    public boolean isError() {
        return photoExtractError != null;
    }
}
