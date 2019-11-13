package be.vdab;

import be.vdab.personeel.*;
import be.vdab.personeel.kader.Kaderlid;
import be.vdab.util.DatumException;
import be.vdab.util.Functietitel;
import be.vdab.util.WerknemerDatum;
import be.vdab.util.WerknemerException;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BedrijfApp {
    public static void main(String[] args) {
        Bedrijf bedrijf = new Bedrijf();
        try {
            Werknemer bediende1 = new Bediende(10, new WerknemerDatum(13,02,1977), "bediende1", Geslacht.M, BigDecimal.valueOf(1_500));
            Werknemer bediende2 = new Bediende(2, new WerknemerDatum(14,02,1977), "bediende2", Geslacht.V, BigDecimal.valueOf(2_000));
            Werknemer bediende3 = new Bediende(11, new WerknemerDatum(13,11,2019), "bediende3", Geslacht.V, BigDecimal.valueOf(3_200));
            Werknemer arbeider1 = new Arbeider(3, new WerknemerDatum(15,02, 1977), "arbeider1", Geslacht.M, BigDecimal.valueOf(13.5));
            Werknemer arbeider2 = new Arbeider(4, new WerknemerDatum(16,02, 1977), "arbeider2", Geslacht.V, BigDecimal.valueOf(14.9));
            Werknemer kaderlid1 = new Kaderlid(5, new WerknemerDatum(13,02, 1977), "kaderlid1", Geslacht.M, BigDecimal.valueOf(10_000), Functietitel.DIRECTEUR);
            Werknemer kaderlid2 = new Kaderlid(6, new WerknemerDatum(13,02, 1977), "kaderlid2", Geslacht.M, BigDecimal.valueOf(8_000), Functietitel.CEO);
            Werknemer kaderlid3 = new Kaderlid(25, new WerknemerDatum(26,05, 2000), "kaderlid3", Geslacht.M, BigDecimal.valueOf(7_000), Functietitel.MANAGER);

            List<Werknemer> werknemers = new ArrayList<>();

            werknemers.addAll(Arrays.asList(bediende1, bediende2, arbeider1, arbeider2, kaderlid1, kaderlid2, kaderlid3, bediende3));
            werknemers.add(new Bediende(14, new WerknemerDatum(01,01,1980), "bediende4", Geslacht.M, BigDecimal.valueOf(2_100)));

            for (Werknemer werknemer : werknemers){
                bedrijf.voegWerknemerToe(werknemer);
            }
            System.out.println("-------------------------------- gesorteerdelijst -----------------------------------");
            bedrijf.printLijst(bedrijf.gesorteerdelijst());

            System.out.println("-------------------------------- gesoorteerdeLijstOpNaam ----------------------------");
            bedrijf.printLijst(bedrijf.gesoorteerdeLijstOpNaam());

            System.out.println("-------------------------------- lijstVanArbeiders ----------------------------------");
            bedrijf.printLijst(bedrijf.lijstVanArbeiders());

            System.out.println("-------------------------------- percentageMannelijkWernemers -----------------------");
            System.out.printf("%05.2f %%" ,bedrijf.percentageMannelijkWernemers());
            System.out.println("");

            System.out.println("-------------------------------- lijstvanManagers -----------------------------------");
            bedrijf.printLijst(bedrijf.lijstvanManagers());

            bedrijf.bewarenPersoneel();
        } catch (WerknemerException e){
            System.out.println(e.getMessage());
        } catch (DatumException ex){
            System.out.println(ex.getMessage());
        }
    }
}
