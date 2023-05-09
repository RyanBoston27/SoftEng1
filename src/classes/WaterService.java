package classes;

public class WaterService {
    private double Size;
    private int ApproxFeet;
    private boolean Drop;
    private boolean BackFlow;
    private int AddHorizFeet;
    private boolean PropertyLine;
    private boolean Blvd;
    private boolean CityMain;

    public double getSize() {
        return Size;
    }

    public void setSize(double size) {
        Size = size;
    }

    public int getApproxFeet() {
        return ApproxFeet;
    }

    public void setApproxFeet(int approxFeet) {
        ApproxFeet = approxFeet;
    }

    public boolean isDrop() {
        return Drop;
    }

    public void setDrop(boolean drop) {
        Drop = drop;
    }

    public boolean isBackFlow() {
        return BackFlow;
    }

    public void setBackFlow(boolean backFlow) {
        BackFlow = backFlow;
    }

    public int getAddHorizFeet() {
        return AddHorizFeet;
    }

    public void setAddHorizFeet(int addHorizFeet) {
        AddHorizFeet = addHorizFeet;
    }

    public boolean isPropertyLine() {
        return PropertyLine;
    }

    public void setPropertyLine(boolean propertyLine) {
        PropertyLine = propertyLine;
    }

    public boolean isBlvd() {
        return Blvd;
    }

    public void setBlvd(boolean blvd) {
        Blvd = blvd;
    }
    
    public boolean isCityMain() {
        return CityMain;
    }
    
    public void setCityMain(boolean cityMain) {
        CityMain = cityMain;
    }

    public boolean hasData(){
        if(Size > 0){
            return true;
        }
        else{
            return false;
        }
    }
}