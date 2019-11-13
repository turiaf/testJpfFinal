package be.vdab.personeel;

import be.vdab.util.Datum;
import be.vdab.util.WerknemerDatum;
import be.vdab.util.WerknemerException;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Objects;

public  abstract class Werknemer implements Comparable<Werknemer>, Serializable {
    private static final long serialVersionUID = 1L;
    private final int personeelnummer;
    private WerknemerDatum datumInDienst;
    private String naam;
    private Geslacht geslacht;
    private final static DecimalFormat dt = new DecimalFormat("#.00");

    public Werknemer(int personeelnummer, WerknemerDatum datumInDienst, String naam, Geslacht geslacht) {
        if (personeelnummer <= 0){
            throw new WerknemerException("Verkeer personeelnummer");
        }
        this.personeelnummer = personeelnummer;
        this.datumInDienst = datumInDienst;
        setNaam(naam);
        this.geslacht = geslacht;
    }

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public String getNaam() {
        return naam;
    }

    public final void setNaam(String naam) {
        if (naam == null || naam.trim().isEmpty()){
            throw new WerknemerException("Verkeer Naam");
        }
        this.naam = naam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Werknemer)) return false;
        Werknemer werknemer = (Werknemer) o;
        return personeelnummer == werknemer.personeelnummer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(personeelnummer);
    }

    @Override
    public int compareTo(Werknemer o) {
        return this.personeelnummer - o.personeelnummer;
    }


    public static Comparator<Werknemer> sorteerOpNaam(){
        return (Werknemer o1, Werknemer o2) -> o1.getNaam().compareTo(o2.getNaam());
    }

    @Override
    public String toString() {
        return personeelnummer+"\t"+datumInDienst+"\t"+naam+"\t"+geslacht+"\t"+dt.format(getVerloning());
    }

    public abstract BigDecimal getVerloning();
}
