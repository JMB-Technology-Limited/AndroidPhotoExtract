package uk.co.jmbtechnology.androidphotoextract.testapp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.AsyncTaskLoader;

import uk.co.jmbtechnology.androidphotoextract.PhotoExtractError;
import uk.co.jmbtechnology.androidphotoextract.PhotoExtractRequest;
import uk.co.jmbtechnology.androidphotoextract.PhotoExtractResponse;
import uk.co.jmbtechnology.androidphotoextract.PhotoExtractWorkerGotResult;

/**
  * @url https://github.com/JMB-Technology-Limited/AndroidPhotoExtract
  * @license Open Source - BSD
  **/
public class Loader extends AsyncTaskLoader<LoaderResult> {

    protected PhotoExtractRequest photoExtractRequest;
    protected  Intent resultsIntent;

    public Loader(Context context, PhotoExtractRequest photoExtractRequest, Intent resultsIntent) {
        super(context);
        this.photoExtractRequest = photoExtractRequest;
        this.resultsIntent = resultsIntent;
    }

    @Override
    public LoaderResult loadInBackground() {

        PhotoExtractWorkerGotResult photoExtractWorkerGotResult = new PhotoExtractWorkerGotResult(getContext());

        try {
            PhotoExtractResponse photoExtractResponse = photoExtractWorkerGotResult.process(photoExtractRequest, resultsIntent);
            return new LoaderResult(photoExtractResponse);
        } catch (PhotoExtractError photoExtractError) {
            photoExtractError.getOriginalThrowable().printStackTrace();
            return new LoaderResult(photoExtractError);
        }

    }

}
