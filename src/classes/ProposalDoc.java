package classes;
public class ProposalDoc {
    private CustomerInfo customerInfo;
    private boolean LS;
    private boolean SS;
    private boolean WS;
    private String LSDescription;
    private String SSDescription;
    private String WSDescription;
    private double LSCost;
    private double SSCost;
    private double WSCost;
    private double TotalCost;

    private String LEGAL_CC;
    private String LEGAL_WAuth;
    private String LEGAL_Signature;

    // Constructor
    public ProposalDoc() {
        this.customerInfo = new CustomerInfo();
        this.LS = false;
        this.SS = false;
        this.WS = false;
        this.LSDescription = "";
        this.SSDescription = "";
        this.WSDescription = "";
        this.LSCost = 0.0;
        this.SSCost = 0.0;
        this.WSCost = 0.0;
        this.TotalCost = calculateTotalCost();
        this.LEGAL_CC = "Credit card payments will be charged an additional 2.7%";
        this.LEGAL_WAuth = "WORK AUTHORIZATION:  I, the undersigned owner / property manager / tenant (circle one) of the Job Site Address listed above, hereby affirm that (i) I am authorized to execute this Agreement, and (ii) by signing below, I authorize M & B Services, Inc. to perform the services outlined in this Agreement and to perform such other labor and use such materials as it deems advisable to complete the project.  I have read this Agreement, including the Terms and Conditions on the reverse side and agree to be bound by them.";
        this.LEGAL_Signature = "Customer Signature: ___________________________________    Printed Name: ____________________________    Date: _______________ ";
    }

    // Getters
    public CustomerInfo getCustomerInfo() {
        return this.customerInfo;
    }

    public boolean getLS() {
        return this.LS;
    }

    public boolean getSS() {
        return this.SS;
    }

    public boolean getWS() {
        return this.WS;
    }

    public String getLSDescription() {
        return this.LSDescription;
    }

    public String getSSDescription() {
        return this.SSDescription;
    }

    public String getWSDescription() {
        return this.WSDescription;
    }

    public double getLSCost() {
        return this.LSCost;
    }

    public double getSSCost() {
        return this.SSCost;
    }

    public double getWSCost() {
        return this.WSCost;
    }

    public double getTotalCost() {
        return this.TotalCost;
    }

    public String getLEGAL_CC() {
        return this.LEGAL_CC;
    }
    
    public String getLEGAL_WAuth() {
        return this.LEGAL_WAuth;
    }
    
    public String getLEGAL_Signature() {
        return this.LEGAL_Signature;
    }
    

    // Setters
    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public void setLSDescription(String LSDescription) {
        this.LSDescription = LSDescription;
    }

    public void setSSDescription(String SSDescription) {
        this.SSDescription = SSDescription;
    }

    public void setWSDescription(String WSDescription) {
        this.WSDescription = WSDescription;
    }

    public void setLSCost(double LSCost) {
        this.LSCost = LSCost;
        this.TotalCost = calculateTotalCost();
    }

    public void setSSCost(double SSCost) {
        this.SSCost = SSCost;
        this.TotalCost = calculateTotalCost();
    }

    public void setWSCost(double WSCost) {
        this.WSCost = WSCost;
        this.TotalCost = calculateTotalCost();
    }

    //Helpers
    //Method to calculate the total cost
    public double calculateTotalCost() {
        return this.LSCost + this.SSCost + this.WSCost;
    }

    public void updateLS(BidSheet bidSheet) {
        LiningService liningService = bidSheet.getLiningService();
        if (liningService != null && liningService.hasData()) {
            this.LS = true;
        } else {
            this.LS = false;
        }
    }

    public void updateSS(BidSheet bidSheet) {
        SewerService sewerService = bidSheet.getSewerService();
        if (sewerService != null && sewerService.hasData()) {
            this.SS = true;
        } else {
            this.SS = false;
        }
    }
    
    public void updateWS(BidSheet bidSheet) {
        WaterService waterService = bidSheet.getWaterService();
        if (waterService != null && waterService.hasData()) {
            this.WS = true;
        } else {
            this.WS = false;
        }
    }    
}
