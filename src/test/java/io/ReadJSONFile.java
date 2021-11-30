package io;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadJSONFile {
    void  readJsonFile() throws IOException, ParseException {
        JSONParser jsonParser=new JSONParser();
        FileReader fileReader=new FileReader("Path of File");
        Object object=jsonParser.parse(fileReader);
        JSONObject jsonObject= (JSONObject) object;
        JSONArray jsonArray= (JSONArray) jsonObject.get("Student");
        for (int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject1= (JSONObject) jsonArray.get(i);
        }
    }
}
