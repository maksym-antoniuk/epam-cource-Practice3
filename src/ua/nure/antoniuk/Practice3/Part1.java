package ua.nure.antoniuk.Practice3;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ua.nure.antoniuk.Practice3.Util.getMatcher;

/**
 * Created by Max on 14.11.2017.
 */
public class Part1 {
    public static void main(String[] args) {
        System.out.println("~~~~~~~~~~Part1.1~~~~~~~~~~~~");
        System.out.println(convert1(Util.getInput("part1.txt")));
        System.out.println("~~~~~~~~~~Part1.2~~~~~~~~~~~~");
        System.out.println(convert2(Util.getInput("part1.txt")));
        System.out.println("~~~~~~~~~~Part1.3~~~~~~~~~~~~");
        System.out.println(convert3(Util.getInput("part1.txt")));
        System.out.println("~~~~~~~~~~Part1.4~~~~~~~~~~~~");
        System.out.println(convert4(Util.getInput("part1.txt")));
    }



    public static String convert1(String input){
        String regex = "(?m)^(.+(?=;));.+;(.+@.+)(?=\\b)$";
        Matcher matcher = Util.getMatcher(regex, input);
        StringBuilder sb = new StringBuilder();
        while(matcher.find()){
            sb.append(matcher.group(1)).append(" ==> ").append(matcher.group(2)).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String convert2(String input){
        String regex = "(?m).+;(.+)(?=\\b)(.+);(.+@.+)(?=\\b)";
        Matcher matcher = Util.getMatcher(regex, input);
        StringBuilder sb = new StringBuilder();
        while(matcher.find()){
            sb.append(matcher.group(2)).append(" ").append(matcher.group(1)).append("(email: ").append(matcher.group(3)).append(")").append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String convert3(String input){
        String regex = "(?m)^(.+(?=;));.+;.+@(.+)(?=\\b)$";
        Matcher matcher = Util.getMatcher(regex, input);
        StringBuilder sb = new StringBuilder();
        Set<String> set = new LinkedHashSet<>();
        while(matcher.find()){
            set.add(matcher.group(2));
        }

        for(String s : set){
            matcher = Util.getMatcher(regex, input);
            sb.append(s).append( " ==> ");
            while(matcher.find()){
                if (s.equals(matcher.group(2))) {
                    sb.append(matcher.group(1)).append(", ");
                }
            }
            sb.delete(sb.length() - 2, sb.length()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static String convert4(String input){
        String regex = "(?mu)^(\\w+;\\w+;\\w+)(?=\\b)$";
        Matcher matcher = Util.getMatcher(regex, input);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()){
            sb.append(matcher.group(1)).append(";Password").append(System.lineSeparator());
        }
        regex = "(?m)^(.+;.+;.+@.+)(?=\\b)$";
        matcher = getMatcher(regex, input);
        while (matcher.find()){
            sb.append(matcher.group(1)).append(";").append((int)(Math.random() * 9000) + 1000).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
