package Main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Reporter;
import resources.BasePage;

import java.util.concurrent.TimeUnit;

public class Testing{

    public static WebDriver driver;
    public static MainPage mainPage;
    public static AddNewComputer addNewComputer;
    public static BasePage basePage;


    @BeforeClass
    static void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        addNewComputer = new AddNewComputer(driver);
        basePage = new BasePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://computer-database.gatling.io/computers");
    }

    @Test
    public void createNewComputer(){
        mainPage.goToAddNewComputerPage();

        basePage.waitForPageLoaded();
        addNewComputer.inputName("Adrian Test");
        addNewComputer.inputIntroduceDate();
        addNewComputer.inputDiscontinuedDate();
        addNewComputer.selectCompany();
        addNewComputer.submitCreating();

        basePage.waitForPageLoaded();
        Assert.assertTrue(mainPage.checkNewComputerAtTable("Adrian Test"), "Computer in table?");
    }

    @AfterClass
    static void afterAll(){
        driver.close();
    }


}
