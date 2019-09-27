package no.iskra.oppg1;

import no.iskra.oppg1.Person;
import java.util.GregorianCalendar;

class Employee {
  final Person person;
  float monthlySalary;
  float tax;
  final int employeeID;
  final int emplyeeSince;

  Employee(Person person, float salary, float tax, int emplyeeSince, int id) {
    this.person = person;
    this.monthlySalary = salary/12;
    this.tax = tax;
    this.emplyeeSince = emplyeeSince;
    this.employeeID = id;
  }
}
