package requestRepository;

public class putRequestRepository {
	public static String Req_putTc1() {
		String requestBody="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}";
		return requestBody;
	}
	public static String Req_putTc2() {
		String requestBody="{\r\n"
				+ "    \"name\": \"M@orpheus\",\r\n"
				+ "    \"job\": \"Z@ion Resident\"\r\n"
				+ "}";
		return requestBody;
	}
	public static String Req_putTc3() {
		String requestBody="{\r\n"
				+ "    \"name\": \"MORPHEOUS\",\r\n"
				+ "    \"job\": \"ZION #####\"\r\n"
				+ "}";
		return requestBody;
	}


}
