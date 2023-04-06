package commonMethod;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EvidenceFileCreator {

	public static void evidencetxtfileCreator(String filename, String request_Body, String response_Body)
			throws IOException {
		for (int i = 0; i < 5; i++) {
			// create a file
			File file = new File("C:\\Users\\91986\\OneDrive\\Desktop\\RA_EvidenceRepo\\" + filename + ".txt");
			// write a file
			FileWriter writeData = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(writeData);

			bw.write(request_Body + "\n");
			writeData.write(response_Body);
			bw.close();
		}
	}
}
