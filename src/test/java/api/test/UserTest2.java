package api.test;

import org.testng.annotations.*;



import com.github.javafaker.Faker;

import api.payloads.User;
import io.restassured.response.Response;
import api.endpoints.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;


public class UserTest2 

{
	
	public Logger logger;
	
	Faker fake;
	User user;
	@BeforeClass
	void Createdate()
	{
		fake= new Faker();
		user= new User();
		
		user.setUsername(fake.name().username());
		user.setFirstNam(fake.name().firstName());
		user.setLastName(fake.name().lastName());
		user.setId(fake.idNumber().hashCode());
		user.setPassword(fake.internet().password(5,10));
		user.setEmail(fake.internet().emailAddress());
		user.setPhone(fake.phoneNumber().cellPhone());
		
		
		logger= LogManager.getLogger(this.getClass());
		}
	
	@Test
	void testPostUser()
	{
		logger.info("-------Creating User-------------");
		Response res=UserEndPoints2.createUser(user);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(),200);
		logger.info("-------Created User-------------");
	}
	
	@Test(priority=2)
	void testGetUser()
	{
		logger.info("-------getting User-------------");
		Response res1=UserEndPoints2.getUser(this.user.getUsername());
		res1.then().log().body();
		Assert.assertEquals(res1.getStatusCode(),200);
		logger.info("------- User details-------------");
		

	}
	
	@Test(priority=3)
	void testupdateUser()
	{
		
		logger.info("-------updating User-------------");
		user.setFirstNam(fake.name().firstName());
		user.setLastName(fake.name().lastName());
		user.setId(fake.idNumber().hashCode());
		user.setPassword(fake.internet().password(5,10));
		user.setEmail(fake.internet().emailAddress());
		user.setPhone(fake.phoneNumber().cellPhone());
		
		Response res2=UserEndPoints2.updateUser(user,this.user.getUsername());
		res2.then().log().all();
		Response res1=UserEndPoints2.getUser(this.user.getUsername());
		res1.then().log().all();
		Assert.assertEquals(res1.getStatusCode(),200);
		logger.info("-------updated User-------------");
		
		
	}
	
	@Test(priority=4)
	void testDeleteuser()
	{
		logger.info("-------deleting User-------------");
		Response res=UserEndPoints2.deleteUser(this.user.getUsername());
		Assert.assertEquals(res.getStatusCode(),200);
		logger.info("------- User deleted-------------");
		
		
	}
	
}
