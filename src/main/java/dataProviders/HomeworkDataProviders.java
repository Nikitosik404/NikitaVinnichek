package dataProviders;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import json.MetalAndColorsData;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

import static enums.ProperTextHomePage.*;
import static enums.jdi.DataWay.DATA_WAY;

public class HomeworkDataProviders {
    @DataProvider
    public Object[][] metalsAndColorsDataProviderWithTypeToken() throws FileNotFoundException {
        String jsonPathJDI = DATA_WAY.toString();

        Gson gson = new Gson();
        JsonObject jsonData = new JsonParser().parse(new FileReader(jsonPathJDI)).getAsJsonObject();

        Type type = new TypeToken<Map<String, MetalAndColorsData>>() {
        }.getType();
        Map<String, MetalAndColorsData> dataSet = gson.fromJson(jsonData, type);

        Object[][] dataObjects = new Object[dataSet.size()][1];
        int index = 0;
        for (String key : dataSet.keySet()) {
            dataObjects[index++][0] = dataSet.get(key);
        }
        return dataObjects;
    }

    @DataProvider
    public static Object[][] metalsAndColorsDataProvider() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonObject jDataSet = new JsonParser().parse(new FileReader(DATA_WAY.toString())).getAsJsonObject();
        Object[][] result = new Object[jDataSet.size()][1];
        // TODO Take a look on TypeToken
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