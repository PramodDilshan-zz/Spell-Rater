/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spellrater.spellcheck;

import com.google.gson.JsonArray;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lk.ijse.spellrater.attribute.AttributeInTheURL;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.css.sac.Condition;

/**
 *
 * @author Dilshan
 */
public class SpellCheck {

    /*
        API Details
        Reffrence   :   https://api.cognitive.microsoft.com/bing/v5.0/spellcheck/
        Location    :   D:\Indrustrial Traning - 2016\Projects\Project SpellRater\SpellRater\Stage 1\Jar Files\selenium-server-standalone-3.0.1.jar
    
        JSon Output
        {   "_type": "SpellCheck",
            "flaggedTokens": [{
            "offset": 5,
            "token": "Gatas",
            "type": "UnknownToken",
            "suggestions": [{
                    "suggestion": "Gates",
                    "score": 1}]
            }]
        }
        
     */
    private static String SUBSCRIPTION_KEY = "4d49365255f3483e8ec5cab53c873570";
    private static ArrayList<JSONObject> errosArylt = new ArrayList();
    public static String URLSt = "";
    public SpellCheck() {

    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int wordCount = 0;
        String words[] = null;
        
        Scanner scan = new Scanner(System.in);
        URLSt = scan.next();
                
        String checkString = new AttributeInTheURL().getDisplayText("D:\\Indrustrial Traning - 2016\\Projects\\SpellRater\\Stage 1\\Jar Files\\chromedriver_win32\\chromedriver.exe", "http://topdocumentaryfilms.com/battery-powered-homes/");
        JSONObject root = null;
        ArrayList<JSONObject> errosArylt = new ArrayList();
        checkString = checkString.replace("[^a-z^A-Z^0-9]", " ");
        checkString = checkString.trim();

        String[] split = checkString.split("\n");

        for (int i = 0; i < split.length; i++) {
            try {
                System.out.println(split[i]);
                wordCount += split[i].split(" ").length;
                root = checkSpellExp(split[i], "proof");
                if (!root.equals(null)) {
                    errosArylt.add(root);
                    root = null;
                }

            } catch (Exception e) {
//                System.out.println(e);
            }
        }

        //JSon Object eka enawaaa
        System.out.println("Error Count" + errosArylt.size());
        System.out.println("All word Count" + wordCount);
        double d = Double.parseDouble(errosArylt.size() + "") / Double.parseDouble(wordCount + "");
        System.out.println(d * 100 + " %");
        for (int i = 0; i < errosArylt.size(); i++) {
//            System.out.println();

            JSONArray sportsArray = errosArylt.get(i).getJSONArray("flaggedTokens");

            //Array Lenth Cotains the Error Count --0
            String URL = "";
            String errorString = "";
            for (int j = 0; j < sportsArray.length(); j++) {
                JSONObject firstSport = sportsArray.getJSONObject(j);
                String name = firstSport.getString("token");
                if (name != null) {
                    System.out.println(name);
                }
            }
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("elapsedTime : " + elapsedTime + " ms");

    }

    public static JSONObject checkSpellExp(String checkString, String mode) {
        HttpClient httpclient = HttpClients.createDefault();
        JSONObject root = null;
        try {
            
//            
            URIBuilder builder = new URIBuilder("https://api.cognitive.microsoft.com/bing/v5.0/spellcheck/");

            builder.setParameter("text", checkString);
            builder.setParameter("mode", mode);
            builder.setParameter("mkt", "en-us");

            URI uri = builder.build();
            HttpGet request = new HttpGet(uri);
            request.setHeader("Ocp-Apim-Subscription-Key", "4d49365255f3483e8ec5cab53c873570");

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String toString = EntityUtils.toString(entity);
                if (toString.contains("offset")) {
                    root = new JSONObject(toString);
                    errosArylt.add(root);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return root;
    }

    public static ArrayList checkSpell(String checkString, String mode) {
        HttpClient httpclient = HttpClients.createDefault();
        ArrayList errosArylt = new ArrayList();
        try {
            URIBuilder builder = new URIBuilder("https://api.cognitive.microsoft.com/bing/v5.0/spellcheck/");

            builder.setParameter("text", checkString);
            builder.setParameter("mode", mode);
            builder.setParameter("mkt", "en-us");

            URI uri = builder.build();
            HttpGet request = new HttpGet(uri);
            request.setHeader("Ocp-Apim-Subscription-Key", "4d49365255f3483e8ec5cab53c873570");

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String toString = EntityUtils.toString(entity);
                System.out.println(toString);

                JSONObject root = new JSONObject(toString);

                JSONArray sportsArray = root.getJSONArray("flaggedTokens");

//                 Array Lenth Cotains the Error Count --0
                for (int i = 0; i < sportsArray.length(); i++) {
                    JSONObject firstSport = sportsArray.getJSONObject(i);
                    String name = firstSport.getString("token");
                    errosArylt.add(name);
                }
                System.out.println(errosArylt.size());

                for (int i = 0; i < errosArylt.size(); i++) {
                    System.out.println(i + " : " + errosArylt.get(i));
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return errosArylt;
    }
}


/*    public static ArrayList checkSpellExp(String checkString, String mode) {
        HttpClient httpclient = HttpClients.createDefault();
        ArrayList<JSONObject> errosArylt = new ArrayList();
        try {
            URIBuilder builder = new URIBuilder("https://api.cognitive.microsoft.com/bing/v5.0/spellcheck/");

            builder.setParameter("text", checkString);
            builder.setParameter("mode", mode);
            builder.setParameter("mkt", "en-us");

            URI uri = builder.build();
            HttpGet request = new HttpGet(uri);
            request.setHeader("Ocp-Apim-Subscription-Key", "4d49365255f3483e8ec5cab53c873570");

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String toString = EntityUtils.toString(entity);
                if (toString.contains("offset")) {
                    JSONObject root = new JSONObject(toString);
                    errosArylt.add(root);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return errosArylt;
    }*/
