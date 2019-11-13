package be.vdab.personeel.kader;

import be.vdab.personeel.Bediende;
import be.vdab.personeel.Geslacht;
import be.vdab.util.Functietitel;
import be.vdab.util.WerknemerDatum;
import be.vdab.util.WerknemerException;

import java.math.BigDecimal;

public class Kaderlid extends Bediende {
    private Functietitel functietitel;

    public Kaderlid(int personeelnummer, WerknemerDatum datumInDienst, String naam, Geslacht geslacht, BigDecimal maandwedde, Functietitel functietitel) {
        super(personeelnummer, datumInDienst, naam, geslacht, maandwedde);
        setFunctietitel(functietitel);
    }

    public Functietitel getFunctietitel() {
        return functietitel;
    }

    public final void setFunctietitel(Functietitel functietitel) {
        if(functietitel == null){
            throw new WerknemerException("Functietitel moet ingevoeld worden");
        }
        this.functietitel = functietitel;
    }
}
