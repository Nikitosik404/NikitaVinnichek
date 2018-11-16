package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class HomePageSelenideCucumber {

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = "[type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = "h3.main-title")
    private SelenideElement mainText;

    public HomePageSelenideCucumber() {
        page(this);
    }

    //================================methods===================================
//    @When("I'm on the Home Page")
//    public void openPage() {
//        open("https://epam.github.io/JDI/index.html");
//    }
//
//    @When("I login as user (.+) with password (.+)")
//    public void login(String name, String passwd) {
//        profileButton.click();
//        login.sendKeys(name);
//        password.sendKeys(passwd);
//        submit.click();
//    }
//
//    //================================checks===================================
//
//    @Then("The browser title is Home Page$")
//    public void checkTitle() {
//        assertEquals(getWebDriver().getTitle(), "Home Page");
//    }
//
//    @Then("The user icon is displayed on the header")
//    public void checkUserIcon() {
//        profileButton.shouldBe(Condition.visible);
//    }
}
