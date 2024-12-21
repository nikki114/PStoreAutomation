package api.test;

import org.testng.Assert;
import org.testng.annotations.*;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests 
{
	@Test(priority=1,dataProvider="Data", dataProviderClass=DataProviders.class)
	void testPostUser(String userID, String userName, String fname, String lname, String useremail, String pwd, String ph)
	{
		User user=new User();
		user.setId(Integer.parseInt(userID));
		user.setUsername(userName);
		user.setFirstNam(fname);
		user.setLastName(lname);
		user.setEmail(useremail);
		user.setPassword(pwd);
		user.setPhone(ph);

		Response res=UserEndPoints.createUser(user);
		Assert.assertEquals(res.getStatusCode(),200);
	
	
	}

	
	
	
	@Test(priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void testDeleteUserByName(String userName)
	
	{
		
		Response res=UserEndPoints.deleteUser(userName);
		Assert.assertEquals(res.getStatusCode(), 200);
		
		
		
		
	}
	
	
	
	
	
}
