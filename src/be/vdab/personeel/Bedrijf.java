package be.vdab.personeel;

import be.vdab.personeel.kader.Kaderlid;
import be.vdab.util.Functietitel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bedrijf implements Serializable {
    private static final long serialVersionUID = 1L;
    private Set<Werknemer> bedrijfslist = new HashSet<>();
    private transient final Path path = Paths.get("personeel.dat");

    public Set<Werknemer> getBedrijfslist() {
        return bedrijfslist;
    }

    public void voegWerknemerToe(Werknemer werknemer) {
        bedrijfslist.add(werknemer);
    }
    public List<Werknemer> gesorteerdelijst() {
        return bedrijfslist.stream().sorted().collect(Collectors.toList());
    }
    public List<Werknemer> gesoorteerdeLijstOpNaam() {
        return bedrijfslist.stream().sorted(Werknemer.sorteerOpNaam()).collect(Collectors.toList());
    }
    public List<Werknemer> lijstVanArbeiders() {
        return bedrijfslist.stream()
                .filter(werknemer -> werknemer instanceof Arbeider)
                .collect(Collectors.toList());
    }
    public double percentageMannelijkWernemers() {
        return (double)bedrijfslist.stream()
                .filter(werknemer -> werknemer.getGeslacht() == Geslacht.M)
                .count() * 100 / bedrijfslist.size();
    }

    public List<Werknemer> lijstvanManagers() {
        return bedrijfslist.stream()
                .filter(werknemer -> werknemer instanceof Kaderlid)
                .map(werknemer -> (Kaderlid)werknemer)
                .filter(kaderlid -> kaderlid.getFunctietitel().equals(Functietitel.MANAGER))
                .map(kaderlid -> (Werknemer)kaderlid)
                .collect(Collectors.toList());
    }


    public void printLijst(List<Werknemer> werknemerList) {
//        werknemerList.stream().forEach(werknemer -> System.out.println(werknemer));
        werknemerList.stream().forEach(System.out::println);
    }

    public void bewarenPersoneel() {
        try (ObjectOutputStream stream = new ObjectOutputStream(Files.newOutputStream(path))) {
            stream.writeObject(this.bedrijfslist);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public List<Arbeider> lijstVanArbeiders() {
//        return bedrijfslist.stream()
//                .filter(werknemer -> werknemer instanceof Arbeider)
//                .map(werknemer -> (Arbeider)werknemer)
//                .collect(Collectors.toList());
//    }
//    public List<Kaderlid> lijstvanManagers() {
//        return bedrijfslist.stream()
//                .filter(werknemer -> werknemer instanceof Kaderlid)
//                .map(werknemer -> (Kaderlid)werknemer)
//                .filter(kaderlid -> kaderlid.getFunctietitel().equals(Functietitel.MANAGER))
//                .collect(Collectors.toList());
//    }

}
