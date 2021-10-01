package KAS.storage;

import java.util.ArrayList;
import model.*;

public class Storage {
    private static ArrayList<Hotel> hoteller = new ArrayList<>();
    private static ArrayList<Konference> konferencer = new ArrayList<>();
    private static ArrayList<Deltager> deltagere = new ArrayList<>();
    private static ArrayList<Firma> firmaer = new ArrayList<>();
    //---------------------------------------------------------------------
    public static ArrayList<Hotel> getHoteller() {
        return new ArrayList<Hotel>(hoteller);
    }

    public static void addHotel(Hotel hotel){
        hoteller.add(hotel);
    }

    public static void removeHotel(Hotel hotel){
        hoteller.remove(hotel);
    }
    //---------------------------------------------------------------------
    public static ArrayList<Konference> getKonferencer() {
        return new ArrayList<Konference>(konferencer);
    }

    public static void addKonference(Konference konference){
        konferencer.add(konference);
    }

    public static void removeKonference(Konference konference){
        konferencer.remove(konference);
    }
    //---------------------------------------------------------------------
    public static ArrayList<Deltager> getDeltagere() {
        return new ArrayList<Deltager>(deltagere);
    }

    public static void addDeltager(Deltager deltager){
        deltagere.add(deltager);
    }

    public static void removeDeltager(Deltager deltager){
        deltagere.remove(deltager);
    }
    //---------------------------------------------------------------------
    public static ArrayList<Firma> getFirmaer() {
        return new ArrayList<Firma>(firmaer);
    }

    public static void addFirma(Firma firma) {
        firmaer.add(firma);
    }
}