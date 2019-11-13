package be.vdab;

import be.vdab.util.Datum;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class DatumTest {
    public static void main(String[] args) {
        Datum[] arraydatum = new Datum[]{
                new Datum(3, 1, 1584),
                new Datum(31, 12, 4099),
                new Datum(13, 11, 2019),
                new Datum(05, 10, 1984),
                new Datum(29, 2, 1996),
                new Datum(28, 2, 2001),
        };

        Set<Datum> set = new TreeSet<>();
        set.addAll(Arrays.asList(arraydatum));
        for(Datum datum : set){
            System.out.println("datum " + datum);
            System.out.println("get dag datum: " + datum.getDag());
            System.out.println("get maad datum: " + datum.getMaand());
            System.out.println("get jaar datum: " + datum.getJaar());
            System.out.println("-----------------------------------------------");
        }
    }
}
