package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payloads.User;
import io.restassured.response.Response;
public class UserEndPoints 
{
	
	
	public static Response createUser(User payload)
	{
		Response response=given()
		.contentType("application/json")
		.accept("application/json")
		.body(payload)
		
		.when()
		.post(Routes.createurl);
		return response;

}
	
	public static Response getUser(String username)
	{
		Response response=given()
		.contentType("application/json")
		.accept("application/json")
		.pathParam("username", username)
		
		.when()
		.get(Routes.geturl);
		return response;

}
	
	public static Response updateUser(User payload, String username)
	{
		Response response=given()
		.contentType("application/json")
		.accept("application/json")
		.body(payload)
		.pathParam("username", username)
		
		.when()
		.put(Routes.updateurl);
		return response;

}
	
	public static Response deleteUser(String username)
	{
		Response response=given()
		.contentType("application/json")
		.accept("application/json")
		.pathParam("username", username)
		
		
		.when()
		.delete(Routes.deleteurl);
		return response;
	}

}
