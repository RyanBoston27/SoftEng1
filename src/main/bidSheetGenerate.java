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

public class bidSheetGenerate{

    BidSheet sheet = new BidSheet();
    String texFilePath;

public bidSheetGenerate(String TexFilePath, BidSheet Sheet) throws IOException{
    this.sheet = Sheet;
    this.texFilePath = TexFilePath;
    bidSheetCreate();
}

public void bidSheetCreate() throws IOException {
    
    // Read LaTeX Template File
    BufferedReader reader = new BufferedReader(new FileReader(texFilePath));

    // Where To Save Generated LaTeX File
    String newFilePath =  Paths.get(texFilePath).getParent().toString()+ "Output/" + sheet.getCustomerInfo().getEmail() + ".pdf";
    
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

        // Water Service
        if (line.contains("!WSSIZE!")) {
            line = line.replaceAll("!WSSIZE!", sheet.getWaterService().getSize());
        }
        if (line.contains("!WSFEET!")) {
            line = line.replaceAll("!WSFEET!", sheet.getWaterService().getApproxFeet());
        }
        if (line.contains("!WSDROP!")) {
            line = line.replaceAll("!WSDROP!", String.valueOf(sheet.getWaterService().isDrop()));
        }
        if (line.contains("!WSBACKFLOW!")) {
            line = line.replaceAll("!WSBACKFLOW!", String.valueOf(sheet.getWaterService().isBackFlow()));
        }
        if (line.contains("!WSHFEET!")) {
            line = line.replaceAll("!WSHFEET!", sheet.getWaterService().getAddHorizFeet());
        }
        if (line.contains("!WSLINE!")) {
            line = line.replaceAll("!WSLINE!", String.valueOf(sheet.getWaterService().isPropertyLine()));
        }
        if (line.contains("!WSBVLD!")) {
            line = line.replaceAll("!WSBVLD!", String.valueOf(sheet.getWaterService().isBlvd()));
        }
        if (line.contains("!WSMAIN!")) {
            line = line.replaceAll("!WSMAIN!", String.valueOf(sheet.getWaterService().isCityMain()));
        }

        // Sewer Service
        if (line.contains("!SSSIZE!")) {
            line = line.replaceAll("!SSSIZE!", sheet.getSewerService().getSize());
        }
        if (line.contains("!SSLINE!")) {
            line = line.replaceAll("!SSLINE!", String.valueOf(sheet.getSewerService().isPropertyLine()));
        }
        if (line.contains("!SSBVLD!")) {
            line = line.replaceAll("!SSBVLD!", String.valueOf(sheet.getSewerService().isBlvd()));
        }
        if (line.contains("!SSMAIN!")) {
            line = line.replaceAll("!SSMAIN!", String.valueOf(sheet.getSewerService().isCityMain()));
        }

        // Lining Service
        if (line.contains("!LSSIZE!")) {
            line = line.replaceAll("!LSSIZE!", sheet.getLiningService().getSize());
        }
        if (line.contains("!LSFEET!")) {
            line = line.replaceAll("!LSFEET!", sheet.getLiningService().getApproxFeet());
        }
        if (line.contains("!LSX!")) {
            line = line.replaceAll("!LSX!", String.valueOf(sheet.getLiningService().isExcavate()));
        }
        if (line.contains("!LSLINER!")) {
            line = line.replaceAll("!SSLINER!", sheet.getLiningService().getTransitionLiner());
        }

        stringBuilder.append(line).append(System.lineSeparator());
    }
    reader.close();

    BufferedWriter writer = new BufferedWriter(new FileWriter(newFilePath));

    writer.write(stringBuilder.toString());
    writer.close();

    // Generate The PDF From The LaTeX File
    latexToPDF(newFilePath);
}

public static int latexToPDF(String latexFilePath) {
    try {

        ProcessBuilder builder = new ProcessBuilder("C:/Users/ryanb/AppData/Local/Programs/MiKTeX/miktex/bin/x64/pdflatex.exe", Paths.get(latexFilePath).getFileName().toString());
        builder.directory(new File(Paths.get(latexFilePath).getParent().toString()));
        Process process = builder.start();
        return process.waitFor(); // Wait for the command to finish and return the exit code
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
        return -1; // Return -1 to indicate an error
    }
}
}
