package testclasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestKolorskemo 
{
	
	//Pre-conditions:
	
	WebDriver driver;
	
	@BeforeSuite
	public void setUp()
	{
		System.out.println("setup system property for chrome");
		String baseURL = "http://www.google.com";
		System.setProperty("webdriver.chrome.driver", "/Users/erickmena/Desktop/CS161Testing/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		//driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	
	@BeforeMethod
	public void tearUp()
	{
		System.out.println("Beggining Method");
		
	}
	
	//Test Case:
	
	@Test(priority=1)
	public void googleTitleTest()
	{
		System.out.println("Google Title Test");
		String title1 = driver.getTitle();
		String title1Test = "Google";
		Assert.assertEquals(title1, title1Test);
		
	}
	
	@Test(priority=2)
	public void kolorskermoTitleTest() throws AWTException
	{
		System.out.println("Kolorskemo Title Test");
		driver.get("https://staging.kolorskemo.com/");
		String title2 = driver.getTitle();
		String title2Test = "Kolorskemo";
		Assert.assertEquals(title2, title2Test);
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		
	}
	
	@Test(priority=3)
	public void kolorskermoLinkTest()
	{
		System.out.println("Link Test");
		boolean linkTest1 = driver.findElement(By.linkText("Get started")).isDisplayed();
		Assert.assertEquals(true, linkTest1);
		if(linkTest1)
		{
			System.out.println("Get started link is displaed and working");
		}
	}
	
	@Test(priority=4)
	public void kolorskermoTextTest()
	{
		String text1 = "What is Kolorskemo ?";
		boolean text1Test = driver.getPageSource().contains(text1);
		Assert.assertEquals(true, text1Test);
		if(text1Test)
		{
			System.out.println("\"" + text1 +  "\"" + " is present");
		}
		String text2 = "Kolorskemo is a online web application that intergrates machine learning technique to help artists name their color palettes.";
		boolean text2Test = driver.getPageSource().contains(text2);
		Assert.assertEquals(true, text2Test);
		if(text2Test)
		{
			System.out.println("\"" + text2 +  "\"" + " is present");
		}
		String text3 = "Set Up Your Color Palette";
		boolean text3Test = driver.getPageSource().contains(text3);
		Assert.assertEquals(true, text3Test);
		if(text3Test)
		{
			System.out.println("\"" + text3 +  "\"" + " is present");
		}
		String text4 = "SJSU CS161 Fall 2018 - machine learning project";
		boolean text4Test = driver.getPageSource().contains(text4);
		Assert.assertEquals(true, text4Test);
		if(text4Test)
		{
			System.out.println("\"" + text4 +  "\"" + " is present");
		}
		
	}
	
	@Test(priority=5)
	public void logoDisplayed()
	{
		boolean logo = driver.findElement(By.cssSelector("[src='/img/Kolorskemo-Logo-1.b113e2c5.png']")).isDisplayed();
		Assert.assertEquals(true, logo);
		if(logo)
		{
			System.out.println("Kolorskemo logo is present");
		}

	}
	
	@Test(priority=6)
	public void uploadImage() throws InterruptedException, AWTException
	{
		boolean uploadButton = driver.findElement(By.id("upload_btn")).isDisplayed();
		Assert.assertEquals(true, uploadButton);
		if(uploadButton)
		{
			System.out.println("Upload Button is present");
		}
		boolean uploadButtonClick = driver.findElement(By.xpath("//*[@id=\"upload_btn\"]")).isEnabled();
		Assert.assertEquals(true, uploadButtonClick);
		if(uploadButtonClick)
		{
			System.out.println("Upload Button is enabled");
		}
		
		TimeUnit.SECONDS.sleep(2);
		
		WebElement uploadButtonTest = driver.findElement(By.xpath("//*[@id=\"upload_btn\"]"));
		uploadButtonTest.click();
		
		
		boolean uploadFile = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[1]/form/label")).isDisplayed();
		Assert.assertEquals(true, uploadFile);
		if(uploadFile)
		{
			System.out.println("Choose a file is present");
		}
		
	
		
		boolean uploadFileClick = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[1]/form/label")).isEnabled();
		Assert.assertEquals(true, uploadFileClick);
		if(uploadFileClick)
		{
			System.out.println("Choose a file is enabled");
		}
		
		
		WebElement uploadFileTest = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[1]/form/label"));
		uploadFileTest.click();
		
		//Marco Polo
		
		Robot robot = new Robot();
		Thread.sleep(2000);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_RIGHT);
        robot.keyRelease(KeyEvent.VK_RIGHT);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        
        WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		
	}
	
	@Test (priority = 7)
	public void processImage()
	{
		boolean removeImageDisplay = driver.findElement(By.id("remove_btn")).isDisplayed();
		Assert.assertEquals(true, removeImageDisplay);
		if(removeImageDisplay)
		{
			System.out.println("Remove Image button is displayed");
		}
		boolean removeImageEnabled = driver.findElement(By.id("remove_btn")).isEnabled();
		Assert.assertEquals(true, removeImageEnabled);
		if(removeImageEnabled)
		{
			System.out.println("Remove Image button is enabled");
		}
		
		boolean processImageDisplay = driver.findElement(By.id("process_btn")).isDisplayed();
		Assert.assertEquals(true, processImageDisplay);
		if(processImageDisplay)
		{
			System.out.println("Process Image button is displayed");
		}
		boolean processImageEnabled = driver.findElement(By.id("process_btn")).isEnabled();
		Assert.assertEquals(true, processImageEnabled);
		if(processImageEnabled)
		{
			System.out.println("Process Image button is enabled");
		}
		
		WebElement processImageButton = driver.findElement(By.id("process_btn"));
		processImageButton.click();
		
		
	}
	
	@Test(priority = 8)
	public void imageUploadResult()
	{

		
		boolean colorScheme1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[3]/div/div[1]")).isDisplayed();
		Assert.assertEquals(true, colorScheme1);
		
		boolean colorScheme2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[3]/div/div[2]")).isDisplayed();
		Assert.assertEquals(true, colorScheme2);
		
		boolean colorScheme3 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[3]/div/div[3]")).isDisplayed();
		Assert.assertEquals(true, colorScheme3);
		
		boolean colorScheme4 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[3]/div/div[4]")).isDisplayed();
		Assert.assertEquals(true, colorScheme4);
		
		boolean colorScheme5 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[3]/div/div[5]")).isDisplayed();
		Assert.assertEquals(true, colorScheme5);
		
		if(colorScheme1 && colorScheme2 && colorScheme3 && colorScheme4 && colorScheme5)
		{
			System.out.println("Color Scheme generates just fine");
		}
		
        WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		
	}
	
	@Test(priority = 9)
	public void analyzeButtonImage() throws InterruptedException
	{
		boolean analyzeButton = driver.findElement(By.id("scheme_btn")).isDisplayed();
		Assert.assertEquals(true, analyzeButton);
		if(analyzeButton)
		{
			System.out.println("Analyze Button is Displayed");
		}
		
		Thread.sleep(2000);
		
		WebElement clickAnalyzeButton = driver.findElement(By.id("scheme_btn"));
		clickAnalyzeButton.click();
		
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		
		
		String sn = "Scheme Name:";
		
		boolean schemeNameHolder = driver.getPageSource().contains(sn);
		
		Assert.assertEquals(true, schemeNameHolder);
		
		if(schemeNameHolder)
		{
			System.out.println("Scheme Name Generator works fine");
		}

		Thread.sleep(50000);
	}
	
	@Test (priority = 10)
	public void testColorSelector() throws InterruptedException, AWTException
	{
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/ul/li/a")).click();
		
		boolean manualButton = driver.findElement(By.id("colors_btn")).isDisplayed();
		
		Assert.assertEquals(true, manualButton);
		
		if(manualButton)
		{
			System.out.println("Manually Choose colors button is displayed");
		}
		
		WebElement html = driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("colors_btn")).click(); 
		
		boolean color1 = driver.findElement(By.id("0")).isDisplayed();
		
		boolean color2 = driver.findElement(By.id("1")).isDisplayed();
		
		boolean color3 = driver.findElement(By.id("2")).isDisplayed();
		
		boolean color4 = driver.findElement(By.id("3")).isDisplayed();
		
		boolean color5 = driver.findElement(By.id("4")).isDisplayed();
		
		Assert.assertEquals(true, color1);
		Assert.assertEquals(true, color2);
		Assert.assertEquals(true, color3);
		Assert.assertEquals(true, color4);
		Assert.assertEquals(true, color5);
		
		if(color1 && color2 && color3 && color4 && color5)
		{
			System.out.println("Color Options Displayed");
		}
		
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		
		Robot robot = new Robot();
		
		String sampleJS1 = "document.getElementById('0').value='#101530'";
		String sampleJS2 = "document.getElementById('1').value='#494251'";
		String sampleJS3 = "document.getElementById('2').value='#9FA2A6'";
		String sampleJS4 = "document.getElementById('3').value='#89D24A'";
		String sampleJS5 = "document.getElementById('4').value='#EC4041'";
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(sampleJS1);
		robot.keyPress(KeyEvent.VK_ESCAPE);
		Thread.sleep(1000);
		js.executeScript(sampleJS2);
		robot.keyPress(KeyEvent.VK_ESCAPE);
		Thread.sleep(1000);
		js.executeScript(sampleJS3);
		robot.keyPress(KeyEvent.VK_ESCAPE);
		Thread.sleep(1000);
		js.executeScript(sampleJS4);
		robot.keyPress(KeyEvent.VK_ESCAPE);
		Thread.sleep(1000);
		js.executeScript(sampleJS5);
		robot.keyPress(KeyEvent.VK_ESCAPE);
		Thread.sleep(5000);
		
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		
		boolean analyzeButton = driver.findElement(By.id("process_color")).isDisplayed();
		Assert.assertEquals(true, analyzeButton);
		
		if(analyzeButton)
		{
			System.out.println("Analyze Button is displayed");
		}
		
		driver.findElement(By.id("process_color")).click();
		
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		html.sendKeys(Keys.chord(Keys.ARROW_DOWN));
		
		Thread.sleep(50000);
		
	}
	
	//Post-conditions:
	
	@AfterTest
	public void deleteAllCookies()
	{
		System.out.println("Delete All Cookies");
		driver.manage().deleteAllCookies();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("Close Browser");
		//driver.close();
	}
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("Ending Method");
		//driver.quit();
	}
	
	@AfterSuite
	public void generateTestReport() throws AWTException
	{
		System.out.println("Generated Test Report");
		driver.get("file:///Users/erickmena/eclipse-workspace/WebSiteTesting/test-output/index.html");
		driver.findElement(By.cssSelector(""));
	}
	
}
