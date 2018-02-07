package ua.nure.antoniuk.Practice3;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Max on 14.11.2017.
 */
public class Part5 {
    private static Map<String, Integer> roman = new LinkedHashMap<>();

    static{
        roman.put("C", 100);
        roman.put("XC", 90);
        roman.put("L", 50);
        roman.put("XL", 40);
        roman.put("X", 10);
        roman.put("IX", 9);
        roman.put("V", 5);
        roman.put("IV", 4);
        roman.put("I", 1);
    }

    public static void main(String[] args) {
        System.out.println("~~~~~~~~~~Part5~~~~~~~~~~~~");
        for(int i = 1; i <=100; i++){
            System.out.println(i + " ====> " + decimal2Roman(i) + " ====> " + roman2Decimal(decimal2Roman(i)));
        }
    }

    private static String repeat(String s, int n) {
        if(s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static String decimal2Roman(int x){
        String res = "";
        for(Map.Entry<String, Integer> entry : roman.entrySet()){
            int matches = x / entry.getValue();
            res += repeat(entry.getKey(), matches);
            x %= entry.getValue();
        }
        return res;
    }

    public static int roman2Decimal(String s){
        int res = 0;
        String temp = new String(s);
        while (!temp.equals("")){
            for(Map.Entry<String, Integer> entry : roman.entrySet()){
                if(temp.contains(entry.getKey()) && entry.getKey().length() == 2){
                    res += entry.getValue();
                    temp = temp.replaceFirst(entry.getKey(), "");
                }
            }
            for(Map.Entry<String, Integer> entry : roman.entrySet()){
                if(temp.contains(entry.getKey())){
                    res += entry.getValue();
                    temp = temp.replaceFirst(entry.getKey(), "");
                }
            }
        }
        return res;
    }
}
