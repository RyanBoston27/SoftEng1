package classes;
public class BidSheet {
    
    // private data members
    // Each member corresponds to a data item in the bid sheet
    private CustomerInfo customerInfo;
    private WaterService waterService;
    private SewerService sewerService;
    private LiningService liningService;
    private boolean furnishPermits;
    private boolean breakUpFloor;
    private boolean recementFloor;
    private boolean trafficControl;
    private String explain; 

    // Default constructor
    public BidSheet() {
        this.customerInfo = new CustomerInfo();
        this.waterService = new WaterService();
        this.sewerService = new SewerService();
        this.liningService = new LiningService();
    }

    // Getters
    public CustomerInfo getCustomerInfo() {
        return this.customerInfo;
    }

    public WaterService getWaterService() {
        return this.waterService;
    }

    public SewerService getSewerService() {
        return this.sewerService;
    }

    public LiningService getLiningService() {
        return this.liningService;
    }

    public boolean isFurnishPermits() {
        return this.furnishPermits;
    }
    
    public boolean isBreakUpFloor() {
        return this.breakUpFloor;
    }
    
    public boolean isRecementFloor() {
        return this.recementFloor;
    }
    
    public boolean isTrafficControl() {
        return this.trafficControl;
    }
    
    public String getExplain() {
        return this.explain;
    }

    // Setters
    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public void setWaterService(WaterService waterService) {
        this.waterService = waterService;
    }

    public void setSewerService(SewerService sewerService) {
        this.sewerService = sewerService;
    }

    public void setLiningService(LiningService liningService) {
        this.liningService = liningService;
    }

    public void setFurnishPermits(boolean furnishPermits) {
        this.furnishPermits = furnishPermits;
    }
    
    public void setBreakUpFloor(boolean breakUpFloor) {
        this.breakUpFloor = breakUpFloor;
    }
    
    public void setRecementFloor(boolean recementFloor) {
        this.recementFloor = recementFloor;
    }
    
    public void setTrafficControl(boolean trafficControl) {
        this.trafficControl = trafficControl;
    }
    
    public void setExplain(String explain) {
        this.explain = explain;
    }
}
