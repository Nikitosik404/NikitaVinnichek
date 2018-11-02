package dataProviders;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import json.TestData;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;

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

    @DataProvider
    public Object[][] checkMetalsAndColorsPageDataProvider() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonObject jDataSet = new JsonParser().parse(new FileReader
                ("src/test/resources/JDI_ex8_metalsColorsDataSet.json")).getAsJsonObject();
        Object[][] result = new Object[jDataSet.size()][1];
        for (int i = 1; i <= jDataSet.size(); i++){
            result[i - 1][0] = gson.fromJson(jDataSet.get("data_" + i), TestData.class);
        }
        return result;
    }
}