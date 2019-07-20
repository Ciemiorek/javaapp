package pl.conectis;


import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.List;


public class HospitalTest {

    Hospital hospital = new Hospital();
    PatientMenager hospitalWithMixedList = new Hospital(true);

    Patient patient = new Patient("Jan", 1999,"krakow","nowa");
    Patient patient1 = new Patient("Adam", 2000,"warszawa","swietokrzyska");
    Patient patient2 = new Patient("Kuba", 2001,"trzebinia","wisniowa");
    Patient patient3 = new Patient("Zenek", 2002,"katowice","dluga");
    Patient patient4 = new Patient("Janek", 2003,"Juz nie mam pomyslu","tym bardziej naulice");
    Patient patient5 = new Patient("Michal", 2003,"Gdansk","Mokra");


    @Test
    void addPatientTest() throws TooManyExceptions {
        assertTrue(hospital.addPaient(patient));
        assertTrue(hospital.addPaient(patient1));
        assertTrue(hospital.addPaient(patient2));
        assertFalse(hospital.addPaient(patient2));
        assertFalse(hospital.addPaient(patient2));
        assertTrue(hospital.addPaient(patient3));
        assertTrue(hospital.addPaient(patient4));

    }


    @Test
    void addPatientTestOnException() throws TooManyExceptions {
        assertTrue(hospital.addPaient(patient));
        assertTrue(hospital.addPaient(patient1));
        assertTrue(hospital.addPaient(patient2));
        assertFalse(hospital.addPaient(patient2));
        assertFalse(hospital.addPaient(patient2));
        assertTrue(hospital.addPaient(patient3));
        assertTrue(hospital.addPaient(patient4));
        assertThrows(TooManyExceptions.class, ()-> hospital.addPaient(patient5));

    }

    @Test
    void sortByYobTest() {
        List<Patient> listSortByYob = new ArrayList<>();

        listSortByYob.add(patient);
        listSortByYob.add(patient1);
        listSortByYob.add(patient2);
        listSortByYob.add(patient3);
        listSortByYob.add(patient4);

        assertIterableEquals(listSortByYob, hospitalWithMixedList.sortByYob());

    }

    @Test
    void sortByNameTest(){
        List<Patient> listSortByYob = new ArrayList<>();

        listSortByYob.add(patient1);
        listSortByYob.add(patient);
        listSortByYob.add(patient4);
        listSortByYob.add(patient2);
        listSortByYob.add(patient3);

        assertIterableEquals(listSortByYob, hospitalWithMixedList.sortByName());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/patient.csv")
    void addPatienWitAgeTest(String name,int age,boolean result) throws TooManyExceptions {

        hospital.addPaientWithAge(new Patient("Pawlowski",22));
        assertEquals(result,hospital.addPaientWithAge(new Patient(name,age)));

    }

    @Test
    void findOlderThanTest() throws TooManyExceptions {
        Patient patient0 = new Patient("Jan", 94);
        Patient patient1 = new Patient("Adam", 34);
        Patient patient2 = new Patient("Kuba", 67);
        Patient patient3 = new Patient("Zenek", 10);
        Patient patient4 = new Patient("Janek", 20);
        hospital.addPaientWithAge(patient0);
        hospital.addPaientWithAge(patient1);
        hospital.addPaientWithAge(patient2);
        hospital.addPaientWithAge(patient3);
        hospital.addPaientWithAge(patient4);
        assertThat(hospital.findOlderThan(30)).containsOnly(patient0,patient1,patient2);
        assertThat(hospital.findOlderThan(100)).containsOnly();
        assertThat(hospital.findOlderThan(70)).containsOnly(patient0);
        assertThat(hospital.findOlderThan(66)).containsOnly(patient0,patient2);
        assertThat(hospital.getPatientList()).filteredOn(o->o.getAge()>70).containsAll(hospital.findOlderThan(70));


    }



}
