import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChangesBudget {

  final public static String SEP = "; ";

  //Создание и добавление записей в бюджет
  public static void addMovingMoneyToFile() throws IOException {
    File myBudgetFile = new File("res/budget.txt");

    FileWriter fileWriter = new FileWriter("res/budget.txt", true);
    if (!myBudgetFile.exists()) {
      myBudgetFile.createNewFile();
    }

    Budget movingMoney = Budget.addMoneyMoving();
    String line =
        String.format(movingMoney.getDate() + SEP + movingMoney.getName() + SEP
            + movingMoney.getCategory() + SEP + movingMoney.getSum() + "\n");
    fileWriter.write(String.valueOf(line));
    fileWriter.close();

    System.out.println("Нажмите 1 для добавление ещё одной записи и 2 для выхода в меню");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int vybor = Integer.parseInt(br.readLine());
    if (vybor == 1) {
      addMovingMoneyToFile();
    }
    System.out.println("Здесь будет переход в главное меню.");
    Menu.menuStart();
  }

  // печать всех строк бюджета с сортировкой по дате, по наименованию
  public static void printBudget() throws IOException {

    Parser.parser().sort(new BudgetComparator.BudgetDateCategoryComparator());
    for (Budget row : Parser.parser()) {
      System.out.println(row);
    }
    Menu.menuStart();
  }

  //удаление записей из бюджета
  public static void delRowFromBudget() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    List<Budget> budget = new ArrayList<>(Parser.parser());

    for (int i = 0; i < budget.size(); ++i) {
      System.out.println(((i + 1) + ". " + budget.get(i)));
    }

    System.out.printf("Введите номер удаляемого задания от 1 до %d:  -  ", budget.size());
    int indexDelBudget = Integer.parseInt(br.readLine());
    budget.remove(indexDelBudget - 1);

    System.out.println("Списолк после удаления строки бюджета: ");
    for (int i = 0; i < budget.size(); ++i) {
      System.out.println(((i + 1) + ". " + budget.get(i)));
    }

    //перезаписать в файл
    File myBudgetFile = new File("res/budget.txt");

    FileWriter fileWriter = new FileWriter("res/budget.txt");
    if (!myBudgetFile.exists()) {
      myBudgetFile.createNewFile();
    }

    for (int i = 0; i < budget.size(); ++i) {
      Budget movingMoney = budget.get(i);
      String line =
          String.format(movingMoney.getDate() + SEP + movingMoney.getName() + SEP
              + movingMoney.getCategory() + SEP + movingMoney.getSum() + "\n");
      fileWriter.write(String.valueOf(line));
    }
      fileWriter.close();

    //выбор следующего действия
    System.out.println("Нажмите 1 для продолжения удаления и 2 для выхода в меню");

    int vybor = Integer.parseInt(br.readLine());
    if (vybor == 1) {
      delRowFromBudget();
    }
    Menu.menuStart();
  }



}
