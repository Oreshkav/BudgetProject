import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Parser {

  final public static String SEP = "; ";

  public static List<Budget> parser() throws IOException {

    File budgetFile = new File("res/budget.txt");
    if (!budgetFile.exists()) {
      System.out.println("Файл не найден.");
      Menu.menuStart();
    }

    BufferedReader br = new BufferedReader(new FileReader("res/budget.txt"));
    List<Budget> listBudget = new ArrayList<>();

    for (String line = br.readLine(); line != null; line = br.readLine()) {
      int lastSep = line.indexOf(SEP);

      LocalDate date = LocalDate.parse(line.substring(0, lastSep));
      line = line.substring(lastSep + 2);
      lastSep = line.indexOf(SEP);

      String name = line.substring(0, lastSep);
      line = line.substring(lastSep + 2);
      lastSep = line.indexOf(SEP);

      String category = line.substring(0, lastSep);
      line = line.substring(lastSep + 2);
      lastSep = line.indexOf(SEP);

      if (line.substring(lastSep + 2) == "-") {
        int sum = -1 * Integer.parseInt(line.substring(lastSep + 3));
      }

      int sum = Integer.parseInt(line.substring(lastSep + 2));

      Budget readedMovingLine = new Budget(date, name, category, sum);
      listBudget.add(readedMovingLine);
    }
    br.close();
    return listBudget;
  }
}