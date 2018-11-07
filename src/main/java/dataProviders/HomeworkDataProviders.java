package dataProviders;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import json.MetalAndColorsData;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static enums.ProperTextHomePage.*;
import static enums.jdi.DataWay.DATA_WAY;

public class HomeworkDataProviders {
    @DataProvider
    public static Object[][] metalsAndColorsDataProvider() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonObject jDataSet = new JsonParser().parse(new FileReader(DATA_WAY.toString())).getAsJsonObject();
        Object[][] result = new Object[jDataSet.size()][1];
        for (int i = 0; i <= jDataSet.size() - 1; i++) {
            result[i][0] = gson.fromJson(jDataSet.get("data_" + (i + 1)), MetalAndColorsData.class);
        }
        return result;
    }

    @DataProvider(parallel = true)
    public Object[][] homeworkDataProvider() {
        return new Object[][]{
                {PRACTICE.text, 0},
                {CUSTOM.text, 1},
                {MULTI.text, 2},
                {BASE.text, 3},
        };
    }
}