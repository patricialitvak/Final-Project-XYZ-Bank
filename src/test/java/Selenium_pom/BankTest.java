package Selenium_pom;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;


public class BankTest {

    Bank bank = new Bank();

    //check if the bank site opening
    @Test
    public void openPagePassTest() {
        String expectedUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
        String actualUrl = bank.openPage(expectedUrl);
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    //check if the customer login page opening
    @Test
    public void customerLoginPagePassTest() throws InterruptedException {
        String expectedCustomerLoginUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer";
        String actualCustomerLoginUrl = bank.customerLoginPage();
        Assert.assertEquals(expectedCustomerLoginUrl, actualCustomerLoginUrl);
    }

    //check if the customer name is valid
    @Test
    public void customerAccountPassTest() throws InterruptedException {
        String validName = "Hermoine Granger";
        String actualCustomer = bank.customerAccount(validName);
        Assert.assertEquals(validName, actualCustomer);
    }

    //check balance account after deposit
     @Test
    public void depositBalancePassTest() throws InterruptedException {
         int amount = bank.balanceAccount();
         int DepositAmount = 250;
         bank.depositAmount(DepositAmount);
         int balanceAfterDeposit = bank.balanceAccount();
         Assert.assertEquals(balanceAfterDeposit, amount + DepositAmount);
        }

    //check if the manager login page opening
    @Test
    public void managerLoginPagePassTest() throws InterruptedException {
        String expectedManagerLoginUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager";
        String actualManagerLoginUrl = bank.managerLoginPage();
        Assert.assertEquals(expectedManagerLoginUrl, actualManagerLoginUrl);
    }

    //get list of customers accounts by manager
    @Test
    public void customerListPassTest() throws InterruptedException {
        String expectedCustomerListUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list";
        String actualCustomerListUrl = bank.customersListPage();
        Assert.assertEquals(expectedCustomerListUrl, actualCustomerListUrl);
    }

    //exit from the site after each test
    @After
    public void quit(){
        bank.driver.quit();
    }
}
