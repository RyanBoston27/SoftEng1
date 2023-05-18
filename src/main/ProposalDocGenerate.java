package main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

import classes.BidSheet;

public class ProposalDocGenerate{

    String texFilePath;
    BidSheet sheet = new BidSheet();
    String wDesc, wCost, sDesc, sCost, lDesc, lCost;
    String totalCost;

    public ProposalDocGenerate(String TexFilePath, BidSheet Sheet, String WDesc, String WCost, String SDesc, String SCost, String LDesc, String  LCost, String TotalCost) throws IOException{
        this.texFilePath = TexFilePath;
        this.sheet = Sheet;
        this.wDesc = WDesc;
        this.wCost = WCost;
        this.sDesc = SDesc;
        this.sCost = SCost;
        this.lDesc = LDesc;
        this.lCost = LCost;
        this.totalCost = TotalCost;
        
        proposalCreate();
    }
    
    public void proposalCreate() throws IOException {
        System.out.println("1");
        // Read LaTeX Template File
        BufferedReader reader = new BufferedReader(new FileReader(texFilePath));
    
        // Where To Save Generated LaTeX File
        String newFilePath = Paths.get(texFilePath).getParent().toString().replace("\\", "/") + "Output/" + sheet.getCustomerInfo().getEmail() + "Prop.pdf";
    
        System.out.println("2");
        // Handle Lines & Strings
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
    
            // Replace Placeholders With Desired Information
            // Client Information
            if (line.contains("!CNAME!")) {
                line = line.replaceAll("!CNAME!", sheet.getCustomerInfo().getFirstName() + " " + sheet.getCustomerInfo().getLastName());
            }
            if (line.contains("!CPHONE!")) {
                line = line.replaceAll("!CPHONE!", sheet.getCustomerInfo().getPhone());
            }
            if (line.contains("!CEMAIL!")) {
                line = line.replaceAll("!CEMAIL!", sheet.getCustomerInfo().getEmail());
            }
            if (line.contains("!CJSADDRESS!")) {
                line = line.replaceAll("!CJSADDRESS!", sheet.getCustomerInfo().getJobAddress());
            }
            if (line.contains("!CBADDRESS!")) {
                line = line.replaceAll("!CBADDRESS!", sheet.getCustomerInfo().getBillingAddress());
            }
            System.out.println("-");
    
            // Service Information
            if (line.contains("!WDESC!")) {
                line = line.replaceAll("!WDESC!", wDesc);
            }
            if (line.contains("!WCOST!")) {
                line = line.replaceAll("!WCOST!", wCost);
            }
            if (line.contains("!LDESC!")) {
                line = line.replaceAll("!LDESC!", lDesc);
            }
            if (line.contains("!LCOST!")) {
                line = line.replaceAll("!LCOST!", lCost);
            }
            if (line.contains("!SDESC!")) {
                line = line.replaceAll("!SDESC!", sDesc);
            }
            if (line.contains("!SCOST!")) {
                line = line.replaceAll("!SCOST!", sCost);
            }
            if (line.contains("!TOTAL!")) {
                line = line.replaceAll("!TOTAL!", totalCost);
            }
            System.out.println("/");
    
            stringBuilder.append(line).append(System.lineSeparator());
        }
        System.out.println("5");
        reader.close();
    
        BufferedWriter writer = new BufferedWriter(new FileWriter(newFilePath));
    
        writer.write(stringBuilder.toString());
        writer.close();
        System.out.println("6");
        // Generate The PDF From The LaTeX File
        System.out.println(texFilePath);
        System.out.println(newFilePath);
        bidSheetGenerate.latexToPDF(newFilePath);
        System.out.println("Exit");
    }
    
    public static int latexToPDFProp(String latexFilePath) {
        System.out.println("1");
        try {
            String pdfLatexPath = System.getenv("APPDATA").replace("\\", "/").replace("Roaming", "") + "/Local/Programs/MiKTeX/miktex/bin/x64/pdflatex.exe";
            ProcessBuilder builder = new ProcessBuilder(pdfLatexPath, Paths.get(latexFilePath).getFileName().toString());
            System.out.println("2");
            builder.directory(new File(Paths.get(latexFilePath).getParent().toString()));
            System.out.println("3");
            Process process = builder.start();
            return process.waitFor(); // Wait for the command to finish and return the exit code
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return -1; // Return -1 to indicate an error
        }
    }

}

    