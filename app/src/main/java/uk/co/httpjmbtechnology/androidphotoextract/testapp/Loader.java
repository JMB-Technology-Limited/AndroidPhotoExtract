package uk.co.httpjmbtechnology.androidphotoextract.testapp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.AsyncTaskLoader;

import uk.co.httpjmbtechnology.androidphotoextract.PhotoExtractRequest;
import uk.co.httpjmbtechnology.androidphotoextract.PhotoExtractResponse;
import uk.co.httpjmbtechnology.androidphotoextract.PhotoExtractWorkerGotResult;

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

        PhotoExtractResponse photoExtractResponse = photoExtractWorkerGotResult.process(photoExtractRequest, resultsIntent);

        return new LoaderResult(photoExtractResponse);
    }

}
