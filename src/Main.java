import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        MainWindow main = new MainWindow();
        getResultsFromText("bigdata.txt");
    }

    public static ArrayList<TestResults> getResultsFromText(String filename){

        ArrayList<TestResults> results = new ArrayList<>(30);
        String name;
        String answerString;

        try {
            Scanner file = new Scanner(new File(filename));

            while (file.hasNextLine() ) {
                name = file.nextLine();
                answerString = file.nextLine();

                results.add(new TestResults(name, answerString));
            }

        } catch (java.io.FileNotFoundException e) {
            System.out.println("Error al abrir el archivo.");
        }

        return results;
    }

}
