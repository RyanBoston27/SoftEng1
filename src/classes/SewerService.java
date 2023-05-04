package classes;

public class SewerService {
    private int Size;
    private int ApproxFeet;
    private boolean PropertyLine;
    private boolean CityMain;

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    public int getApproxFeet() {
        return ApproxFeet;
    }

    public void setApproxFeet(int approxFeet) {
        ApproxFeet = approxFeet;
    }

    public boolean isPropertyLine() {
        return PropertyLine;
    }

    public void setPropertyLine(boolean propertyLine) {
        PropertyLine = propertyLine;
    }

    public boolean isCityMain() {
        return CityMain;
    }

    public void setCityMain(boolean cityMain) {
        CityMain = cityMain;
    }
}
