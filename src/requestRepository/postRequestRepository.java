package requestRepository;

import java.io.IOException;
import java.util.ArrayList;

import commonMethod.DataDriven;

public class postRequestRepository {

	public static String Req_postTc1() throws IOException {
		ArrayList<String> Data = DataDriven.FetchDataExcel("PostApi", "Tc1");
		String Req_Name = Data.get(1);
		String Req_Job = Data.get(2);

		String requestBody = "{\r\n" + "    \"name\": \"" + Req_Name + "\",\r\n" + "    \"job\": \"" + Req_Job
				+ "\"\r\n" + "}";
		return requestBody;
	}

	public static String Req_postTc2() throws IOException {
		ArrayList<String> Data = DataDriven.FetchDataExcel("PostApi", "Tc2");
		String Req_Name = Data.get(1);
		String Req_Job = Data.get(2);

		String requestBody = "{\r\n" + "    \"name\": \"" + Req_Name + "\",\r\n" + "    \"job\": \"" + Req_Job
				+ "\"\r\n" + "}";
		return requestBody;
	}

	public static String Req_postTc3() throws IOException {
		ArrayList<String> Data = DataDriven.FetchDataExcel("PostApi", "Tc3");
		String Req_Name = Data.get(1);
		String Req_Job = Data.get(2);

		String requestBody = "{\r\n" + "    \"name\": \"" + Req_Name + "\",\r\n" + "    \"job\": \"" + Req_Job
				+ "\"\r\n" + "}";
		return requestBody;
	}

}
