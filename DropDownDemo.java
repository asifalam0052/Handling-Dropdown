package Dummy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.geodatasource.com/software/country-region-dropdown-menu-demo");
		WebElement element = driver.findElement(
				By.xpath("/html/body/div[3]/div/div/div/div/div/div[2]/div/div/div[2]/div[2]/form/div[1]/div/select"));

		Select dropdown = new Select(element);
	//	dropdown.selectByVisibleText("Aruba"); // Displayed Text from drop down//
		dropdown.selectByIndex(2);				// Displayed Text from drop down with using index value method

		// Check multiple dropdrown are there ?
		if (dropdown.isMultiple()) {
			System.out.println("Drop down is multiple");
		} else {
			System.out.println("Drop down is not multiple");
		}
		
		//Get list of element from drop down //
		List<WebElement> alldropdownlist = dropdown.getOptions();
		
		System.out.println("Total size of Dropdown :" + alldropdownlist.size()); // displayed all size from drop down list
		for (WebElement el : alldropdownlist) {
			System.out.println(el.getText()); 									//displayed all text from drop down list
		}
		
		driver.close();
	}

}
