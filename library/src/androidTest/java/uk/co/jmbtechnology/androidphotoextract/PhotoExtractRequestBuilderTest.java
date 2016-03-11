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

	public void testDimensions() {
		PhotoExtractRequestBuilder photoExtractRequestBuilder = new PhotoExtractRequestBuilder();
		photoExtractRequestBuilder.setReturnDimensions(true);

		PhotoExtractRequest photoExtractRequest = photoExtractRequestBuilder.build();

		assertTrue(photoExtractRequest.isReturnDimensions());
		assertFalse(photoExtractRequest.isReturnEXIF());
		assertFalse(photoExtractRequest.isReturnFileName());
		assertFalse(photoExtractRequest.isReturnMIMEType());
		assertFalse(photoExtractRequest.isReturnRawDebugInformation());
		assertFalse(photoExtractRequest.isReturnThumbnail());
	}

	public void testEXIF() {
		PhotoExtractRequestBuilder photoExtractRequestBuilder = new PhotoExtractRequestBuilder();
		photoExtractRequestBuilder.setReturnEXIF(true);

		PhotoExtractRequest photoExtractRequest = photoExtractRequestBuilder.build();

		assertFalse(photoExtractRequest.isReturnDimensions());
		assertTrue(photoExtractRequest.isReturnEXIF());
		assertFalse(photoExtractRequest.isReturnFileName());
		assertFalse(photoExtractRequest.isReturnMIMEType());
		assertFalse(photoExtractRequest.isReturnRawDebugInformation());
		assertFalse(photoExtractRequest.isReturnThumbnail());
	}

	public void testFilename() {
		PhotoExtractRequestBuilder photoExtractRequestBuilder = new PhotoExtractRequestBuilder();
		photoExtractRequestBuilder.setReturnFileName(true);

		PhotoExtractRequest photoExtractRequest = photoExtractRequestBuilder.build();

		assertFalse(photoExtractRequest.isReturnDimensions());
		assertFalse(photoExtractRequest.isReturnEXIF());
		assertTrue(photoExtractRequest.isReturnFileName());
		assertFalse(photoExtractRequest.isReturnMIMEType());
		assertFalse(photoExtractRequest.isReturnRawDebugInformation());
		assertFalse(photoExtractRequest.isReturnThumbnail());
	}

	public void testMIMEType() {
		PhotoExtractRequestBuilder photoExtractRequestBuilder = new PhotoExtractRequestBuilder();
		photoExtractRequestBuilder.setReturnMIMEType(true);

		PhotoExtractRequest photoExtractRequest = photoExtractRequestBuilder.build();

		assertFalse(photoExtractRequest.isReturnDimensions());
		assertFalse(photoExtractRequest.isReturnEXIF());
		assertFalse(photoExtractRequest.isReturnFileName());
		assertTrue(photoExtractRequest.isReturnMIMEType());
		assertFalse(photoExtractRequest.isReturnRawDebugInformation());
		assertFalse(photoExtractRequest.isReturnThumbnail());
	}

	public void testRawDebugInfo() {
		PhotoExtractRequestBuilder photoExtractRequestBuilder = new PhotoExtractRequestBuilder();
		photoExtractRequestBuilder.setReturnRawDebugInformation(true);

		PhotoExtractRequest photoExtractRequest = photoExtractRequestBuilder.build();

		assertFalse(photoExtractRequest.isReturnDimensions());
		assertFalse(photoExtractRequest.isReturnEXIF());
		assertFalse(photoExtractRequest.isReturnFileName());
		assertFalse(photoExtractRequest.isReturnMIMEType());
		assertTrue(photoExtractRequest.isReturnRawDebugInformation());
		assertFalse(photoExtractRequest.isReturnThumbnail());
	}

	public void testThumbnail() {
		PhotoExtractRequestBuilder photoExtractRequestBuilder = new PhotoExtractRequestBuilder();
		photoExtractRequestBuilder.setReturnThumbnail(true);

		PhotoExtractRequest photoExtractRequest = photoExtractRequestBuilder.build();

		assertFalse(photoExtractRequest.isReturnDimensions());
		assertFalse(photoExtractRequest.isReturnEXIF());
		assertFalse(photoExtractRequest.isReturnFileName());
		assertFalse(photoExtractRequest.isReturnMIMEType());
		assertFalse(photoExtractRequest.isReturnRawDebugInformation());
		assertTrue(photoExtractRequest.isReturnThumbnail());
	}

}

