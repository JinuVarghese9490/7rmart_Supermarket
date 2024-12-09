package utility;

import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.github.javafaker.Number;

public class RandomUtility {
	
	Faker faker=new Faker();


	public String createaRandomName()
	{
		return faker.name().name();
	}
	public String createFoodName()
	{
		return faker.food().ingredient();
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
	public String createRandomTimes()
	{
		return faker.date().toString();
	}
	public long createRandomNumbers()
	{
		return faker.number().randomNumber();
	}
	public String createRandomString()
	{
		return faker.finance().bic();
	}
	public int createRandomAmount()
	{
		return faker.number().numberBetween(1000, 100);
	}
	public int createRandomTimeAdjust()
	{
		return faker.number().numberBetween(12, 1);
	}
	
	public String createRandomNews() {
		return faker.gameOfThrones().character();
	}
}

