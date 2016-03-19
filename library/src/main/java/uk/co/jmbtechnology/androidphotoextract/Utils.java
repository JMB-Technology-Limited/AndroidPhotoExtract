package uk.co.jmbtechnology.androidphotoextract;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Utils {

	protected static boolean isFileInFolder(File file, File folder) {
		if (file.getAbsolutePath().equals(folder.getAbsolutePath())) {
			return true;
		}
		File parent = file.getParentFile();
		return parent != null ? isFileInFolder(parent, folder) : false;
	}

	protected static void copyFile(File src, File dest) throws java.io.FileNotFoundException, java.io.IOException {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(src);
			out = new FileOutputStream(dest);

			// Transfer bytes from in to out
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

}
