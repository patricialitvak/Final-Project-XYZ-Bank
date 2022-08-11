import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


        //insert a new customer by bank manager
public class AddNewCustomerByManager{
    public static void main(String[] args) throws InterruptedException {

        //change direct of chrome driver path
        System.setProperty("webdriver.chrome.driver","C:\\Users\\patri\\Desktop\\QA\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        Thread.sleep(2000);


        // click on button manager login
        WebElement bankManagerLogin = driver.findElement(By.xpath("//*[contains(text(),'Manager')]"));
        bankManagerLogin.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //click on add customer tab
        WebElement addCustomer = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]"));
        addCustomer.click();
        Thread.sleep(2000);

        // insert details of the customer - first name, last name and post code
        WebElement firstName = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input"));
        firstName.sendKeys("Patricia");
        Thread.sleep(1000);
        WebElement lastName = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input"));
        lastName.sendKeys("Litvak");
        Thread.sleep(1000);
        WebElement postCode = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input"));
        postCode.sendKeys("E65739");
        Thread.sleep(2000);

        //click on add customer button
        WebElement addCustomerButton = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button"));
        addCustomerButton.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //popup close
        driver.switchTo().alert().accept();

        // click on home button
        WebElement backHomePage = driver.findElement(By.xpath("/html/body/div/div/div[1]/button[1]"));
        backHomePage.click();
        Thread.sleep(2000);

        // enter to a bank manager page
        WebElement bankManagerPage = driver.findElement(By.xpath("//*[contains(text(),'Manager')]"));
        bankManagerPage.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //show all the bank customers
        WebElement showCustomers = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]"));
        showCustomers.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //search customer
        WebElement searchCustomers = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div/div/input"));
        searchCustomers.sendKeys("Patricia");
        searchCustomers.sendKeys(Keys.ENTER);
        Thread.sleep(4000);

        //exit the site
        System.out.println(driver.getTitle());
        System.out.println("GoodBye");
        driver.quit();
    }
}
