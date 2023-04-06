package patchTestCases;

import static io.restassured.RestAssured.given;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import requestRepository.patchRequestRepository;

public class patchTc1 {

	public static void testResponse() {
		// TODO Auto-generated method stub
		// define base URL
		RestAssured.baseURI = "https://reqres.in/";
		// configure and Trigger API

		String responseBody = given().header("Content-Type", "application/json")
				.body(patchRequestRepository.Req_patchTc1()).when()
				.patch("/api/users/2").then().extract().response().asString();

		System.out.println(responseBody);

		JsonPath jsp = new JsonPath(responseBody);

		String res_name = jsp.getString("name");
		System.out.println(res_name);

		String res_job = jsp.getString("job");
		System.out.println(res_job);

		String res_updateat = jsp.getString("updatedAt");
		System.out.println(res_updateat);

		// validate response by TestNG

		Assert.assertEquals(res_name, "morpheus");
		Assert.assertEquals(res_job, "zion resident");

		// date validate

		String updated_date = res_updateat.substring(0, 10);
		System.out.println(updated_date);

		Date sys_date = new Date();
		System.out.println(sys_date);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String format_sys_date = formatter.format(sys_date);
		System.out.print(format_sys_date);

		Assert.assertEquals(updated_date, format_sys_date);

	}

}