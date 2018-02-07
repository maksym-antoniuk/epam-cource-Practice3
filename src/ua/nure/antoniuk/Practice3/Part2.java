package ua.nure.antoniuk.Practice3;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;

/**
 * Created by Max on 14.11.2017.
 */
public class Part2 {

    public static void main(String[] args){
        System.out.println("~~~~~~~~~~Part2~~~~~~~~~~~~");
        System.out.println(convert(Util.getInput("part2.txt")));
    }

    public static String convert(String input){
        String regex = "(?U)(\\w+)(?=\\b)";
        Matcher matcher = Util.getMatcher(regex, input);
        StringBuilder sb = new StringBuilder().append("Min: ");
        Set<String> list = new LinkedHashSet<>();
        while (matcher.find()){
            list.add(matcher.group(1));
        }
        int min = minLenght(list);
        int max = maxLenght(list);

        for(String s : list){
            if(s.length() == min){
                sb.append(s).append(", ");
            }
        }
        sb.delete(sb.length() - 2, sb.length()).append(System.lineSeparator()).append("Max: ");

        for(String s : list){
            if(s.length() == max){
                sb.append(s).append(", ");
            }
        }

        return sb.delete(sb.length() - 2, sb.length() - 1).toString();
    }

    private static int minLenght(Set<String> list){
        int min = Integer.MAX_VALUE;

        for(String s : list){
            if(min > s.length()){
                min = s.length();
            }
        }
        return min;
    }

    private static int maxLenght(Set<String> list){
        int max = -1;

        for(String s : list){
            if(max < s.length()){
                max = s.length();
            }
        }
        return max;
    }
}
