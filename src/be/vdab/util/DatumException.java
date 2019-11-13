package be.vdab.util;

public class DatumException extends RuntimeException {

    public DatumException() {
    }
    public DatumException(String omschrijving) {
        super(omschrijving);
    }
}
