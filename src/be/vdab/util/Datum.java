package be.vdab.util;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Datum implements IDatum, Comparable<Datum>, Serializable {
    private static final long serialVersionUID = 1L;
    private int dag;
    private int maand;
    private int jaar;

    public Datum(int dag, int maand, int jaar) {
        if (dag < 1 || dag > 31) {
            throw new DatumException("Verkeer dag");
        } else {
            if ((isDeJaarSchrikkeljaar(jaar)) && maand == 2 && (dag < 1 || dag > 29)) {
                throw new DatumException("Verkeeer schrikkeljaar dag");
            }
            if (!(isDeJaarSchrikkeljaar(jaar)) && maand == 2 && (dag < 1 || dag > 28)) {
                throw new DatumException("Verkeeer gewoon dag");
            }
        }
        if (maand < 1 || maand > 12) {
            throw new DatumException("Verkeer maand");
        }
        if (jaar < 1584 || jaar > 4099) {
            throw new DatumException("Verkeer jaar");
        }
        this.dag = dag;
        this.maand = maand;
        this.jaar = jaar;
    }

    @Override
    public int getDag() {
        return dag;
    }

    @Override
    public int getMaand() {
        return maand;
    }

    @Override
    public int getJaar() {
        return jaar;
    }

    private boolean isDeJaarSchrikkeljaar(int jaar) {
        if (jaar % 4 == 0 || (jaar % 100 == 0 && jaar % 400 == 0)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Datum)) return false;
        Datum datum = (Datum) o;
        return getDag() == datum.getDag() &&
                getMaand() == datum.getMaand() &&
                getJaar() == datum.getJaar();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDag(), getMaand(), getJaar());
    }

    @Override
    public int compareTo(Datum o) {
        if (this.equals(o)) {
            return 0;
        }
        int intCompareJaar = this.jaar - o.getJaar();
        if (intCompareJaar < 0) {
            return -1;
        } else if (intCompareJaar > 0) {
            return 1;
        } else {
            int intCompareMaand = this.maand - o.getMaand();
            if (intCompareMaand < 0) {
                return -1;
            } else if (intCompareMaand > 0) {
                return 1;
            } else {
                int intCompareDag = this.dag - o.getDag();
                if (intCompareDag < 0) {
                    return -1;
                } else if (intCompareDag > 0) {
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return dag + "/" + maand + "/" + jaar;
    }
}
