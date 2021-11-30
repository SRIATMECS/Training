package io;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class JsonToExcel {
    public static void main(String[] args) throws IOException, ParseException, WriteException {
        FileOutputStream fileOutputStream=new FileOutputStream("D:\\Result Folder\\Copy.xls");
        WritableWorkbook writableWorkbook= Workbook.createWorkbook(fileOutputStream);
        WritableSheet writableSheet=writableWorkbook.createSheet("Copy",0);
        JSONParser jsonParser=new JSONParser();
        FileReader fileReader=new FileReader("D:\\Result Folder\\Copy.json");
        Object object=jsonParser.parse(fileReader);
        JSONObject jsonObject= (JSONObject) object;
        JSONArray jsonArray= (JSONArray) jsonObject.get("Student");
        for (int i=0;i<jsonArray.size();i++) {
            JSONObject jsonObject1= (JSONObject) jsonArray.get(i);
            String name = (String) jsonObject1.get("Name");
            Label label = new Label(0, i, name);
            String age = (String) jsonObject1.get("Age");
            Label label1 = new Label(1, i, age);
            String marks = (String) jsonObject1.get("Marks");
            Label label2 = new Label(2, i, marks);
            writableSheet.addCell(label);
            writableSheet.addCell(label1);
            writableSheet.addCell(label2);
        }
            writableWorkbook.write();
            writableWorkbook.close();

    }
}
