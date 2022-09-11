package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;


import java.io.File;

import org.openqa.selenium.By;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BrowserTest {

    //private static final String TEST_URL = "https://support.oracle.com/epmos/faces/DocumentDisplay?id=1590326.1";
    private static final String TEST_URL="https://peter.sh/experiments/chromium-command-line-switches/";
    private static final String DOWNLOAD_DIR = "/home/mosbot/test/";


    public static void DownloadWebPage() throws IOException {

        String downloadFilepath = DOWNLOAD_DIR;
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("savefile.default_directory", downloadFilepath);


        // create chrome driver
        ChromeOptions chromeOptions = new ChromeOptions();

        // chromeOptions.addArguments("headless");
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("--print-to-pdf");
        chromeOptions.addArguments("--kiosk-printing");


        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", DOWNLOAD_DIR);
        chromeOptions.setExperimentalOption("prefs", prefs);


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get(TEST_URL);
        ((JavascriptExecutor) driver).executeScript("print()");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));




        /*
        //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@id=\"sso_username\"]")).sendKeys("DunkinBrands@dataintensity.com");
        driver.findElement(By.xpath("//*[@id=\"ssopassword\"]")).sendKeys("oracle123");
        driver.findElement(By.xpath("//*[@id=\"signin_button\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.findElement(By.xpath("//img[contains(@title, 'Printable Page')]")).click();
*/

        driver.quit();














        /*

        // login to MOS
        driver.findElement(By.xpath("//*[@id=\"sso_username\"]")).sendKeys(HandlePassword.Decrypt(HandlePassword.GetProperties(HandlePassword.MOS_PROPERTIES, "username")));
        driver.findElement(By.xpath("//*[@id=\"ssopassword\"]")).sendKeys(HandlePassword.Decrypt(HandlePassword.GetProperties(HandlePassword.MOS_PROPERTIES, "password")));
        driver.findElement(By.xpath("//*[@id=\"signin_button\"]")).click();

        // wait until page is loaded
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        // driver.findElement(By.xpath("//img[contains(@title, 'Printable Page')]")).click();

        // download page as PDF
        Pdf pdf = ((PrintsPage) driver).print(new PrintOptions());
        Files.write(Paths.get(DOWNLOAD_DIR + docID + ".pdf"), OutputType.BYTES.convertFromBase64Png((pdf.getContent())));
        driver.quit();

         */

    }


    public static void main(String[] args) throws IOException, AWTException {

        BrowserTest browserTest = new BrowserTest();
        browserTest.DownloadWebPage();

    }


}
