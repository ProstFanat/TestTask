package Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.BasePage;
public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "add")
    public WebElement btnAddComputer;

    @FindBy(id = "searchbox")
    public WebElement filterInput;

    @FindBy(id = "searchsubmit")
    public WebElement filterButton;


    public void goToAddNewComputerPage(){
        waitToBeClickable(1000, btnAddComputer);
        btnAddComputer.click();
    }

    public void searchComputerByName(String name){
        waitToVisibilityOf(1000, filterInput);

        filterInput.click();
        filterInput.sendKeys(name);
        filterButton.click();
    }

    public Boolean checkNewComputerAtTable(String name){
        searchComputerByName(name);

        waitForPageLoaded();
        if(driver.findElement(By.xpath("//*[text() = 'Nothing to display']")).isDisplayed()){
            return false;
        } else {
            return true;
        }
    }


}
