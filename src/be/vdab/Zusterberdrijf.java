package be.vdab;

import be.vdab.personeel.Bedrijf;
import be.vdab.personeel.Werknemer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

public class Zusterberdrijf {
    public static void main(String[] args) {
        try (ObjectInputStream stream = new ObjectInputStream(Files.newInputStream(Paths.get("personeel.dat")))) {
            Set<Werknemer> werknemers = (Set<Werknemer>)stream.readObject();
            for(Werknemer werknemer : werknemers){
                System.out.println(werknemer);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
