//package Lending.jar.Automation.dataModel_S;
//
//import Lending.jar.Automation.dataModel_I.excelMobilenumber;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class fetchNumberinExcel {
//
//    // Method to fetch mobile numbers from the Excel file
//    public static excelMobilenumber fetchNumber(String filePath) throws IOException {
//        // Initialize the mobileNumber list in excelMobilenumber
//        List<String> mobileNumbers = new ArrayList<>();
//
//        // Opening the Excel file
//        FileInputStream file = new FileInputStream(filePath);
//        Workbook workbook = new XSSFWorkbook(file);
//        Sheet sheet = workbook.getSheetAt(0);
//
//        // Loop through rows, skipping the header row
//        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//            Row row = sheet.getRow(i);
//            if (row != null && row.getCell(0) != null) { // Check cell exists
//                String mobile = row.getCell(0).getStringCellValue();
//
//                // Clean up any extra quotes if present
//                mobile = mobile.replaceAll("^\"|\"$", "");
//
//                mobileNumbers.add(mobile);
//            }
//        }
//
//        workbook.close();
//        file.close();
//
//        // Set the list in the excelMobilenumber instance
//        excelMobilenumber excelData = new excelMobilenumber();
//        excelData.setMobileNumber(mobileNumbers);
//
//        // Return the populated excelMobilenumber object
//        return excelData;
//    }
//
//    // Main method to fetch mobile numbers and convert to JSON
//    public static Map<String, String> fetchAndConvertToJson(String excelFilePath) throws IOException {
//        // Fetch the mobile numbers from Excel
//        excelMobilenumber mobileData = fetchNumber(excelFilePath);
//
//        // Create ObjectMapper instance to convert the object to JSON
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        // Convert the mobileData to a Map for easier formatting
//        List<String> mobileNumbers = mobileData.getMobileNumber();
//        if (mobileNumbers != null && !mobileNumbers.isEmpty()) {
//            // Assuming you want to send only the first mobile number as "mobileNumber"
//            String mobileNumber = mobileNumbers.get(0);
//
//            // Create a map with the desired structure
//            Map<String, String> resultMap = Map.of("mobileNumber", mobileNumber);
//
//            // Convert the map to JSON
//            String jsonResult = objectMapper.writeValueAsString(resultMap);
//
//            // Print the JSON result
//            System.out.println(jsonResult); // Example: {"mobileNumber": "+919611055312"}
//
//            // Return the map containing the mobile number
//            return resultMap;
//        } else {
//            System.out.println("No mobile numbers found.");
//            return null;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        // Specify the path to your Excel file
//        String excelFilePath = "/Users/kishanr/Downloads/mobileNumber Payload (1).xlsx";
//
//        // Fetch and convert to JSON
//        fetchAndConvertToJson(excelFilePath);
//    }
//}
//

package Lending.jar.Automation.dataModel_S;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class fetchNumberinExcel {

    public static Map<String, Object> main() throws IOException {
        // Specify the path to your Excel file
        String excelFilePath = "/Users/kishanr/Downloads/mobileNumber Payload (2).xlsx";

        // Initialize the mobileNumber list in excelMobilenumber
        List<String> mobileNumbers = new ArrayList<>();

        // Opening the Excel file
        FileInputStream file = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        // Loop through rows, skipping the header row
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null && row.getCell(0) != null) { // Check if cell exists
                String mobile = row.getCell(0).getStringCellValue();

                // Clean up any extra quotes if present
                mobile = mobile.replaceAll("^\"|\"$", "");

                mobileNumbers.add(mobile);
            }
        }

        workbook.close();
        file.close();

        // Assuming you want to send only the first mobile number as "mobileNumber"
        if (mobileNumbers != null && !mobileNumbers.isEmpty()) {
            String mobileNumber = mobileNumbers.get(0);

            // Create ObjectMapper instance to convert the object to JSON
            ObjectMapper objectMapper = new ObjectMapper();

            // Create a map with the desired structure
            Map<String, String> resultMap = Map.of("mobileNumber", mobileNumber);

            // Convert the map to JSON
            String jsonResult = objectMapper.writeValueAsString(resultMap);

            // Print the JSON result
            System.out.println(jsonResult); // Example: {"mobileNumber": "+919611055312"}
        } else {
            System.out.println("No mobile numbers found.");
        }
        return Map.of();
    }
}

