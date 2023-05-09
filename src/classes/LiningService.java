package classes;

public class LiningService {
    private int Size;
    private int ApproxFeet;
    private boolean Excavate;
    private int TransitionLiner;

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

    public boolean isExcavate() {
        return Excavate;
    }

    public void setExcavate(boolean excavate) {
        Excavate = excavate;
    }

    public int getTransitionLiner() {
        return TransitionLiner;
    }

    public void setTransitionLiner(int transitionLiner) {
        TransitionLiner = transitionLiner;
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
