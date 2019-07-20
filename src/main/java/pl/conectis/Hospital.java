package pl.conectis;

import java.util.ArrayList;
import java.util.List;

public class Hospital implements PatientMenager {


    private List<Patient> patientList;

    public Hospital() {
        this.patientList = new ArrayList<>();
    }

    public Hospital(boolean test) {
        this.patientList = new ArrayList<>();
        Patient patient = new Patient("Jan", 1999, "krakow", "nowa");
        Patient patient1 = new Patient("Adam", 2000, "warszawa", "swietokrzyska");
        Patient patient2 = new Patient("Kuba", 2001, "trzebinia", "wisniowa");
        Patient patient3 = new Patient("Zenek", 2002, "katowice", "dluga");
        Patient patient4 = new Patient("Janek", 2003, "Juz nie mam pomyslu", "tym bardziej naulice");
        Patient patient5 = new Patient("Michal", 2003, "Gdansk", "Mokra");


        patientList.add(patient4);
        patientList.add(patient3);
        patientList.add(patient1);
        patientList.add(patient);
        patientList.add(patient2);

    }


    public List<Patient> getPatientList() {
        return patientList;
    }


    @Override
    public boolean addPaient(Patient patient) throws TooManyExceptions {
        if (patientList.size() >= 5) {
            throw new TooManyExceptions();
        }
        for (Patient patient1 : patientList) {
            if (patient1.equals(patient)) {
                return false;
            }
        }
        boolean answer = patientList.add(patient);
        return answer;
    }

    @Override
    public List<Patient> sortByName() {
        patientList.sort(Patient::compareTo);

        return patientList;
    }

    @Override
    public List<Patient> sortByYob() {
        patientList.sort(Patient::compareToByYob);

        return patientList;
    }


    @Override
    public boolean addPaientWithAge(Patient patient) throws TooManyExceptions {

        if (patientList.size() >= 5) {
            throw new TooManyExceptions();
        }
        for (Patient patient1 : patientList) {
            if (patient1.equals(patient)) {
                return false;
            }
        }
        if (patient.getAge() >= 0 && patient.getAge() <= 200) {

            patientList.add(patient);
            return true;
        }
        return false;
    }

    @Override
    public List<Patient> findOlderThan(int years) {
        List<Patient> result = new ArrayList<>();
        for (Patient patient : patientList) {
            if (patient.getAge() > years) {
                result.add(patient);
            }
        }
        return result;
    }


}
