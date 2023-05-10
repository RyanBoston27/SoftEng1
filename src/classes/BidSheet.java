package classes;
public class BidSheet {
    
    // private data members
    // Each member corresponds to a data item in the bid sheet
    private CustomerInfo customerInfo;
    private WaterService waterService;
    private SewerService sewerService;
    private LiningService liningService;
    private boolean furnishPermits = false;
    private boolean breakUpFloor = false;
    private boolean recementFloor = false;
    private boolean trafficControl = false;
    private String explain = ""; 
    private String remarks = "";

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

    public String getRemarks() {
        return this.remarks;
    }

    // Setters
    public void setCustomerInfo(CustomerInfo CustomerInfo) {
        this.customerInfo = CustomerInfo;
    }

    public void setWaterService(WaterService WaterService) {
        this.waterService = WaterService;
    }

    public void setSewerService(SewerService SewerService) {
        this.sewerService = SewerService;
    }

    public void setLiningService(LiningService LiningService) {
        this.liningService = LiningService;
    }

    public void setFurnishPermits(boolean FurnishPermits) {
        this.furnishPermits = FurnishPermits;
    }
    
    public void setBreakUpFloor(boolean BreakUpFloor) {
        this.breakUpFloor = BreakUpFloor;
    }
    
    public void setRecementFloor(boolean RecementFloor) {
        this.recementFloor = RecementFloor;
    }
    
    public void setTrafficControl(boolean TrafficControl) {
        this.trafficControl = TrafficControl;
    }
    
    public void setExplain(String Explain) {
        this.explain = Explain;
    }

    public void setRemarks(String Remarks) {
        this.remarks = Remarks;
    }
}
