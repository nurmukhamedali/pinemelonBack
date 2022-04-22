package kz.pinemelon.entities;

// set "final" for no inheritance
public final class Views {
    public interface identificator {}
    public interface productDataShort extends identificator{}
    public interface productDataFull extends productDataShort{}
    public interface categoryDataShort extends identificator{}
    public interface categoryDataFull extends categoryDataShort{}
    public interface cartDataShort extends identificator{}
    public interface cartDataFull extends categoryDataShort{}
    public interface shortData {}

    public interface fullData extends shortData{}
    public interface superFullData extends fullData{}

}
