package uk.co.httpjmbtechnology.androidphotoextract.testapp;

import uk.co.httpjmbtechnology.androidphotoextract.PhotoExtractResponse;

/**
  * @url https://github.com/JMB-Technology-Limited/AndroidPhotoExtract
  * @license Open Source - BSD
  **/
public class LoaderResult {

    protected PhotoExtractResponse photoExtractResponse;

    public LoaderResult(PhotoExtractResponse photoExtractResponse) {
        this.photoExtractResponse = photoExtractResponse;
    }

    public PhotoExtractResponse getPhotoExtractResponse() {
        return photoExtractResponse;
    }
}
