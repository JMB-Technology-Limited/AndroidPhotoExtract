package uk.co.jmbtechnology.androidphotoextract;

import java.io.File;

public class Utils {

	protected static boolean isFileInFolder(File file, File folder) {
		if (file.getAbsolutePath().equals(folder.getAbsolutePath())) {
			return true;
		}
		File parent = file.getParentFile();
		return parent != null ? isFileInFolder(parent, folder) : false;
	}

}
