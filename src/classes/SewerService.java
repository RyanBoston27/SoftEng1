package classes;

public class SewerService {
    private String Size;
    private boolean Blvd;
    private boolean PropertyLine;
    private boolean CityMain;

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public boolean isBlvd() {
        return Blvd;
    }

    public void setBlvd(Boolean blvd) {
        Blvd = blvd;
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

    public boolean hasData(){
        if(Size != ""){
            return true;
        }
        else{
            return false;
        }
    }
}
