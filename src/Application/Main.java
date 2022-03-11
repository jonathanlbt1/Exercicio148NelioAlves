package Application;

import Entities.Employee;
import Entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = scan.nextInt();

        for(int i=1; i<=n; i++) {
            System.out.println(String.format("Employee #%d", i) + " data:");
            System.out.print("Outsourced (y/n)? ");
            char l = scan.next().charAt(0);

            System.out.print("Name: ");
            scan.nextLine();
            String name = scan.nextLine();

            System.out.print("Hours: ");
            int hours = scan.nextInt();

            System.out.print("Value per hour: ");
            double vph = scan.nextDouble();
            if (l == 'y') {
                System.out.print("Additional charge: ");
                double extraValue = scan.nextDouble();
                Employee emp = new OutsourcedEmployee(name, hours, vph, extraValue);
                list.add(emp);
            } else {
                Employee emp = new Employee(name, hours, vph);
                list.add(emp);
            }
        }
        System.out.println();

        System.out.println("Payment: ");
        for(Employee emp : list) {
            System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
        }
        scan.close();
    }
}
