/* Check if input is in text file, and if it is, give pre made response, else, ask for a new one, and create it, and
average out responses.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String input = "";

            Scanner scan = new Scanner(System.in);
            System.out.println("Please ask me a question.");
            System.out.print("@>");
            input = scan.nextLine();
            textLine Bot1 = new textLine(input, "angry");

    }

    private static void writeToText(String dataText) {

        dataText = "\n" + dataText;

        try {

            Files.write(Paths.get(textLine.getDataPath()), dataText.getBytes(), StandardOpenOption.APPEND);

        }
        catch (IOException e) {

            System.out.println(e.toString());

        }

    }

}
