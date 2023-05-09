package classes;
public class BidSheet {
    // private data members
    private CustomerInfo customerInfo;
    private WaterService waterService;
    private SewerService sewerService;
    private LiningService liningService;

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
}
