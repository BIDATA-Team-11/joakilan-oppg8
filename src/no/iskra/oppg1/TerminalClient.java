package no.iskra.oppg1;

import no.iskra.oppg1.Company;
import no.iskra.oppg1.TestDataGenerator;
import java.util.Scanner;

class TerminalClient {
  public static void main(String[] args) {
    System.out.println("Welcome to Svlads Awesome Employee Manager!");
    System.out.println("Type 'help' if this is your first time here.");

    final Company company = TestDataGenerator.getSampleCompany();
    Scanner scanner = new Scanner(System.in);

    mainLoop(scanner, company);

    System.out.println();
  }

  static void mainLoop(Scanner cmd, Company company) {
    String[] command;
    while (true) {
      System.out.printf("%nMain > ");
      command = cmd.nextLine().toLowerCase().split("\\s");
      if (command[0].equals("exit")) {
        break;
      } else if (command[0].equals("id")) {
        try {
          int id = Integer.parseInt(command[1]);
          employeeDetailsLoop(cmd, company.getEmployeeByID(id));
        } catch(NumberFormatException e) {
          System.out.println("\nMalformed command.");
        } catch(Exception e) {
          System.out.println("\nCongratulations! You found a bug.\n");
          System.out.println(e);
        }
      } else if (command[0].equals("help")) {
        mainMenuHelp();
      } else if (command[0].equals("list")) {
        System.out.println();
        System.out.println(company.listEmployeesFull());
      } else if (command[0].equals("new")) {
        addNewEmployee(cmd, company);
      } else {
        System.out.println("Invalid command. Type 'help' for usage.");
      }
    }
  }

  static void employeeDetailsLoop(Scanner cmd, Employee employee) {
    String[] command;
    System.out.printf("%nSelected employee %s%n", employee.getFullName());
    employeeDetailsHelp();
    while (true) {
      System.out.printf("%nEmployee %d > ", employee.getID());
      command = cmd.nextLine().toLowerCase().split("\\s");
      if (command[0].equals("exit") || command[0].equals("back")) {
        break;
      } else if (command[0].equals("help")) {
        employeeDetailsHelp();
      } else if (command[0].equals("get")) {
        if (command[1].equals("salary")) {
          System.out.printf("%n%-22s%.2fKr%n", "Gross annual salary: ", employee.getAnnualSalary());
          System.out.printf("%-22s%.2fKr%n", "Net annual salary: ", employee.getAnnualSalary()-employee.getAnnualTax());
          System.out.printf("%-22s%.2fKr%n", "Gross monthly salary: ", employee.getAnnualSalary()/12f);
          System.out.printf("%-22s%.2fKr%n", "Net monthly salary: ", (employee.getAnnualSalary()-employee.getAnnualTax())/12f);
        } else if (command[1].equals("tax")) {
          System.out.printf("%n%-22s%.2g%%%n", "Tax percentage: ", employee.getTaxPercent());
          System.out.printf("%-22s%.2fKr%n", "Annual tax: ", employee.getAnnualTax());
          System.out.printf("%-22s%.2fKr%n", "Monthly tax: ", employee.getMonthlyTax());
        }
      } else if (command[0].equals("details")) {
        System.out.printf("%n%-11s%s%n", "Full name: ", employee.getFullName());
        System.out.printf("%-11s%d%n", "Birthyear: ", employee.getBirthyear());
      }
    }
  }

  static void addNewEmployee(Scanner cmd, Company company) {
    try {
      System.out.println("Add new employee");
      System.out.printf("%nGiven name > ");
      String name = cmd.nextLine();
      System.out.printf("%nSurname > ");
      String surname = cmd.nextLine();
      System.out.printf("%nBirthyear > ");
      int birthyear = Integer.parseInt(cmd.nextLine());
      System.out.printf("%nGross annual salary > ");
      float salary = Float.parseFloat(cmd.nextLine());
      System.out.printf("%nTax percentage > ");
      float tax = Float.parseFloat(cmd.nextLine());
      System.out.printf("%nEmployed (year) > ");
      int employeeSince = Integer.parseInt(cmd.nextLine());

      company.addNewEmployee(name, surname, birthyear, salary, tax, employeeSince);
    } catch(Exception e) {
      System.out.println("Invalid input. Aborted.");
    }

    System.out.println("New employee successflly added.");
  }

  static void mainMenuHelp() {
    System.out.printf("%n%-17s%s%n", "list", "List all emplyees");
    System.out.printf("%-17s%s%n", "id [employee ID]", "Select an employee by ID");
    System.out.printf("%-17s%s%n", "new", "Add new employee");
    System.out.printf("%-17s%s%n", "exit", "Quit program");
    System.out.printf("%-17s%s%n", "help", "Display this text");
  }

  static void employeeDetailsHelp() {
    System.out.printf("%n%-20s%s%n", "details", "List stored personal info");
    System.out.printf("%-20s%s%n", "get salary", "Information about salary");
    System.out.printf("%-20s%s%n", "get tax", "Information about tax");
    System.out.printf("%-20s%s%n", "set salary [number]", "Set new annual salary");
    System.out.printf("%-20s%s%n", "set tax [number]", "Set new tax percentage");
    System.out.printf("%-20s%s%n", "back/exit", "Back to main");
    System.out.printf("%-20s%s%n", "help", "Display this text");
  }
}
