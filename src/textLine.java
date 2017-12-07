import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class textLine {

    public java.util.ArrayList<String> list = new java.util.ArrayList<String>();
    private HashMap<String, String> map = new HashMap<String, String>();

    public String line;
    public String[] parts;
    public String part1;
    public String part2;
//    public String part3;
//    public FileInputStream fstream;
//    public DataInputStream in;
//    public int listLen;
//    public Array listContents;
    public Scanner scan = new Scanner(System.in);
    public boolean inString;
    public static String dataPath;

    public textLine(String b, String attr) {

        try {

            //Make this the path to the data files
            if (attr.equals("normal")) {

                dataPath = "C:\\Users\\mccauley.levi\\Desktop\\IntelliJ Files\\SimpleBotGit\\src\\normal.txt";

            }

            else if (attr.equals("angry")) {

                dataPath = "C:\\Users\\mccauley.levi\\Desktop\\IntelliJ Files\\SimpleBotGit\\src\\sassy.txt";

            }

            FileInputStream fstream = new FileInputStream(dataPath);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            java.util.ArrayList<String> list = new java.util.ArrayList<String>();

            while ((strLine = br.readLine()) != null) {
                list.add(strLine);
            }

            for (int p = 0; p < list.size(); p++) {

                line = list.get(p);

                parts = line.split(":");
                part1 = parts[0];
                part2 = parts[1];

                map.put(parts[0], parts[1]);

                if (part1.equals(b)) {

                    System.out.println(part2);
                    getNewResponse(list);
                    inString = true;
                    break;

                }
                else {

                    inString = false;

                }

            }

            if (!inString) {

                getNewQuestion(b);

            }

            in.close();

        }
        catch (Exception e) {}

    }

    public static String getDataPath() {

        return dataPath;

    }

    public void getSplit() {

        line = "hello:world";
        String[] parts = line.split(":");
        String part1 = parts[0];
        String part2 = parts[1];
        String part3 = parts[2];
//        return "First string is" + part2 + " and second string is " + part3;

    }

    public void getNewQuestion(String newQuestion) {

            System.out.println("How would I respond to that?");
        System.out.print("@>");
            String input = scan.nextLine();

            try {

                String fileText = "\n" + newQuestion + ":" + input;

                Files.write(Paths.get(dataPath), fileText.getBytes(), StandardOpenOption.APPEND);

            }
            catch (IOException e) {

                System.out.println(e.toString());

            }

        }

    public void getNewResponse(ArrayList list) {

        String printed;
        System.out.println("Was that an appropriate response?");
        System.out.print("@>");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        if (input.equals("no")) {

            System.out.println("Please enter a more appropriate response?");
            System.out.print("@>");

            input = scan.nextLine();

            try {

                String newAnswer = part1 + ":" + input;

                PrintWriter pw = new PrintWriter(new FileWriter(dataPath));

                for (int i = 0; i < list.size(); i++) {

                    if (list.get(i).equals(part1 + ":" + part2)) {

                        pw.println(newAnswer);

                    }

                    else {

                        pw.println(list.get(i));

                    }

                }

                pw.flush();
                pw.close();

            }
            catch (IOException e) {

                System.out.println(e.toString());

            }

        }

    }

}
