package org.chd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class UploadUtil {

	private static final String DATABASE_DEST = "database";

	private static final String FILE_DEST = "file";

	private static final int MAX_SIZE = 5*1024 * 1024;

	private static final String[] TYPES = { ".pdf", ".zip", ".rar",".txt",".doc"};

	public static void saveFile(String fileName, byte[] fileData, int size,

	String dest) throws FileNotFoundException, IOException {

		if (!checkSize(size)) {

			throw new IOException(size + " is too large !");

		}

		if (!checkType(fileName)) {

			throw new IOException("Unvaildate type !");

		}

		if (dest.equals(DATABASE_DEST)) {

			saveToDb(fileName, fileData);

		}

		if (dest.equals(FILE_DEST)) {

			saveToFile(fileName, fileData);

		}

	}

	private static void saveToDb(String fileName, byte[] fileData) {

	}

	private static void saveToFile(String fileName, byte[] fileData)

	throws FileNotFoundException, IOException {

		OutputStream o = new FileOutputStream(fileName);

		o.write(fileData);

		o.close();

	}

	public static void delFile(String fileName, String dest)

	throws NullPointerException, SecurityException {

		if (dest.equals(DATABASE_DEST)) {

			delFromDb(fileName);

		}

		if (dest.equals(FILE_DEST)) {

			delFromFile(fileName);

		}

	}

	private static void delFromDb(String fileName) {

	}

	private static void delFromFile(String fileName)

	throws NullPointerException, SecurityException {

		File file = new File(fileName);

		if (file.exists())

			file.delete();

	}

	private static boolean checkSize(int size) {

		if (size > MAX_SIZE)

			return false;

		return true;

	}

	private static boolean checkType(String fileName) {

		for (int i = 0; i < TYPES.length; i++) {

			if (fileName.toLowerCase().endsWith(TYPES[i])) {

				return true;

			}

		}

		return false;

	}

}
