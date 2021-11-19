package io;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
public class ExcelToJson {
    public static void main(String[] args) throws IOException, BiffException {
        FileInputStream fileInputStream=new FileInputStream("D:\\InputData\\Data.xls");
        Workbook workbook=Workbook.getWorkbook(fileInputStream);
        Sheet sheet=workbook.getSheet("Sheet1");
        JSONArray jsonArray=new JSONArray();
        for (int i=0;i<sheet.getRows();i++){
            JSONObject jsonObject=new JSONObject();
            jsonObject.put(sheet.getCell(0,0).getContents(),sheet.getCell(0,i).getContents());
            jsonObject.put(sheet.getCell(1,0).getContents(),sheet.getCell(1,i).getContents());
            jsonObject.put(sheet.getCell(2,0).getContents(),sheet.getCell(2,i).getContents());
            jsonArray.add(jsonObject);
        }
        JSONObject jsonObject1=new JSONObject();
        jsonObject1.put("Student",jsonArray);
        FileWriter fileWriter=new FileWriter("D:\\Result Folder\\Copy.json");
        fileWriter.write(jsonObject1.toString());
        fileWriter.flush();
        fileWriter.close();
    }
}
