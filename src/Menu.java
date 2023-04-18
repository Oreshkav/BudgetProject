import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Menu {

//  1. Добавить запись
//    1.1.Внести доход
//    1.2.Внести расход
//    2. Удалить запись
//    3. Редактировать запись
//    4. Вывести список затрат (с суммами и итоговой суммой)
//        по категориям
//    5. Сальдо (остаток денег)

  public static void menuStart() throws IOException {

    List<String> menuMain = menuList();
    int numMenu = readMenu(menuMain);

    switch (numMenu) {
      case 1:
//      if (numMenu == 1) {
        System.out.println("Добавить запись.");
        WriteToFile.addMovingMoneyToFile();
//      }
      case 2:
//      if (numMenu == 2) {
        System.out.println("Редактировать запись.");
//      ToDoList.taskChange();
//      }

      // вывод подменю критериев отбора
      if (numMenu == 3) {
        System.out.println("Вывести список затрат.");
//      ToDoList.ShowAll();
      }
      if (numMenu == 4) {
        System.out.println("Удалить запись.");
//      ToDoList.delTaskInToDoFile();
      }

      if (numMenu == 5) {
        System.out.println("Выходим. До свидания! Приятно было с Вами иметь дело!");
      }
    }
  }

  public static List<String> menuList() {
    System.out.println("\nMENU");

    List<String> menuMain = new ArrayList<>();
    menuMain.add("Добавить запись.");
    menuMain.add("Редактировать запись.");
    menuMain.add("Вывести список затрат.");
    menuMain.add("Удалить запись.");
    menuMain.add("Выйти.");

    for (int i = 0; i < menuMain.size(); ++i) {
      System.out.println(((i + 1) + ". " + menuMain.get(i)));
    }
    return menuMain;
  }

  public static int readMenu(List<String> menuMain) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int menuNumber = 0;
    while (menuNumber < 1 || menuNumber > menuMain.size()) {
      System.out.printf("Выберите действие и введите номер от 1 до %d:  -  ", menuMain.size());
      try {
        menuNumber = Integer.parseInt(br.readLine());
      } catch (NumberFormatException e) {
        System.err.println("\nНеправильный формат числа: " + e.getMessage());
      }
    }
    return menuNumber;
  }

}
