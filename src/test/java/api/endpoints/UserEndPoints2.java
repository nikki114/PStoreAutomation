package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payloads.User;
import io.restassured.response.Response;
public class UserEndPoints2 
{
     static ResourceBundle getURL() //method created for getting urls from properties file.
	{
	ResourceBundle resource= ResourceBundle.getBundle("routes");
	return resource;
			
	}
	
	public static Response createUser(User payload)
	{
		String createurl=getURL().getString("postUrl");
		
		Response response=given()
		.contentType("application/json")
		.accept("application/json")
		.body(payload)
		
		.when()
		.post(createurl);
		return response;

}
	
	public static Response getUser(String username)
	{
		
		String geturl=getURL().getString("getUrl");
		Response response=given()
		.contentType("application/json")
		.accept("application/json")
		.pathParam("username", username)
		
		.when()
		.get(geturl);
		return response;

}
	
	public static Response updateUser(User payload, String username)
	{
		
		String updateurl=getURL().getString("updateUrl");
		Response response=given()
		.contentType("application/json")
		.accept("application/json")
		.body(payload)
		.pathParam("username", username)
		
		.when()
		.put(updateurl);
		return response;

}
	
	public static Response deleteUser(String username)
	{
		
		String deleteurl =getURL().getString("deleteUrl");
		Response response=given()
		.contentType("application/json")
		.accept("application/json")
		.pathParam("username", username)
		
		
		.when()
		.delete(deleteurl);
		return response;
	}

}
