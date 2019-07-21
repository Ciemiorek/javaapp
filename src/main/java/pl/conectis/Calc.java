package pl.conectis;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.ArrayList;
import java.util.List;

public class Calc {
    DescriptiveStatistics statistics = new DescriptiveStatistics();

    public void setValues(List<Double> values) {
        this.values = values;
    }

    private List<Double> values = new ArrayList<>();


    public Calc() {
        //System.out.println("Calc instance" + this);
    }

    public double mean() {


        for (int i = 0; i < values.size(); i++) {
            statistics.addValue(values.get(i));
        }

        double mean = statistics.getMean();
        return mean;
    }


    public double std() {

        for (int i = 0; i < values.size(); i++) {
            statistics.addValue(values.get(i));
        }
        double std = statistics.getStandardDeviation();

        return std;
    }


    public long sum(long a, long b) {
        return a + b;

    }

    public void clear() {
        statistics.clear();
    }

    public boolean isEven(int l) {
        if (l % 2 == 0) return true;
        return false;
    }

    public long multiply(long a, long b) {
        return a * b;
    }

    public double convertPltoEur(double pl) {
        return pl * 4.26151838;
    }

    public double convertEurtoPLN(double eur) {
        return eur / 4.26151838;
    }

    public long silnia(int i){
        long odp=1;
        for (int j = 1; j <=i ; j++) {
            odp=odp*j;

        }
        return odp;
    }
    public double divide(double x,double y){
        return x/y;
    }

}

