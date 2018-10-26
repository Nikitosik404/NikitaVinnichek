package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static enums.ProperTextHomePage.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeworkHomePage {
    @FindBy(css = ".profile-photo")
    private WebElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private WebElement login;

    @FindBy(css = "[id = 'Password']")
    private WebElement password;

    @FindBy(css = "[type = 'submit']")
    private WebElement submit;

    @FindBy(css = ".profile-photo > span")
    private WebElement loginTitle;

    @FindBy(css = ".m-l8 > li")
    private List<WebElement> headerItems;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> testedImages;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> imageTitles;

    @FindBy(css = ".main-title")
    private WebElement mainTitle;

    @FindBy(css = ".main-txt")
    private WebElement mainTxt;

    @FindBy(css = "iframe")
    private WebElement mainFrame;

    @FindBy(css = ".text-center > a")
    private WebElement subHeader;

    @FindBy(css = "[name='navigation-sidebar']")
    private WebElement leftSection;

    @FindBy(css = "footer")
    private WebElement footer;

    @FindBy(css = "div.epam-logo > a > img")
    private WebElement frameLogo;

    //==============================================checks==========================================

    public void checkTitle(WebDriver driver, String title) {
        assertEquals(driver.getTitle(), title);
    }

    public void checkLogin(String title) {
        assertEquals(loginTitle.getText(), title);
    }

    public void checkHeaderItemText() {
        List<String> expectedTitles = new ArrayList<>();
        expectedTitles.add(HEADER_SECTION1.text);
        expectedTitles.add(HEADER_SECTION2.text);
        expectedTitles.add(HEADER_SECTION3.text);
        expectedTitles.add(HEADER_SECTION4.text);

        assertEquals(headerItems.size(), expectedTitles.size());
        for (WebElement item : headerItems) {
            assertTrue(item.isDisplayed());
        }
        for (int i = 0; i < expectedTitles.size(); i++){
            assertEquals(headerItems.get(i).getText(), expectedTitles.get(i));
        }
    }

    public void checkIndexPageImages() {
        for (WebElement image : testedImages) {
            assertTrue(image.isDisplayed());
        }
    }

    public void checkImageTitles() {
        ArrayList<String> expectedImageTitles = new ArrayList<>();
        expectedImageTitles.add(PRACTICE.text);
        expectedImageTitles.add(CUSTOM.text);
        expectedImageTitles.add(MULTI.text);
        expectedImageTitles.add(BASE.text);

        assertEquals(imageTitles.size(), expectedImageTitles.size());
        for (WebElement item : imageTitles) {
            assertTrue(item.isDisplayed());
        }
        for (int i = 0; i < expectedImageTitles.size(); i++){
            assertEquals(imageTitles.get(i).getText(), expectedImageTitles.get(i));
        }
    }

    public void checkMainHeader(String Title, String Text) {
        assertEquals(mainTitle.getText(), Title);
        assertEquals(mainTxt.getText(), Text);
    }

    public void checkFrameDisplaying() {
        assertTrue(mainFrame.isDisplayed());
    }

    public void checkFrameLogo() {
        assertTrue(frameLogo.isDisplayed());
    }

    public void checkSubHeaderDisplaying(String subHeaderText) {
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), subHeaderText);
    }

    public void checkSubHeaderLink(String link) {
        assertEquals(subHeader.getAttribute("href"), link);
    }

    public void checkLeftSectionDisplaying() {
        assertTrue(leftSection.isDisplayed());
    }

    public void checkFooterDisplaying() {
        assertTrue(footer.isDisplayed());
    }

    //==============================================methods=========================================

    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    public void open(WebDriver driver) {
        driver.navigate().to("https://epam.github.io/JDI/index.html");
    }

    public void switchToNewFrame(WebDriver driver) {
        driver.switchTo().frame(mainFrame);
    }

    public void switchToOldFrame(WebDriver driver) {
        driver.switchTo().parentFrame();
    }
}
