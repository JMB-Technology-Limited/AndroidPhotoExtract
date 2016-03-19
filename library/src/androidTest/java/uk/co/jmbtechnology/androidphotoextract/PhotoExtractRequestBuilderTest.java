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
		assertFalse(photoExtractRequest.isReturnFileNameInAppFilesDir());
		assertFalse(photoExtractRequest.isReturnFileNameInExternalStorage());
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
		assertFalse(photoExtractRequest.isReturnFileNameInAppFilesDir());
		assertFalse(photoExtractRequest.isReturnFileNameInExternalStorage());
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
		assertFalse(photoExtractRequest.isReturnFileNameInAppFilesDir());
		assertFalse(photoExtractRequest.isReturnFileNameInExternalStorage());
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
		assertFalse(photoExtractRequest.isReturnFileNameInAppFilesDir());
		assertFalse(photoExtractRequest.isReturnFileNameInExternalStorage());
	}

	public void testFilenameApp() {
		PhotoExtractRequestBuilder photoExtractRequestBuilder = new PhotoExtractRequestBuilder();
		photoExtractRequestBuilder.setReturnFileNameInAppFilesDir(true);

		PhotoExtractRequest photoExtractRequest = photoExtractRequestBuilder.build();

		assertFalse(photoExtractRequest.isReturnDimensions());
		assertFalse(photoExtractRequest.isReturnEXIF());
		assertFalse(photoExtractRequest.isReturnFileName());
		assertFalse(photoExtractRequest.isReturnMIMEType());
		assertFalse(photoExtractRequest.isReturnRawDebugInformation());
		assertFalse(photoExtractRequest.isReturnThumbnail());
		assertTrue(photoExtractRequest.isReturnFileNameInAppFilesDir());
		assertFalse(photoExtractRequest.isReturnFileNameInExternalStorage());
	}

	public void testFilenameExternalStorage() {
		PhotoExtractRequestBuilder photoExtractRequestBuilder = new PhotoExtractRequestBuilder();
		photoExtractRequestBuilder.setReturnFileNameInExternalStorage(true);

		PhotoExtractRequest photoExtractRequest = photoExtractRequestBuilder.build();

		assertFalse(photoExtractRequest.isReturnDimensions());
		assertFalse(photoExtractRequest.isReturnEXIF());
		assertFalse(photoExtractRequest.isReturnFileName());
		assertFalse(photoExtractRequest.isReturnMIMEType());
		assertFalse(photoExtractRequest.isReturnRawDebugInformation());
		assertFalse(photoExtractRequest.isReturnThumbnail());
		assertFalse(photoExtractRequest.isReturnFileNameInAppFilesDir());
		assertTrue(photoExtractRequest.isReturnFileNameInExternalStorage());
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
		assertFalse(photoExtractRequest.isReturnFileNameInAppFilesDir());
		assertFalse(photoExtractRequest.isReturnFileNameInExternalStorage());
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
		assertFalse(photoExtractRequest.isReturnFileNameInAppFilesDir());
		assertFalse(photoExtractRequest.isReturnFileNameInExternalStorage());
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
		assertFalse(photoExtractRequest.isReturnFileNameInAppFilesDir());
		assertFalse(photoExtractRequest.isReturnFileNameInExternalStorage());
	}

}

