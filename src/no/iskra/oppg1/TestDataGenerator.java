package no.iskra.oppg1;

import no.iskra.oppg1.Company;

final class TestDataGenerator {
  public static Company getSampleCompany() {
    Company company = new Company();
    company.addNewEmployee("Joakim", "Skogø", 1991, 232600f, 33.3f, 2009);
    company.addNewEmployee("Stine", "Reppe", 1991, 243930.2f, 32.5f, 2014);
    company.addNewEmployee("Svlad", "Cjelli", 1991, 425400f, 36f, 2013);
    company.addNewEmployee("Reidar", "Jøssund", 1995, 312500f, 34f, 2012);
    company.addNewEmployee("Lee", "Scoresby", 1982, 512500f, 34f, 2010);
    return company;
  }
}
