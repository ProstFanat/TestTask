package Main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.BasePage;

import java.util.List;

public class AddNewComputer extends BasePage {
    public AddNewComputer(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "name")
    public WebElement computerNameInput;

    @FindBy(id = "introduced")
    public WebElement introducedInput;

    @FindBy(id = "discontinued")
    public WebElement discontinuedInput;

    @FindBy(id = "company")
    public WebElement companySelect;

    @FindBy(xpath = "//select[@id = 'company']//option")
    public List<WebElement> companiesList;

    @FindBy(xpath = "//input[@type = 'submit']")
    public WebElement createComputerButton;


    public void inputName(String name) {
        waitToBeClickable(10000, computerNameInput);
        computerNameInput.sendKeys(name);
    }

    public void inputIntroduceDate() {
        waitToVisibilityOf(10000, introducedInput);
        introducedInput.sendKeys(java.time.LocalDate.now().minusYears(10).toString());
    }

    public void inputDiscontinuedDate() {
        waitToVisibilityOf(10000, discontinuedInput);
        discontinuedInput.sendKeys(java.time.LocalDate.now().toString());
    }

    public void selectCompany() {
        waitToVisibilityOf(10000, companySelect);
        companySelect.click();
        companiesList.get(1).click();
        computerNameInput.click();
    }

    public void submitCreating() {
        waitToBeClickable(10000, createComputerButton);
        createComputerButton.click();
    }


}
