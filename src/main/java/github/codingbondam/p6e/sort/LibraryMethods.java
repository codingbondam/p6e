package main.java.github.codingbondam.p6e.sort;

import java.util.*;

public class LibraryMethods {

    public static class Employee {

        int id;

        String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "id: " + id + " name: " + name;
        }
    }

    public static class EmployeeComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.id - o2.id;
        }

    }

    public static void main(String[] args) {

        Employee[] employees = new Employee[3];
        employees[0] = new Employee(4, "Ram");
        employees[1] = new Employee(3, "Nitin");
        employees[2] = new Employee(1, "Krishna");
        Arrays.sort(employees, new EmployeeComparator());

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].toString());
        }

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(4, "Ram"));
        employeeList.add(new Employee(3, "Nitin"));
        employeeList.add(new Employee(1, "Krishna"));
        Collections.sort(employeeList, new EmployeeComparator());

        for (Employee e : employeeList) {
            System.out.println(e.toString());
        }

    }
}
