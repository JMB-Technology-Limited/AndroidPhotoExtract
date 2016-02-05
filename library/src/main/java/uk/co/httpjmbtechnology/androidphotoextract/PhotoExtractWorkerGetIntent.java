package uk.co.httpjmbtechnology.androidphotoextract;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

/**
  * @url https://github.com/JMB-Technology-Limited/AndroidPhotoExtract
  * @license Open Source - BSD
  **/
public class PhotoExtractWorkerGetIntent {

    protected Context context;

    public PhotoExtractWorkerGetIntent(Context context) {
        this.context = context;
    }

    public  Intent getIntent(PhotoExtractRequest photoExtractRequest) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        return intent;
    }

}
