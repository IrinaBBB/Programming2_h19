package sorting;

import java.util.Comparator;

public class MergeSortWithComparatorTest {
    public static void main(String[] args) {
        Employee[] list = new Employee[5];
        list[0] = new Employee(12, "Jane Doe", "sales");
        list[1] = new Employee(5, "Jake Holland", "accounting");
        list[2] = new Employee(3, "Storm Pemberton", "sales");
        list[3] = new Employee(25, "Tina Plummer", "sales");
        list[4] = new Employee(1, "Alessia Mackay", "accounting");


        printEmployeeList(list);
        System.out.println();
        System.out.println();

        MergeSortWithComparator.mergeSortWithComparator(list, new EmployeeComparatorById());
        printEmployeeList(list);

        System.out.println();
        System.out.println();

        MergeSortWithComparator.mergeSortWithComparator(list, new EmployeeComparatorByNameIgnoreCase());
        printEmployeeList(list);
    }

    private static class EmployeeComparatorById
            implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getId() - o2.getId();
        }
    }

    public static class EmployeeComparatorByNameIgnoreCase
        implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.getName().compareToIgnoreCase(o2.getName()), 0);
        }
    }

    private static void printEmployeeList(Employee[] list) {
        for(Employee employee : list) {
            System.out.println(employee.toString());
        }
    }
}
