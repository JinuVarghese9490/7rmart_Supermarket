package utility;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.github.javafaker.Number;

public class RandomUtility {
	
	Faker faker=new Faker();


	public String createaRandomName()
	{
		return faker.name().name();
	}

	public String createaRandomPassword()
	{
		return faker.number().digits(5); 
	}
	
	public String createRandomAddress()
	{
		return faker.address().fullAddress();
	}
	
	public String createRandomPnoneNumber()
	{
		return faker.phoneNumber().phoneNumber();
	}
	
	public String createRandomIndustries()
	{
		return faker.company().industry();
	}
	
	public String createRandomEmailAddress()
	{
		return faker.internet().emailAddress();
	}
}
