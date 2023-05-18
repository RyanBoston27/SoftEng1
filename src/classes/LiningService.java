package classes;

public class LiningService {
    private String Size;
    private String ApproxFeet;
    private boolean Excavate;
    private String TransitionLiner;

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

    public boolean isExcavate() {
        return Excavate;
    }

    public void setExcavate(boolean excavate) {
        Excavate = excavate;
    }

    public String getTransitionLiner() {
        return TransitionLiner;
    }

    public void setTransitionLiner(String transitionLiner) {
        TransitionLiner = transitionLiner;
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
