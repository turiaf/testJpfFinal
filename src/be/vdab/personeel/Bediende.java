package be.vdab.personeel;

import be.vdab.util.WerknemerDatum;
import be.vdab.util.WerknemerException;

import java.math.BigDecimal;

public class Bediende extends Werknemer {
    private BigDecimal maandwedde;
    private static final BigDecimal MINIMMAANDWEDDE = BigDecimal.valueOf(1129.47);

    public Bediende(int personeelnummer, WerknemerDatum datumInDienst, String naam, Geslacht geslacht, BigDecimal maandwedde) {
        super(personeelnummer, datumInDienst, naam, geslacht);
        setMaandwedde(maandwedde);
    }

    public BigDecimal getMaandwedde() {
        return maandwedde;
    }

    public final void setMaandwedde(BigDecimal maandwedde) {
        if(maandwedde.compareTo(MINIMMAANDWEDDE) < 0){
            throw new WerknemerException("Het is minder dan de minimun maandwedde");
        }
        this.maandwedde = maandwedde;
    }

    @Override
    public BigDecimal getVerloning() {
        return maandwedde;
    }

}
