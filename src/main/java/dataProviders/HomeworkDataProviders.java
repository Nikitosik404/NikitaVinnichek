package dataProviders;

import org.testng.annotations.DataProvider;

public class HomeworkDataProviders {

    @DataProvider(parallel=true)
    public Object[][] HomeworkDataProvider() {
        return new Object[][] {
                {PopperText.PRACTICE, 0},
                {PopperText.CUSTOM, 1},
                {PopperText.MULTI, 2},
                {PopperText.BASE, 3},
        };
    }
}