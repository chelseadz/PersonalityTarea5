import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MainWindow extends JFrame {

    private JPanel pMain;
    private JPanel pControl;
    private JPanel pResults;
    private JButton bOpenFile;
    private JTextArea taResults;

    private final int WIDTH = 700, HEIGHT = 500;

    public MainWindow() {

        super("Clasificador de temperamento Keirsey");

        setVisible(true);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(pMain);

        bOpenFile.addActionListener(e -> {
            File file = openFile();
            if (file != null) {
                taResults.setText(null);
                getResultsFromText(file).forEach(r -> taResults.append(r.toString() + "\n"));
            }
        });
    }

    private File openFile() {
        JFileChooser fileChooser = new JFileChooser(new File(System.getProperty("user.dir")));
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) return fileChooser.getSelectedFile();
        return null;
    }

    public static ArrayList<TestResults> getResultsFromText(File file) {

        ArrayList<TestResults> results = new ArrayList<>(30);
        String name;
        String answerString;

        try {
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                name = fileScanner.nextLine();
                answerString = fileScanner.nextLine();

                results.add(new TestResults(name, answerString));
            }

        } catch (java.io.FileNotFoundException e) {
            System.out.println("Error al abrir el archivo.");
        }

        return results;
    }

}
