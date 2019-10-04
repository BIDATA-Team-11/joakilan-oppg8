package no.iskra.oppg1;

import no.iskra.oppg1.Employee;
import java.util.Hashtable;
import java.util.Map;

class Company {
  Hashtable<Integer, Employee> employees;
  int id;

  Company() {
    employees = new Hashtable<Integer, Employee>();
    id = 0;
  }

  public void addNewEmployee(String firstName, String lastName, int birthYear, float salary, float tax, int emplyeeSince) {
    this.id++;
    Employee employee = new Employee(firstName, lastName, birthYear, salary, tax, emplyeeSince, id);
    employees.put(id, employee);
  }

  public void updateEmplyee(int id, float salary, float tax) {
    Employee employee = employees.get(id);
    employee.setAnnualSalary(salary);
    employee.setTax(tax);
    employees.replace(id, employee);
  }

  public String listEmployeesFull() {
    String headerFmt = "%-3s%-20s%-10s%-9s%-7s%-11s%-11s%n";
    String employeeFmt = "%-3d%-20s%-10d%-9d%-7.2f%-11.2f%-11.2f%n";
    String list = String.format(headerFmt, "ID", "Name", "Birthyear", "Employed", "Tax %", "Salary (A)", "Salary (M)");
    for (Map.Entry<Integer, Employee> employee : this.employees.entrySet()) {
      Employee emp = employee.getValue();
      list += String.format(employeeFmt, emp.getID(), emp.getFullName(), emp.getBirthyear(), emp.getEmployeeSince(), emp.getTaxPercent(), emp.getAnnualSalary(), emp.getAnnualSalary()/12);
    }
    return list;
  }

  public String employeeToShortString(int id) {
    return "%n";
  }

  public Employee getEmployeeByID(int id) {
    return employees.get(id);
  }

  public void removeEmployeeByID(int id) {
    this.employees.remove(id);
  }
}
