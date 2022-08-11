import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class DepositByCustomer {
    public static void main(String[] args) throws InterruptedException {

        //change directory of chrome driver path
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
        WebElement userSelect = driver.findElement(By.id("userSelect"));
        userSelect.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //choose an account
        WebElement yourName = driver.findElement(By.name("userSelect"));
        yourName.sendKeys("Harry Potter");
        yourName.click();
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/button"));
        loginButton.click();
        Thread.sleep(2000);

        //click on deposit tab
        WebElement depositTab = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]"));
        depositTab.click();

        //enter 250 to deposit
        WebElement amount = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input"));
        amount.sendKeys("250");
        Thread.sleep(2000);

        //click on deposit button
        WebElement depositBtn = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button"));
        depositBtn.click();
        Thread.sleep(2000);

        //click on transaction button to see the change
        WebElement transactionBut = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[1]"));
        transactionBut.click();
        Thread.sleep(3000);

        // click on logout button
        WebElement logOutButton = driver.findElement(By.xpath("/html/body/div/div/div[1]/button[2]"));
        logOutButton.click();
        Thread.sleep(1000);

        //exit the site
        System.out.println(driver.getTitle());
        System.out.println("GoodBye");
        driver.quit();
    }
}


