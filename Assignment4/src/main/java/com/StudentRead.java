package com;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import static java.lang.System.out;
// If we want to use treath , we have to implements Runnable
public class StudentRead implements Runnable {

    public volatile static List studentList = new ArrayList();   //Creating studentList ArrayList
    public volatile static Object syncObject = new Object();  //creating new  object
    public volatile static Boolean isReadProcessDone = false;  // With this boolean , we check the process is finish or not

    @Override
    public void run() {
        ObjectMapper mapper = new ObjectMapper(); //creating new  object
        String json = getResource("students.json"); //Read student.json file and return as a String
        JSONParser jsonParser = new JSONParser();  //JSON PARSER class came from Jackson Library. It helps to read json files
        JSONObject parse;
        try {
            synchronized (syncObject) {
                out.println(Thread.currentThread().getName() + " is processing"); // Write at the console, current trade inf.
                parse = (JSONObject) jsonParser.parse(json); //works .parse() method from jsonParser and return as a JSONObject from Json
                JSONArray jsonArray = (JSONArray) parse.get("students"); //We take student block from Json Object and put into jsonArray
                studentList = mapper.readValue(jsonArray.toJSONString(), new TypeReference<>() {
                }); //Via object mapper we cast from JsonArray to List of Student so we can use as java object.
                isReadProcessDone = true; // Tells the other StudentWrite class can start to progress data
                Thread.sleep(3000);// Tells treath: wait 3sec
                syncObject.notifyAll(); //Notify other sycn block
            }

        } catch (InterruptedException | JsonProcessingException e) {
            e.printStackTrace();  //Handles checked exceptions
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
// This method reads json underresource folder with given name and read all lines then return as a String
    public static String getResource(String resource) {
        StringBuilder json = new StringBuilder();
        try {
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(
                                    Objects.requireNonNull(
                                            StudentRegistrationApplication.class.getClassLoader().getResourceAsStream(resource)),
                                    StandardCharsets.UTF_8));
            String str;
            while ((str = in.readLine()) != null) json.append(str);
            in.close();
        } catch (IOException e) {
            throw new RuntimeException("Caught exception reading resource " + resource, e);
        }
        return json.toString();
    }

}
