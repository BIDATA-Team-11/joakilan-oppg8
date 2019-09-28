package no.iskra.oppg1;

import no.iskra.oppg1.Company;

final class TestDataGenerator {
  public static Company getSampleCompany() {
    Company company = new Company();
    company.addNewEmployee("Joakim", "Skogø", 1991, 200000f, 33.3f, 2009);
    company.addNewEmployee("Stine", "Reppe", 1991, 223930.2f, 32.5f, 2014);
    company.addNewEmployee("Ingvild M.", "Kvisle", 1991, 225400f, 36f, 2013);
    company.addNewEmployee("Reidar", "Jøssund", 1995, 212500f, 34f, 2012);
    return company;
  }
}
