package fab_testSuite;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import GenericFunctionsPack.GenericFunctions;
import config.ConfigDetails;
import io.appium.java_client.android.AndroidDriver;
import page_objects.CheckInOut;
import page_objects.CreateReservation;
import page_objects.Dashboard;
import page_objects.LoginPage;

public class TestSuite extends ConfigDetails {

	public AndroidDriver driver = null;
	GenericFunctions generic;
	CheckInOut checkInOut;
	CreateReservation reservation;
	Dashboard dashboard;
	LoginPage login;

	@BeforeMethod(firstTimeOnly = true)
	public void StartDriver() {
		generic = new GenericFunctions(driver);
		try {
			driver = generic.startDriver(AppPath,AppPackage,AppActivity);
		} catch (IOException | InterruptedException e) {
			
			e.printStackTrace();
		}

		checkInOut = new CheckInOut(driver);
		reservation = new CreateReservation(driver);
		dashboard = new Dashboard(driver);
		login = new LoginPage(driver);


	}

	@AfterMethod(lastTimeOnly = true)
	public void stopDriver() {
		generic.stopDriver(AppPackage);
	}

	@Test(description="Create Reservation, Check-In and Check-out Flow ")
	public void TC_001_Test() throws ParseException{

		login.LoginInApp(userName, password);

		generic.goToSleep(5000);
		if(generic.isVisible(By.id("com.android.packageinstaller:id/permission_allow_button")))
		{
			driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();		
			driver.navigate().back();
			login.click_Login_Btn();
		}

		dashboard.click_CreateReservation_Btn();
		reservation.CreateReservation();
		generic.goToSleep(3000);
		dashboard.click_CheckInGuest_Btn();	
		generic.goToSleep(1000);
		checkInOut.CheckIn(nameOnBooking);
		driver.navigate().back();
		generic.goToSleep(3000);
		dashboard.click_CheckOutGuest_Btn();
		checkInOut.CheckOut(nameOnBooking);
	}
}
