package tests.db;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.commons.text.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import tests.utils.UserDetails;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DbTests {

    @Test
    public void dbTest() throws ClassNotFoundException, IOException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");


        Connection conn = null;

        ArrayList<UserDetails> a = new ArrayList<UserDetails>();
        JSONArray aj = new JSONArray();
        conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/testautomation_d","admintestuser","password");

        //Object of statement class will be help to execute queries
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from user where profession ='tester';");

        while (rs.next()){
            UserDetails userDetails = new UserDetails();
            userDetails.setId(rs.getInt(1));
            userDetails.setFirstname(rs.getString(2));
            userDetails.setLastname(rs.getString(3));
            userDetails.setProfession(rs.getString(4));
            a.add(userDetails);
        }

        for (int i=0; i<a.size();i++){
            ObjectMapper o = new ObjectMapper();
            o.writeValue(new File(System.getProperty("user.dir")+"\\src\\test\\java\\tests\\utils\\customerInfo"+i+".json"), a.get(i));
            Gson g = new Gson();
            String jsonString = g.toJson(a.get(i));
            aj.add(jsonString);
        }

        // Json Simple
        JSONObject oj = new JSONObject();
        oj.put("data", aj);
        String un = StringEscapeUtils.unescapeJava(oj.toJSONString());
        String un1 = un.replace("\"{", "{");
        String un2 = un1.replace("}\"", "}");
        System.out.println(un2);

        try(FileWriter file = new FileWriter(System.getProperty("user.dir")+"\\src\\test\\java\\tests\\utils\\SingleJson.json")) {
            file.write(un2);
        }

        conn.close();
    }


    }

