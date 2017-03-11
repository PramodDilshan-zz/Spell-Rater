/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spellrater.spellcheck;

import java.util.ArrayList;
import java.util.Scanner;
import lk.ijse.spellrater.attribute.AttributeInTheURL;
import static lk.ijse.spellrater.spellcheck.SpellCheck.checkSpellExp;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Dilshan
 */
public class TestingSpellCheck {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String url = scan.next();
        
        
        SpellCheck x = new SpellCheck();
        ArrayList<JSONObject> errosArylt = new ArrayList();

        JSONObject root = null;
        
//        root = x.checkSpellExp("apl ass aple lke my fuck give", "proof");
//        System.out.println("a");
//        
        //JSon Object eka enawaaa
//        System.out.println(root);

        JSONArray sportsArray = root.getJSONArray("flaggedTokens");

//                 Array Lenth Cotains the Error Count --0
        for (int i = 0; i < sportsArray.length(); i++) {
            JSONObject firstSport = sportsArray.getJSONObject(i);
            String name = firstSport.getString("token");
            System.out.println(name);
        }

    }

}
