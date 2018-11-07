package json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MetalAndColorsData {
    private int[] summary;
    private String[] elements;
    private String color;
    private String metals;
    private String[] vegetables;

    public int getSummaryEven() {
        return summary[1];
    }

    public int getSummaryOdd() {
        return summary[0];
    }

    public int[] getSummary() {
        return summary;
    }

    public void setSummary(int[] summary) {
        this.summary = summary;
    }

    public String[] getElements() {
        return elements;
    }

    public void setElements(String[] elements) {
        this.elements = elements;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMetal() {
        return metals;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public List<String> getVegetables() {
        return Arrays.asList(vegetables);
    }

    public void setVegetables(String[] vegetables) {
        this.vegetables = vegetables;
    }

    public List<String> asResult() {

        List<String> result = new ArrayList<>();
        result.add("Summary: " + Arrays.stream(summary).sum());
        result.add("Elements: " + String.join(", ", elements));
        result.add("Color: " + color);
        result.add("Metal: " + metals);
        result.add("Vegetables: " + String.join(", ", vegetables));
        return result;
    }
}
