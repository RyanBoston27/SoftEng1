package classes;

public class WaterService {
    private String Size;
    private String ApproxFeet;
    private boolean Drop;
    private boolean BackFlow;
    private String AddHorizFeet;
    private boolean PropertyLine;
    private boolean Blvd;
    private boolean CityMain;

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public String getApproxFeet() {
        return ApproxFeet;
    }

    public void setApproxFeet(String approxFeet) {
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

    public String getAddHorizFeet() {
        return AddHorizFeet;
    }

    public void setAddHorizFeet(String addHorizFeet) {
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
        if(Size != ""){
            return true;
        }
        else{
            return false;
        }
    }
}