package pl.conectis;

import java.util.List;

public interface PatientMenager {


    /* Pseudo kontrakt - baza 5 pacientow max */

    public boolean addPaient(Patient patient) throws TooManyExceptions;

    public List<Patient> sortByName();

    public List<Patient> sortByYob();
    public boolean addPaientWithAge(Patient patient) throws TooManyExceptions;

    public List<Patient> findOlderThan(int years);
}
