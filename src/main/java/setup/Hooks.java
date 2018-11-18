package setup;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test(groups = {"native","web"})
public class Hooks extends Driver {

    @BeforeSuite
    @Parameters("pathToConfig")
    public void setUp(String pathToConfig) throws Exception {
        getConfig(pathToConfig);
        prepareDriver();
    }

    @AfterSuite
    public void tearDown() throws Exception {
        driver().quit();
    }
}
