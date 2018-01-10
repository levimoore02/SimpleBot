/*
TAKE OUT RECURSION BY MAKING IT NOT REQUIRED TO CALL ASK() EVERY TIME THE QUESTION IS ASKED.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.HashMap;

public class Main {

    public static HashMap<String, String> dirs = new HashMap<String, String>();

    public static String botType;

    public static void main(String[] args) {

        dirs.put("normal", "C:\\Users\\mccauley.levi\\Desktop\\IntelliJ Files\\SimpleBotGit\\src\\normal.txt");
        dirs.put("angry", "C:\\Users\\mccauley.levi\\Desktop\\IntelliJ Files\\SimpleBotGit\\src\\angry.txt");
        dirs.put("happy", "C:\\Users\\mccauley.levi\\Desktop\\IntelliJ Files\\SimpleBotGit\\src\\happy.txt");
        dirs.put("sad", "C:\\Users\\mccauley.levi\\Desktop\\IntelliJ Files\\SimpleBotGit\\src\\sad.txt");

        Scanner scanType = new Scanner(System.in);

        System.out.println("Hello. Which bot would you like to talk to?");
        botType = scanType.nextLine();

        if (dirs.get(botType) != null) {

            System.out.println("Hello. I am the " + botType + " bot!");
            Scanner scan = new Scanner(System.in);

            messageBot Bot1 = new messageBot(dirs.get(botType));
            Bot1.Start();

        }

        else {

            System.out.println("Invalid bot type.");

        }

    }

}
