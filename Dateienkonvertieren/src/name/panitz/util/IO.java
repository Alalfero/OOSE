package name.panitz.util;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;

public class IO {
	public static void convert(String inFile, String inEncoding, String outFile, String outEncoding) throws IOException {
		try {
			BufferedReader readLeFile = new BufferedReader(new InputStreamReader(new FileInputStream(inFile), inEncoding));

			BufferedWriter writeLeFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), outEncoding));
			String tmp;
			while ((tmp = readLeFile.readLine()) != null) {
				writeLeFile.write(tmp);

			}
			readLeFile.close();
			writeLeFile.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}