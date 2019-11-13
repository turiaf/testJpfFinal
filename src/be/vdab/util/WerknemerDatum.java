package be.vdab.util;

import be.vdab.util.Datum;

import java.io.Serializable;

public class WerknemerDatum extends Datum {
    private final static Datum OPRICHTINGDATUM = new Datum(12, 2, 1977);

    public WerknemerDatum(int dag, int maand, int jaar) {
        super(dag, maand, jaar);
        if (super.compareTo(OPRICHTINGDATUM) < 0){
            throw new WerknemerException("Verkeer WerknemerDatum");
        }
    }
}
