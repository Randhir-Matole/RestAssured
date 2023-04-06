package requestRepository;

public class patchRequestRepository {
	public static String Req_patchTc1() {
		String requestBody="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}";
		return requestBody;
	}
	public static String Req_patchTc2() {
		String requestBody="{\r\n"
				+ "    \"name\": \"MORPHEOUS\",\r\n"
				+ "    \"job\": \"ZION RESIDENT\"\r\n"
				+ "}";
		return requestBody;
	}
	public static String Req_patchTc3() {
		String requestBody="{\r\n"
				+ "    \"name\": \"Mor@pheous\",\r\n"
				+ "    \"job\": \"Zion Resident\"\r\n"
				+ "}";
		return requestBody;
	}

}
