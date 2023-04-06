package putTestCases;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import requestRepository.putRequestRepository;

import static io.restassured.RestAssured.given;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;

public class putTc3 {

	public static void testResponse() {
		// TODO Auto-generated method stub
		// define Base URL

		RestAssured.baseURI = "https://reqres.in";

		// configure and Trigger API
		String responseBody = given().header("Content-Type", "application/json")
				.body(putRequestRepository.Req_putTc3()).when()
				.put("/api/users/2").then().extract().response().asString();
		System.out.println(responseBody);

		JsonPath jsp = new JsonPath(responseBody);

		String res_name = jsp.getString("name");
		System.out.println(res_name);

		String res_job = jsp.getString("job");
		System.out.println(res_job);

		String res_updatedAt = jsp.getString("updatedAt");
		System.out.println(res_updatedAt);

		// validate response body by testNG

		Assert.assertEquals(res_name, "MORPHEOUS");
		Assert.assertEquals(res_job, "ZION #####");

		// validate date

		String created_date = res_updatedAt.substring(0, 10);
		System.out.println(created_date);

		Date sys_date = new Date();
		System.out.println(sys_date);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String format_sys_date = formatter.format(sys_date);
		System.out.print(format_sys_date);

		Assert.assertEquals(created_date, format_sys_date);

	}

}