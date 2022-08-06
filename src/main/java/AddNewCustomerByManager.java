import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


//insert a new customer by bank manager
public class AddNewCustomerByManager{
    public static void main(String[] args) throws InterruptedException {

        //change direct/path of chrome driver
        System.setProperty("webdriver.chrome.driver","C:\\Users\\patri\\Desktop\\QA\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        Thread.sleep(2000);


        // click on button manager login
        WebElement BankManagerLogin = driver.findElement(By.xpath("//*[contains(text(),'Manager')]"));
        BankManagerLogin.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //click on add customer tab
        WebElement AddCustomer = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]"));
        AddCustomer.click();
        Thread.sleep(2000);

        // insert details of the customer - first name, last name and post code
        WebElement FirstName = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input"));
        FirstName.sendKeys("Patricia");
        Thread.sleep(1000);
        WebElement LastName = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input"));
        LastName.sendKeys("Litvak");
        Thread.sleep(1000);
        WebElement PostCode = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input"));
        PostCode.sendKeys("E65739");
        Thread.sleep(2000);

        //click on add customer button
        WebElement AddCustomerButton = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button"));
        AddCustomerButton.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //popup close
        driver.switchTo().alert().accept();

        // click on home button
        WebElement BackHome = driver.findElement(By.xpath("/html/body/div/div/div[1]/button[1]"));
        BackHome.click();
        Thread.sleep(2000);

        // enter to a bank manager page
        WebElement BankManagerPage = driver.findElement(By.xpath("//*[contains(text(),'Manager')]"));
         BankManagerPage.sendKeys(Keys.ENTER);
         Thread.sleep(2000);

        //show all the bank customers
        WebElement ShowCustomers = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]"));
        ShowCustomers.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //SEARCH CUSTOMER
        WebElement SearchCustomers = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div/div/input"));
        SearchCustomers.sendKeys("Patricia");
        ShowCustomers.sendKeys(Keys.ENTER);
        Thread.sleep(4000);

        //EXIT THE SITE
        System.out.println(driver.getTitle());
        System.out.println("GoodBye");
        driver.quit();
    }
}
