package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class signup_page{
    private WebDriver driver;

    public signup_page(WebDriver driver) {
        this.driver = driver;
    }

    // Page elements
    private By title = By.cssSelector("#title");
    private By fname = By.id("firstName");
    private By lname = By.id("lastName");
    private By gender = By.id("gender");
    private By dob = By.id("dob");
    private By ssn = By.id("ssn");
    private By email = By.id("emailAddress");
    private By pass = By.id("password");
    private By cpass = By.id("confirmPassword");
    private By next = By.xpath("/html/body/div[1]/div/div/div[2]/form/button");
    private By register = By.xpath("/html/body/div[1]/div/div/div[2]/form/button");
    private By address = By.id("address");
    private By locality = By.id("locality");
    private By region = By.id("region");
    private By postalcode = By.id("postalCode");
    private By country = By.id("country");
    private By homephone = By.id("homePhone");

    // Page methods

    public String selectPerson(String person) {
        WebElement personElement = driver.findElement(title);
        Select select = new Select(personElement);
        select.selectByVisibleText(person);
        return driver.findElement(title).getAttribute("validationMessage");
    }

    public void enterFirstname(String firstname) {
        driver.findElement(fname).sendKeys(firstname);
    }

    public void enterLastname(String lastname) {
        driver.findElement(lname).sendKeys(lastname);
    }

    public void selectGender() {
        driver.findElement(gender).click();
    }

    public void enterDOB(String dob) {
        driver.findElement(this.dob).sendKeys(dob);
//        WebElement date = driver.findElement(title);
//        Select select = new Select(date);
//        select.selectByVisibleText(person);
//        return driver.findElement(title).getAttribute("validationMessage");
    }

    public void enterSSN(String ssn) {
        driver.findElement(this.ssn).sendKeys(ssn);
    }

    public void enterEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(pass).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(cpass).sendKeys(confirmPassword);
    }

    public void clickNext() {
        driver.findElement(next).click();
    }
    public void Register() {
        driver.findElement(register).click();
    }
    public void Address(String Address) {
        driver.findElement(address).sendKeys(Address);
    }
    
    public void Locality(String Locality) {
        driver.findElement(locality).sendKeys(Locality);
    }
    
    public void Region(String Region) {
        driver.findElement(region).sendKeys(Region);
    }
    
    public void Postalcode(String Postalcode) {
        driver.findElement(postalcode).sendKeys(Postalcode);
    }
    
    public void Country(String Country) {
        driver.findElement(country).sendKeys(Country);
    }
    
    public void Homephone(String Homephone) {
        driver.findElement(homephone).sendKeys(Homephone);
    }

    // Other methods for entering address, locality, region, postal code, country, home phone
}
