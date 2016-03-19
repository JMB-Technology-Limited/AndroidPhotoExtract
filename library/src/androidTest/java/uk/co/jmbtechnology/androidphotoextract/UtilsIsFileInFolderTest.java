package uk.co.jmbtechnology.androidphotoextract;

import android.test.AndroidTestCase;

import java.io.File;

public class UtilsIsFileInFolderTest extends AndroidTestCase {


	public void testPass1() {
		assertTrue(Utils.isFileInFolder(new File("/tmp/cats/kitten.jpg"), new File("/tmp")));
	}

	public void testFail1() {
		assertFalse(Utils.isFileInFolder(new File("/tmp/cats/kitten.jpg"), new File("/data")));
	}

}
