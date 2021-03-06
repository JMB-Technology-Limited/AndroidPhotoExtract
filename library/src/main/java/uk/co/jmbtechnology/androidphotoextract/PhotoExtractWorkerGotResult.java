package uk.co.jmbtechnology.androidphotoextract;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
  * @url https://github.com/JMB-Technology-Limited/AndroidPhotoExtract
  * @license Open Source - BSD
  **/
public class PhotoExtractWorkerGotResult {

    protected Context context;

    public PhotoExtractWorkerGotResult(Context context) {
        this.context = context;
    }

    public PhotoExtractResponse process(PhotoExtractRequest photoExtractRequest, Intent resultIntent) throws PhotoExtractError {

        PhotoExtractResponseInProgress photoExtractResponseInProgress = new PhotoExtractResponseInProgress();

        Uri uri = resultIntent.getData();

        photoExtractResponseInProgress.process(context, uri, photoExtractRequest);

        return new PhotoExtractResponse(photoExtractResponseInProgress);

    }

}
