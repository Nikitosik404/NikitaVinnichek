package enums.jdi;

public enum  DataWay {
    DATA_WAY("src/test/resources/JDI_ex8_metalsColorsDataSet.json");

    private String way;

    DataWay(String way) {
        this.way = way;
    }

    @Override
    public String toString() {
        return way;
    }
}
