package no.iskra.oppg1;

final class Person {
  final String firstName;
  final String lastName;
  final int birthYear;

  Person(String firstName, String lantName, int birthYear) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthYear = birthYear;
  }

  public String getFirstName() { return firstName; }

  public String getLastName() { return lastName; }

  public int getBirthYear() { return birthYear; }
}
