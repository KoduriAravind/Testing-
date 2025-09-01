package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static List<String> readRowOrColumn(String sheetName, int index, boolean isRow) {
        List<String> data = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/Book1.xlsx");
            // Workbook workbook = WorkbookFactory.create(file))
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }

            if (isRow) {
                // Read specific row
                Row row = sheet.getRow(index);
                if (row == null) {
                    throw new RuntimeException("Row not found: " + index);
                }

                int lastCellNum = row.getLastCellNum();
                for (int i = 0; i < lastCellNum; i++) {
                    Cell cell = row.getCell(i);
                    data.add(cell != null ? cell.toString() : "");
                }

            } else {
                // Read specific column
                for (Row row : sheet) {
                    Cell cell = row.getCell(index);
                    data.add(cell != null ? cell.toString() : "");
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading Excel file: " + e.getMessage());
        }

        return data;
    }


    public static void main(String[] args) {

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
       boolean isrow=false;
       int index=0;
        List<String> rowdata=readRowOrColumn("Sheet1",index,isrow);
        if(isrow) {
            System.out.println("Row "+index+" Data:"+rowdata);
        }else{
            System.out.println("Column "+index+" data:"+rowdata);
        }



    }
}