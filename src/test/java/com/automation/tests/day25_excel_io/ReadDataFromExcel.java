package com.automation.tests.day25_excel_io;

import com.automation.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import java.io.File;
import java.util.Map;

public class ReadDataFromExcel {

    @Test
    public void readExcelFileTest() throws Exception {

      File file = new File("VytrackTestUsers.xlsx");

      Workbook workbook = WorkbookFactory.create(file);

      Sheet workSheet = workbook.getSheet("QA1-short");

      Row firstRow = workSheet.getRow(0);

      Cell firstCell = firstRow.getCell(0);

      String value = firstCell.getStringCellValue();

      String secondCellValue = firstRow.getCell(1).getStringCellValue();

      System.out.println(value);
      System.out.println(secondCellValue);

      System.out.println("============================");

      int lastCell = firstRow.getLastCellNum();

      for(int i=0; i<lastCell; i++){
          System.out.print(firstRow.getCell(i) + " | ");
      }

      //last row is 16th --> index is 15
      //index of last row
      int numberOfRows = workSheet.getLastRowNum();
      //returns how many rows total
      int numberOfRows2 = workSheet.getPhysicalNumberOfRows();

      System.out.println("\nIndex of last row : " + numberOfRows);
      System.out.println("\nNumber of rows : " + numberOfRows2);

      System.out.println("========================");

      for (int row=0; row<workSheet.getPhysicalNumberOfRows(); row++){
          for (int cell=0; cell<workSheet.getRow(row).getLastCellNum(); cell++){
              String cellValue = workSheet.getRow(row).getCell(cell).getStringCellValue();
              System.out.print(cellValue + " | ");
          }
          System.out.println();
      }

    }

    @Test
    public void excelUtilityTest(){
        String path = "VytrackTestUsers.xlsx";
        String spreadSheet = "QA1-all";
        ExcelUtil excelUtil = new ExcelUtil(path,spreadSheet);
        excelUtil.getDataList().forEach(System.out::println);
//        for(Map<String,String> record : excelUtil.getDataList()){
//            System.out.println(record);
//        }

    }

    @Test
    public void getColumnNamesTest(){
        String path = "VytrackTestUsers.xlsx";
        String spreadSheet = "QA1-all";
        ExcelUtil excelUtil = new ExcelUtil(path,spreadSheet);

        System.out.println(excelUtil.getColumnsNames());
    }

}
