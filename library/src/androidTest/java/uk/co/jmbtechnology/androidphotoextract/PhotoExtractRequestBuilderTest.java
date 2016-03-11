package uk.co.jmbtechnology.androidphotoextract;


import android.test.AndroidTestCase;



public class PhotoExtractRequestBuilderTest  extends AndroidTestCase {

	public void testDefault() {
		PhotoExtractRequestBuilder photoExtractRequestBuilder = new PhotoExtractRequestBuilder();

		PhotoExtractRequest photoExtractRequest = photoExtractRequestBuilder.build();

		assertFalse(photoExtractRequest.isReturnDimensions());
		assertFalse(photoExtractRequest.isReturnEXIF());
		assertFalse(photoExtractRequest.isReturnFileName());
		assertFalse(photoExtractRequest.isReturnMIMEType());
		assertFalse(photoExtractRequest.isReturnRawDebugInformation());
		assertFalse(photoExtractRequest.isReturnThumbnail());
	}

}

