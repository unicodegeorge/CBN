import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Cnbprs {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File(Cnbprs.class.getResource("kurzy.txt").getFile()));
            NumberFormat format = NumberFormat.getInstance(Locale.FRENCH);

            while(sc.hasNextLine()) {
                ArrayList<Integer> separatorIndexes = new ArrayList<>();
                String currentLine = sc.nextLine();

                for(int i = 0; i < currentLine.length(); i++) {
                    if (currentLine.charAt(i) == '|') {
                       separatorIndexes.add(i);
                    }
                }

                String stateName = currentLine.substring(0, currentLine.indexOf('|'));

                Number numericValue = format.parse(currentLine.substring(separatorIndexes.get(3)+1));
                double doubleValue = numericValue.doubleValue();
                double czk = 1 / doubleValue;
                String code = currentLine.substring(separatorIndexes.get(2)+1, currentLine.lastIndexOf("|"));
                double value = 1.00 / doubleValue;
                System.out.printf("%f %s = 1 CZK\n", value, code);


            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}