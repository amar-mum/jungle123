package stepdefinitions;

//package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {

    public static String[][] readExcelData(String filePath, String sheetName) {
        try (FileInputStream excelFile = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(excelFile)) {
            Sheet sheet = workbook.getSheet(sheetName);
            int numberOfRows = sheet.getPhysicalNumberOfRows();
            int numberOfCells = sheet.getRow(0).getPhysicalNumberOfCells();

            String[][] data = new String[numberOfRows][numberOfCells];

            for (int i = 0; i < numberOfRows; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < numberOfCells; j++) {
                    Cell cell = row.getCell(j);
                    data[i][j] = cell.getStringCellValue();
                }
            }
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
