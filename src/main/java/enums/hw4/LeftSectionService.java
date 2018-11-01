package enums.hw4;

import java.util.ArrayList;
import java.util.List;

public enum LeftSectionService {
    SUPPORT1("Support"),
    DATES1("Dates"),
    COMPLEX_TABLE1("Complex Table"),
    SIMPLE_TABLE1("Simple Table"),
    USER_TABLE1("User Table"),
    TABLES_WITH_PAGES1("Table with pages"),
    DIFFERENT_ELEMENTS1("Different elements");

    String displayName;

    LeftSectionService(String name) {
        displayName = name;
    }

    public static List<String> getServiceMenu() {
        List<String> result = new ArrayList<>();
        for (LeftSectionService value : LeftSectionService.values()) {
            result.add(value.displayName);
        }
        return result;
    }
}
