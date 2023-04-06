package postTestCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import commonMethod.DataDriven;
import commonMethod.EvidenceFileCreator;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import requestRepository.postRequestRepository;

public class postTc2 {

	// Method1=TestCaseExecuter
	@Test
	public static void post_Executer_Tc2() throws IOException {
		for (int i = 0; i < 3; i++) {
			int statuscode = postTc2.testResponseStatusCode();
			if (statuscode == 201) {
				String responseBody = postTc2.testResponseBody();
				postTc2.testResponseBodyValidator(responseBody);
				EvidenceFileCreator.evidencetxtfileCreator("postTc2_Evidence", postRequestRepository.Req_postTc2(),
						responseBody);
				break;
			} else {
				System.out.println("Response Status code is not expected");
			}
		}
	}

	// Method2= fetch statusCode
	public static int testResponseStatusCode() throws IOException {
		// define base url
		RestAssured.baseURI = "https://reqres.in";

		// configure and trigger the API
		int responseStatusCode = given().header("Content-Type", "application/json")
				.body(postRequestRepository.Req_postTc2()).when().post("/api/users").then().extract().statusCode();
		return responseStatusCode;
	}

	// Method3=Fetch ResponseBody
	public static String testResponseBody() throws IOException {

		// define base url
		RestAssured.baseURI = "https://reqres.in";

		// configure and trigger the API
		String responseBody = given().header("Content-Type", "application/json")
				.body(postRequestRepository.Req_postTc2()).when().post("/api/users").then().extract().response()
				.asString();
		System.out.println(responseBody);
		return responseBody;

	}

	// Method4=validate the responseBody
	public static void testResponseBodyValidator(String responseBody) throws IOException {

		// fetch the reponse body parameter
		ArrayList<String> Data = DataDriven.FetchDataExcel("PostApi", "Tc2");
		String req_name = Data.get(1);
		String req_job = Data.get(2);

		JsonPath jsp = new JsonPath(responseBody);

		String res_name = jsp.getString("name");
		System.out.println(res_name);

		String res_job = jsp.getString("job");
		System.out.println(res_job);

		String res_id = jsp.getString("id");
		System.out.println(res_id);

		String res_createdAt = jsp.getString("createdAt");
		System.out.println(res_createdAt);

		// validate the respone body using testNG
		Assert.assertEquals(res_name, req_name);
		Assert.assertEquals(res_job, req_job);

		Assert.assertNotEquals(res_id, 0);
		// Assert.assertNotNull(res_id);

		// date validate
		String created_date = res_createdAt.substring(0, 10);
		System.out.println(created_date);

		Date sys_date = new Date();
		System.out.println(sys_date);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String format_sys_date = formatter.format(sys_date);

		Assert.assertEquals(created_date, format_sys_date);

	}

}
