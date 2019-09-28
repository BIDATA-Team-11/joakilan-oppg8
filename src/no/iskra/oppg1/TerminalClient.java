package no.iskra.oppg1;

import no.iskra.oppg1.Company;
import no.iskra.oppg1.TestDataGenerator;
import java.util.Scanner;

class TerminalClient {
  public static void main(String[] args) {
    final Company company = TestDataGenerator.getSampleCompany();
    Scanner scanner = new Scanner(System.in);

    mainLoop(scanner, company);
  }

  static void mainLoop(Scanner cmd, Company company) {
    String[] command;
    while (true) {
      System.out.printf("%n> ");
      command = cmd.nextLine().toLowerCase().split("\\s");
      if (command[0].equals("exit")) {
        break;
      } else if (command[0].equals("id")) {
        employeeDetailsLoop();
      } else if (command[0].equals("help")) {
        terminalHelp();
      } else if (command[0].equals("list")) {
        System.out.println(company.listEmployeesFull());
      } else {
        System.out.println("Invalid command. Type 'help' for usage.");
      }
    }
  }

  static void employeeDetailsLoop() {
    System.out.println("Details for:");
  }

  static void terminalHelp() {
    System.out.println("Usage:");
  }
}
