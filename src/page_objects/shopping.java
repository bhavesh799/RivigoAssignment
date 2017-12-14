package page_objects;

import org.openqa.selenium.By;

import GenericFunctionsPack.GenericFunctions;
import config.ConfigDetails;
import io.appium.java_client.android.AndroidDriver;

public class CheckInOut extends ConfigDetails{
	public AndroidDriver driver;
	GenericFunctions generic;

	public CheckInOut(AndroidDriver driver)
	{
		this.driver=driver;
		generic = new GenericFunctions(driver);
	}
	
	private By checkInDate_DD = By.id("com.fabhotels.propertyv2:id/tvTitle");
	private By checkOutDate_DD = By.id("com.fabhotels.propertyv2:id/tvTitle");
	private By changeDate_DD = By.id("com.fabhotels.propertyv2:id/btnChangeDate");
	private By search_Txt = By.id("com.fabhotels.propertyv2:id/search_src_text");
	private By refresh_Btn = By.id("com.fabhotels.propertyv2:id/menu_item_refresh");
	private By checkIn_Btn = By.id("com.fabhotels.propertyv2:id/btnCheckIn_Out");
	private By checkOut_Btn = By.id("com.fabhotels.propertyv2:id/btnCheckIn_Out");
	private By roomNo_Btn = By.id("com.fabhotels.propertyv2:id/etRoomNumber1");
	private By assignRoom_Btn = By.id("com.fabhotels.propertyv2:id/btnAssignment");
	private By cross_Btn = By.id("com.fabhotels.propertyv2:id/imgDismiss");
	
	public void click_CheckInDate_DD(){
		generic.clickOnElement(checkInDate_DD);
	}
	
	public void click_CheckOutDate_DD(){
		generic.clickOnElement(checkOutDate_DD);
	}
	
	public void click_ChangeDate_DD(){
		generic.clickOnElement(changeDate_DD);
	}
	
	public void click_Search_Txt(){
		generic.clickOnElement(search_Txt);
	}
	
	public void clear_Search_Txt(){
		generic.clear(search_Txt);
	}
	
	public void fill_Search_Txt(String inputdata){
		generic.fillElement(search_Txt, inputdata);
	}
	
	public void click_Refresh_Btn(){
		generic.clickOnElement(refresh_Btn);
	}

	public void click_CheckIn_Btn(){
		generic.clickOnElement(checkIn_Btn);
	}
	
	public void click_CheckOut_Btn(){
		generic.clickOnElement(checkOut_Btn);
	}
	
	public void click_RoomNo_Btn(){
		generic.clickOnElement(roomNo_Btn);
	}
	
	public void fill_RoomNo_Btn(String inputdata){
		generic.fillElement(roomNo_Btn, inputdata);
	}
	
	public void click_AssignRoom_Btn(){
		generic.clickOnElement(assignRoom_Btn);
	}
	
	public void click_Cross_Btn(){
		try{generic.clickOnElement(cross_Btn);}catch(Exception e){}
		
	}
	
	
	
	public void CheckIn(String bookingName){
		try{
		CreateReservation mobileNumber = new CreateReservation(driver);
		String roomNo = "2";
		fill_Search_Txt(bookingName);
		click_CheckIn_Btn();
		mobileNumber.click_MobileDone_Btn();
		fill_RoomNo_Btn(roomNo);
		click_AssignRoom_Btn();
		click_Cross_Btn();
		}catch(Exception e)
		{}
	}

	
	public void CheckOut(String bookingName){
		try{
		CreateReservation date = new CreateReservation(driver);
		click_ChangeDate_DD();
		date.select_CheckOutDate("30");
		fill_Search_Txt(bookingName);
		click_CheckOut_Btn();
		click_Cross_Btn();}
		catch(Exception e){}
	}



}
