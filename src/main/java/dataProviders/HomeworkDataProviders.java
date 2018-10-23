package dataProviders;

import org.testng.annotations.DataProvider;

import static enums.ProperText.ProperText;

public class HomeworkDataProviders {

    @DataProvider(parallel=true)
    public Object[][] HomeworkDataProvider() {
        return new Object[][] {
                {ProperText.PRACTICE, 0},
                {ProperText.CUSTOM, 1},
                {ProperText.MULTI, 2},
                {ProperText.BASE, 3},
        };
    }
}