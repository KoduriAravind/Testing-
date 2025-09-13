package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelReader {
    public static String readData(String sheetName, int rowNumber, int colNumber) {
        try {
            String filepath=System.getProperty("user.dir")+"/webdata.xlsx";
            FileInputStream fileInputStream = new FileInputStream(filepath);
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNumber);
            Cell cell = row.getCell(colNumber);
            String value = cell.toString();
            return value;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void writeData(String sheetName, int rowNumber, int colNumber, String data) {
        try {
            String filepath = System.getProperty("user.dir") + "/Data.xlsx";
            File file = new File(filepath);
            Workbook workbook;

            // Check if file exists to decide whether to create new workbook or read existing
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                workbook = new XSSFWorkbook(fileInputStream);
            } else {
                workbook = new XSSFWorkbook(); // Create new workbook if file doesn't exist
            }

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                sheet = workbook.createSheet(sheetName);
            }

            Row row = sheet.getRow(rowNumber);
            if (row == null) {
                row = sheet.createRow(rowNumber);
            }

            Cell cell = row.getCell(colNumber);
            if (cell == null) {
                cell = row.createCell(colNumber);
            }

            cell.setCellValue(data);

            FileOutputStream fileOutputStream = new FileOutputStream(filepath);
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            workbook.close();

            System.out.println("Data written successfully.");
        } catch (Exception e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }

}


