package pageObjects.hw4;

import com.codeborne.selenide.SelenideElement;
import enums.Users;
import enums.hw4.Titles;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class PageObjectBase {

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = "[type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = ".profile-photo span")
    private SelenideElement loginTitle;

    //==============================methods==================================
    @Step
    public void login(Users user) {
        profileButton.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submit.click();
    }
    //==============================checks===================================
    @Step
    public void checkTitle(Titles title) {
        assertEquals(getWebDriver().getTitle(), title.title);
    }

    @Step
    public void checkLoginTitle(Users user) {
        loginTitle.shouldBe(visible);
        loginTitle.shouldHave(text(user.name));
    }

}
