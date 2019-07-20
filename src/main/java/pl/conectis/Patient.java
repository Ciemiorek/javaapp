package pl.conectis;

import java.util.Objects;

public class Patient implements Comparable<Patient> {


    private String name;
    private Integer yob;
    private Adreses adreses;
    private int age;

    public Patient(String name, Integer yob,String city,String sreet) {
        this.name = name;
        this.yob = yob;
        this.adreses = new Adreses();
        this.adreses.setCity(city);
        this.adreses.setStreet(sreet);
    }

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return age == patient.age &&
                Objects.equals(name, patient.name) &&
                Objects.equals(yob, patient.yob) &&
                Objects.equals(adreses, patient.adreses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yob, adreses, age);
    }

    @Override
    public int compareTo(Patient o) {
        return name.compareTo(o.name) ;
    }

    public int compareToByYob(Patient o){
        return yob.compareTo(o.yob) ;
    }

    @Override
    public String
    toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", yob=" + yob +
                ", adreses=" + adreses +
                ", age=" + age +
                '}';
    }
}
