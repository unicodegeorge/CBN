import java.io.File;
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
                Number numericValue = format.parse(currentLine.substring(separatorIndexes.get(3)+1));
                double doubleValue = numericValue.doubleValue();
                double czkvalue = 1.00 / doubleValue;

                String code = currentLine.substring(separatorIndexes.get(2)+1, separatorIndexes.get(3));
                System.out.printf("%f %s = 1 CZK\n", czkvalue, code);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
