package kz.pinemelon.entities;

// set "final" for no inheritance
public final class Views {
    public interface shortData {}

    public interface fullData extends shortData{}

    public interface superFullData extends fullData{}
}
