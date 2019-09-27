package no.iskra.oppg1;

import no.iskra.oppg1.Person;
import java.util.Calendar;
import java.util.GregorianCalendar;

class Employee {
  final Person person;
  float monthlySalary;
  float tax;
  final int employeeID;
  final int emplyeeSince;
  GregorianCalendar calendar;

  Employee(String firstName, String lastName, int birthYear, float salary, float tax, int emplyeeSince, int id) {
    this.person = new Person(firstName, lastName, birthYear);
    this.monthlySalary = salary/12;
    this.tax = tax;
    this.emplyeeSince = emplyeeSince;
    this.employeeID = id;
    this.calendar = new GregorianCalendar();
  }

  public float getMonthlyTax() {
    return (this.tax / 100) * this.monthlySalary;
  }

  public float getAnnualSalary() {
    return this.monthlySalary * 12;
  }

  public float getAnnualTax() {
    return this.getMonthlyTax() * 10.5;
  }

  public String getFullName() {
    return String.format("%s, %s", person.getLastName(), person.getFirstName());
  }

  public int getAge() {
    return calendar.get(Calendar.YEAR) - person.getBirthYear();
  }

  public int getYearsSinceEmployed() {
    return calendar.get(Calendar.YEAR) - this.emplyeeSince;
  }

  public void setAnnualSalary(float salary) {
    this.monthlySalary = salary / 12;
  }

  public void setMonthlySalary(float salary) {
    this.monthlySalary = salary;
  }

  public void setTax(float tax) {
    this.tax = tax;
  }

  public bool hasBeenEmployedForXYears(int years) {
    return this.getYearsSinceEmployed() > years ? true : false;
  }
}
