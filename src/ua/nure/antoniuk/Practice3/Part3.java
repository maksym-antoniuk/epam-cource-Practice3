package ua.nure.antoniuk.Practice3;

import org.omg.CORBA.MARSHAL;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created by Max on 14.11.2017.
 */
public class Part3 {
    public static void main(String[] args) {
        System.out.println("~~~~~~~~~~Part3~~~~~~~~~~~~");
        System.out.println(Util.getInput("part3.txt"));
        System.out.println(convert(Util.getInput("part3.txt")));
    }

    public static String convert(String input){
        /*String regex = "(?U)(\\w+)(?=\\b)";
        Matcher matcher = Util.getMatcher(regex, input);
        List<String> list = new ArrayList<>();
        while (matcher.find()){
            list.add(matcher.group(1));
        }
        String res = new String(input);
        for(String s : list){
            String temp = s;
            temp = temp.replace(temp.charAt(0), temp.toUpperCase().charAt(0));
            res = res.replace(s, temp);
        }*/
        
        StringBuilder sb = new StringBuilder(input);
        for(int i = 0; i < sb.length(); i++) {
        	if(!Character.isLetter(sb.charAt(i))) {
        		sb.replace((i+1), (i+2), String.valueOf(sb.charAt(i+1)).toUpperCase());
        	}
        }
        return sb.toString();
    }
}
