import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


//selenium - deposit cash to a bank account
public class DepositByCustomer {
    public static void main(String[] args) throws InterruptedException {

        //change path/directory of chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\patri\\Desktop\\QA\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        Thread.sleep(2000);

        //enter to a customer login page
        WebElement customerLoginTab = driver.findElement(By.xpath("//*[contains(text(),'Customer Login')]"));
        customerLoginTab.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //customer login page
        WebElement UserSelect = driver.findElement(By.id("userSelect"));
        UserSelect.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //choose account
        WebElement YourName = driver.findElement(By.name("userSelect"));
        YourName.sendKeys("Harry Potter");
        YourName.click();
        WebElement LoginButton = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/button"));
        LoginButton.click();
        Thread.sleep(2000);

        //  click deposit button
        WebElement DepositTab = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]"));
        DepositTab.click();

        // enter 250 to deposit
        WebElement Amount = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input"));
        Amount.sendKeys("250");
        Thread.sleep(2000);

        //click deposit button
        WebElement DepositClick = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button"));
        DepositClick.click();
        Thread.sleep(2000);

        //click on TRANSACTION button to see the change
        WebElement TransactionBut = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[1]"));
        TransactionBut.click();
        Thread.sleep(3000);

        // click on logout button
        WebElement LogOutButton = driver.findElement(By.xpath("/html/body/div/div/div[1]/button[2]"));
        LogOutButton.click();
        Thread.sleep(1000);

        //exit the site
        System.out.println(driver.getTitle());
        System.out.println("GoodBye");
        driver.quit();
    }
}


