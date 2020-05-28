package resources;

import org.testng.annotations.DataProvider;

public class DataProviderUser {

	@DataProvider(name = "firstUserAndPass")
	public Object[][] firstUserAndPass() {

		Object[][] data = new Object[1][2];

		data[0][0] = "kabilov.t@gmail.com";
		data[0][1] = "timur630544";
		return data;

		// return new Object[][] { { "kabilov.t@gmail.com" }, { "timur3377053"} };

	}

	@DataProvider(name = "second")
	public Object[][] URL() {
		return new Object[][] { { "https://www.booking.com" }, { "http://wwww.booking.com"}};

	}

}
