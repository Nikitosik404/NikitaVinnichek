package dataProviders;

import org.testng.annotations.DataProvider;

import static enums.ProperTextHomePage.*;

public class HomeworkDataProviders {

    @DataProvider(parallel=true)
    public Object[][] homeworkDataProvider() {
        return new Object[][] {
                {PRACTICE.text, 0},
                {CUSTOM.text, 1},
                {MULTI.text, 2},
                {BASE.text, 3},
        };
    }
}