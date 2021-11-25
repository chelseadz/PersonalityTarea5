import java.util.ArrayList;


public class TestResults {
    private String name;
    private ArrayList<Integer> results;
    private String personality;

    @SuppressWarnings("StringConcatenationInLoop")
    public TestResults(String name, String answers) {

        this.name = name;

        answers = answers.toUpperCase();

        int[] processedResults = {0, 0, 0, 0, 0, 0, 0, 0};

        for(int i = 0; i < answers.length(); ++i) {
            int fieldIndex;

            if ( i % 7 == 0)  fieldIndex = 0;
            else if ( i % 7 == 1 || i % 7 == 2) fieldIndex = 2;
            else if ( i % 7 == 3 || i % 7 == 4) fieldIndex = 4;
            else fieldIndex = 6;

            if (answers.charAt(i) == '-') continue;
            if (answers.charAt(i) == 'A') processedResults[fieldIndex]++;
            else processedResults[fieldIndex + 1]++; //answers[i] == 'B';
        }

        ArrayList<Integer> results = new ArrayList<>();

        for(int j = 0; j < 4; ++j)
            results.add(( processedResults[2 * j + 1] * 100 /
                    (processedResults[2 * j] + processedResults[2 * j + 1])));

        this.results = results;

        char characteristic;
        String resultA = "ESTJ";
        String resultB = "INFP";
        personality = "";
        for(int s = 0; s < 4; ++s) {
            if (results.get(s) < 50) characteristic = resultA.charAt(s);
            else if( results.get(s) > 50) characteristic = resultB.charAt(s);
            else characteristic = 'X';

            personality += characteristic;
        }
    }

    public String toString() {

        StringBuilder numbers = new StringBuilder(results.get(0).toString());
        for(int n = 1; n < results.size(); ++n) numbers.append(", ").append(results.get(n).toString());

        return name + ": [" + numbers + "] = " + personality;

    }

}
