package pl.pp;

import java.util.*;

abstract class Wydarzenie {
    protected String id;
    protected String tytul;
    protected String miejsce;
    protected String data;
    protected boolean zarezerwowane;
    protected String jezyk;

    public Wydarzenie(String id, String tytul, String miejsce, String data, String jezyk) {
        this.id = id;
        this.tytul = tytul;
        this.miejsce = miejsce;
        this.data = data;
        this.jezyk = jezyk;
        this.zarezerwowane = false;
    }

    public void zarezerwuj() {
        if (!zarezerwowane) {
            zarezerwowane = true;
            System.out.println("Zarezerwowano bilet na: " + tytul);
        } else {
            System.out.println("Bilet już zarezerwowany.");
        }
    }

    public void anuluj() {
        if (zarezerwowane) {
            zarezerwowane = false;
            System.out.println("Anulowano rezerwację na: " + tytul);
        } else {
            System.out.println("Nie było aktywnej rezerwacji.");
        }
    }

    public boolean isZarezerwowane() {
        return zarezerwowane;
    }

    public abstract String getTyp();
}

interface TypWydarzenia {
    String getTyp();
}

class Koncert extends Wydarzenie implements TypWydarzenia {
    public Koncert(String id, String tytul, String miejsce, String data, String jezyk) {
        super(id, tytul, miejsce, data, jezyk);
    }

    @Override
    public String getTyp() {
        return "Koncert";
    }
}

class Teatr extends Wydarzenie implements TypWydarzenia {
    public Teatr(String id, String tytul, String miejsce, String data, String jezyk) {
        super(id, tytul, miejsce, data, jezyk);
    }

    @Override
    public String getTyp() {
        return "Teatr";
    }
}

class Film extends Wydarzenie implements TypWydarzenia {
    public Film(String id, String tytul, String miejsce, String data, String jezyk) {
        super(id, tytul, miejsce, data, jezyk);
    }

    @Override
    public String getTyp() {
        return "Film";
    }
}

class Wystawa extends Wydarzenie implements TypWydarzenia {
    public Wystawa(String id, String tytul, String miejsce, String data, String jezyk) {
        super(id, tytul, miejsce, data, jezyk);
    }

    @Override
    public String getTyp() {
        return "Wystawa";
    }
}

class SystemRezerwacji {
    private List<Wydarzenie> wydarzenia = new ArrayList<>();

    public void dodajWydarzenie(Wydarzenie wydarzenie) {
        wydarzenia.add(wydarzenie);
    }

    public void zarezerwujBilet(String id) {
        for (Wydarzenie w : wydarzenia) {
            if (w.id.equals(id)) {
                w.zarezerwuj();
                return;
            }
        }
        System.out.println("Nie znaleziono wydarzenia o ID: " + id);
    }

    public void anulujRezerwacje(String id) {
        for (Wydarzenie w : wydarzenia) {
            if (w.id.equals(id)) {
                w.anuluj();
                return;
            }
        }
        System.out.println("Nie znaleziono wydarzenia o ID: " + id);
    }

    public void wyswietlDostepneWydarzenia() {
        System.out.println("Dostępne wydarzenia:");
        for (Wydarzenie w : wydarzenia) {
            if (!w.zarezerwowane) {
                System.out.println(w.tytul + " - " + w.getTyp() + " - " + w.data);
            }
        }
    }

    public void wyswietlZarezerwowane() {
        System.out.println("Zarezerwowane wydarzenia:");
        for (Wydarzenie w : wydarzenia) {
            if (w.zarezerwowane) {
                System.out.println(w.tytul + " - " + w.getTyp() + " - " + w.data);
            }
        }
    }

    public void szukajPoTytule(String tytul) {
        System.out.println("Wyszukiwanie: " + tytul);
        for (Wydarzenie w : wydarzenia) {
            if (w.tytul.toLowerCase().contains(tytul.toLowerCase())) {
                System.out.println(w.tytul + " - " + w.getTyp() + " - " + w.data);
            }
        }
    }
}

public class mojaPietnastaAplikacja {
    public static void main(String[] args) {
        SystemRezerwacji system = new SystemRezerwacji();

        system.dodajWydarzenie(new Koncert("101", "Coldplay - Music of the Spheres", "PGE Narodowy", "2025-07-20", "Angielski"));
        system.dodajWydarzenie(new Teatr("102", "Hamlet", "Teatr Wielki", "2025-08-10", "Polski"));
        system.dodajWydarzenie(new Film("103", "Oppenheimer", "Multikino Złote Tarasy", "2025-07-05", "Angielski"));
        system.dodajWydarzenie(new Wystawa("104", "Leonardo da Vinci - Geniusz i Wynalazki", "Muzeum Techniki", "2025-09-15", "Polski"));
        system.dodajWydarzenie(new Koncert("105", "Sanah - Uczta", "Hala Stulecia", "2025-10-01", "Polski"));
        system.dodajWydarzenie(new Teatr("106", "Balladyna", "Teatr Narodowy", "2025-09-03", "Polski"));

        system.wyswietlDostepneWydarzenia();

        system.zarezerwujBilet("102");
        system.zarezerwujBilet("105");

        system.wyswietlZarezerwowane();

        system.szukajPoTytule("leonardo");
        system.anulujRezerwacje("102");
    }
}