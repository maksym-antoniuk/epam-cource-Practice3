package ua.nure.antoniuk.Practice3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Max on 14.11.2017.
 */
public class Util {
    public static String getInput(String fileName){
        StringBuilder sb = new StringBuilder();

        try {
            Scanner scanner = new Scanner(new File(fileName), "Cp1251");
            while(scanner.hasNextLine()){
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            return sb.toString().trim();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static Matcher getMatcher(String regex, String input){
        Pattern p = Pattern.compile(regex);
        return p.matcher(input);
    }
}
