package be.vdab.personeel;

import be.vdab.util.WerknemerDatum;
import be.vdab.util.WerknemerException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Arbeider extends Werknemer {
    private BigDecimal uurloon;
    private static final BigDecimal MINIMUMUURLOON = BigDecimal.valueOf(9.76);

    public Arbeider(int personeelnummer, WerknemerDatum datumInDienst, String naam, Geslacht geslacht, BigDecimal uurloon) {
        super(personeelnummer, datumInDienst, naam, geslacht);
        setUurloon(uurloon);
    }

    public BigDecimal getUurloon() {
        return uurloon;
    }

    public final void setUurloon(BigDecimal uurloon) {
        if (uurloon.compareTo(MINIMUMUURLOON) < 0){
            throw new WerknemerException("Het is minder dan de minimun uurloon");
        }
        this.uurloon = uurloon;
    }

    @Override
    public BigDecimal getVerloning() {
        return uurloon.multiply(BigDecimal.valueOf(7.6).multiply(BigDecimal.valueOf(65)).divide(BigDecimal.valueOf(3), 2, RoundingMode.HALF_UP));
    }

}
