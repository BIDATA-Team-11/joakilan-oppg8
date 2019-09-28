package no.iskra.oppg1;

final class Person {
  final String firstName;
  final String lastName;
  final int birthYear;

  Person(String firstName, String lastName, int birthYear) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthYear = birthYear;
  }

  public String getFirstName() { return this.firstName; }

  public String getLastName() { return this.lastName; }

  public int getBirthyear() { return this.birthYear; }
}
