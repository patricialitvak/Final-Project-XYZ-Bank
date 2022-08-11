package Selenium_pom;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Bank {

    WebDriver driver;

    public Bank() {
        //change direct of the chrome driver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\patri\\Desktop\\QA\\selenium\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
    }

    //open bank site
    public String openPage(String url) {
        this.driver.get(url);
        return this.driver.getCurrentUrl();
    }

    //open customer login page
    public String customerLoginPage() throws InterruptedException {
        openPage("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        WebElement customerLoginBtn = this.driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button"));
        customerLoginBtn.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        return driver.getCurrentUrl();
    }

    // choose a valid customer account
    public String customerAccount(String name) throws InterruptedException {
        customerLoginPage();
        WebElement YourName = driver.findElement(By.name("userSelect"));
        YourName.sendKeys(name);
        YourName.click();
        WebElement LoginButton = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/button"));
        LoginButton.click();
        return driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/strong/span")).getText();
    }

    // get an account balance
    public int balanceAccount() throws InterruptedException {
        customerAccount("Hermoine Granger");
        WebElement balanceLabel = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]"));
        return Integer.parseInt(balanceLabel.getText());
    }

    //check balance account after deposit
     public String depositAmount(int actualDepositAmount) throws InterruptedException {
         balanceAccount();
         WebElement DepositTab = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]"));
         DepositTab.click();
         WebElement depositAmount = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input"));
         depositAmount.sendKeys(String.valueOf(actualDepositAmount));
         WebElement DepositClick = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button"));
         DepositClick.click();
         return driver.getCurrentUrl();
     }

    //check if the manager login page opening
    public String managerLoginPage() throws InterruptedException {
        openPage("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        WebElement BankManagerLoginBtn = this.driver.findElement(By.xpath("//*[contains(text(),'Manager')]"));
        BankManagerLoginBtn.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        return driver.getCurrentUrl();
    }

    //get list of customers accounts by manager
    public String customersListPage() throws InterruptedException {
        managerLoginPage();
        WebElement ShowCustomers = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]"));
        ShowCustomers.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        return driver.getCurrentUrl();
    }

         //exit from the site
        public void quit() {
        }
    }

