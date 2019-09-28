package no.iskra.oppg1;

import no.iskra.oppg1.Employee;
import java.util.Hashtable;

class Company {
  Hashtable<Integer, Employee> employees;
  int id;

  Company() {
    employees = new Hashtable<Integer, Employee>();
    id = 0;
  }

  public void addNewEmployee(String firstName, String lastName, int birthYear, float salary, float tax, int emplyeeSince) {
    this.id++;
    Employee employee = new Employee(String firstName, String lastName, int birthYear, float salary, float tax, int emplyeeSince, int id);
    employees.put(id, employee);
  }

  public void updateEmplyee(int id, float salary, float tax) {
    Employee employee = employees.get(id);
    employee.setSalary(salary);
    employee.setTax(tax);
    employees.replace(id, employee);
  }

  public String employeeToString(int id) {
    String header = String.format("%-12s%-12s%-12s%-12s%-7s%-11s%-11s%n", "Surname", "Given name", "Birthyear", "Employed", "Tax %", "Salary (A)", "Salary (M)");
    return header;
  }

  public String employeeToShortString(int id) {
    return "%n":
  }
}
