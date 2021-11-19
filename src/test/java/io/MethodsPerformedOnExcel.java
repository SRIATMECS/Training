package io;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MethodsPerformedOnExcel {

    public static void main(String[] args) throws IOException, BiffException {
        ArrayList list=new ArrayList();
        System.out.println("1-- method to find out number of rows, \n" +
                "2-- method to find out number of columns, \n" +
                "3-- isColumnHeaderPresent, (Name, Age, Marks)\n" +
                "4-- isDataPresentInGivenCol, (age 20 present in third column)\n" +
                "5-- isDataPresentInGivenRow, ( name saravana present in fivth row)\n" +
                "6-- getValueOfGivenColumns, ( 3rd column data -age's)\n" +
                "7-- getValueOfGivenRows etc ( 5th row data - name, age, marks)\n" +
                "8-- a method to retrieve data excel and store in appropriate data structure (array or list or map) \n" +
                "9--  a method to verify data retrieved from excel with data in java data structure (array or list or map)");
        FileInputStream fileInputStream = new FileInputStream("D:\\InputData\\Data.xls");
        Workbook workbook = Workbook.getWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet("Sheet1");
        Scanner in=new Scanner(System.in);
        String str=in.next();
        switch (str){
            case"1": System.out.println("Total Number of Rows is : " + sheet.getRows());
            break;
            case"2": System.out.println("Total Number of Columns is : " + sheet.getColumns());
            break;
            case"3":for (int i = 0; i < sheet.getColumns(); i++) {
                list.add(sheet.getCell(i,0).getContents());
            }
                System.out.println(list);
            break;
            case"4":for (int j = 0; j < sheet.getRows(); j++) {
                if (sheet.getCell(1, j).getContents().equals("20")) {
                    System.out.println(sheet.getCell(1,j).getContents()+"Age Position is 1st column " + j + "th Row");
                }
            }
            break;
            case"5":for (int i = 0; i < sheet.getColumns(); i++) {
                if (sheet.getCell(i, 4).getContents().equals("sarvana")) {
                    System.out.println(sheet.getCell(i, 4).getContents() + " Position is 5th Row " + i + "th Column");
                }
            }
            break;
            case"6":for (int j = 0; j < sheet.getRows(); j++) {
                System.out.println(sheet.getCell(1,j).getContents());
            }
            break;
            case"7":for (int i = 0; i < sheet.getColumns(); i++) {
                System.out.println(sheet.getCell(i,4).getContents());
            }
                break;
            case"8":for (int i = 0; i < sheet.getColumns(); i++){
                for (int j = 0; j < sheet.getRows(); j++) {
                    list.add(sheet.getCell(i,j).getContents());
                }
            }
                System.out.println(list);
            break;
        }
    }
}

