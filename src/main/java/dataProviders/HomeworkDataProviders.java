package dataProviders;

import enums.PropperText;
import org.testng.annotations.DataProvider;

public class HomeworkDataProviders {

    @DataProvider(parallel=true)
    public Object[][] HomeworkDataProvider() {
        return new Object[][] {
                {PropperText.PRACTICE.text, 0},
                {PropperText.CUSTOM.text, 1},
                {PropperText.MULTI.text, 2},
                {PropperText.BASE.text, 3},
        };
    }
}