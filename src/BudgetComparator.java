import java.util.Comparator;

public class BudgetComparator {

  public static class BudgetDateCategoryComparator implements Comparator<Budget> {

       @Override
    public int compare(Budget row1, Budget row2) {
      if (!row1.getDate().equals(row2.getDate())) {
//        System.out.print((row1.getDate()) + " - ");
//        System.out.println(row2.getDate());
//        System.out.println(row1.getDate().compareTo(row2.getDate()));
        return row1.getDate().compareTo(row2.getDate());
      }
      return row1.getCategory().compareTo(row2.getCategory());
    }

  }

}
