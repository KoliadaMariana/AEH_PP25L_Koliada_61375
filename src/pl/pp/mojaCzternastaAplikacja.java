package pl.pp;

abstract class Pojazd {
    protected String nrRejestracyjny;
    protected String numerVin;
    protected String kolor;
    protected double cena;
    protected double spalanie;
    protected double poziomPaliwa;
    protected double przebieg;

    public Pojazd(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie, double poziomPaliwa, double przebieg) {
        this.nrRejestracyjny = nrRejestracyjny;
        this.numerVin = numerVin;
        this.kolor = kolor;
        this.cena = cena;
        this.spalanie = spalanie;
        this.poziomPaliwa = poziomPaliwa;
        this.przebieg = przebieg;
    }

    public void zatankuj(double ilosc) {
        poziomPaliwa += ilosc;
        System.out.println("Zatankowano " + ilosc + " L. Poziom paliwa: " + poziomPaliwa + " L");
    }

    public abstract void prowadz(double dystans);
}

interface TypPaliwa {
    String getTypPaliwa();
}

class Osobowe extends Pojazd implements TypPaliwa {
    private int liczbaDrzwi;
    private String typPaliwa;

    public Osobowe(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie, double poziomPaliwa, double przebieg, int liczbaDrzwi, String typPaliwa) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.liczbaDrzwi = liczbaDrzwi;
        this.typPaliwa = typPaliwa;
    }

    @Override
    public void prowadz(double dystans) {
        double zuzycie = (dystans / 100.0) * spalanie;
        if (poziomPaliwa >= zuzycie) {
            poziomPaliwa -= zuzycie;
            przebieg += dystans;
            System.out.println("Osobowy przejechał " + dystans + " km. Pozostało paliwa: " + poziomPaliwa + " L");
        } else {
            System.out.println("Za mało paliwa.");
        }
    }

    @Override
    public String getTypPaliwa() {
        return typPaliwa;
    }
}

class Ciezarowka extends Pojazd implements TypPaliwa {
    private double ladownosc;
    private String typPaliwa;

    public Ciezarowka(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie, double poziomPaliwa, double przebieg, double ladownosc, String typPaliwa) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.ladownosc = ladownosc;
        this.typPaliwa = typPaliwa;
    }

    @Override
    public void prowadz(double dystans) {
        double zuzycie = (dystans / 100.0) * spalanie;
        if (poziomPaliwa >= zuzycie) {
            poziomPaliwa -= zuzycie;
            przebieg += dystans;
            System.out.println("Ciężarówka przejechała " + dystans + " km. Pozostało paliwa: " + poziomPaliwa + " L");
        } else {
            System.out.println("Za mało paliwa.");
        }
    }

    @Override
    public String getTypPaliwa() {
        return typPaliwa;
    }
}

class Motocykl extends Pojazd implements TypPaliwa {
    private boolean posiadaDostawke;
    private String typPaliwa;

    public Motocykl(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie, double poziomPaliwa, double przebieg, boolean posiadaDostawke, String typPaliwa) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.posiadaDostawke = posiadaDostawke;
        this.typPaliwa = typPaliwa;
    }

    @Override
    public void prowadz(double dystans) {
        double zuzycie = (dystans / 100.0) * spalanie;
        if (poziomPaliwa >= zuzycie) {
            poziomPaliwa -= zuzycie;
            przebieg += dystans;
            System.out.println("Motocykl przejechał " + dystans + " km. Pozostało paliwa: " + poziomPaliwa + " L");
        } else {
            System.out.println("Brak paliwa.");
        }
    }

    @Override
    public String getTypPaliwa() {
        return typPaliwa;
    }
}

class SprzetBudowlany extends Pojazd implements TypPaliwa {
    private int przepracowaneGodziny;
    private String typPaliwa;

    public SprzetBudowlany(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie, double poziomPaliwa, double przebieg, int przepracowaneGodziny, String typPaliwa) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.przepracowaneGodziny = przepracowaneGodziny;
        this.typPaliwa = typPaliwa;
    }

    @Override
    public void prowadz(double godziny) {
        double zuzycie = godziny * (spalanie / 10.0);
        if (poziomPaliwa >= zuzycie) {
            poziomPaliwa -= zuzycie;
            przepracowaneGodziny += godziny;
            System.out.println("Sprzęt pracował " + godziny + " h. Pozostało paliwa: " + poziomPaliwa + " L");
        } else {
            System.out.println("Za mało paliwa.");
        }
    }

    @Override
    public String getTypPaliwa() {
        return typPaliwa;
    }
}

public class mojaCzternastaAplikacja {
    public static void main(String[] args) {
        Osobowe osobowy = new Osobowe("DW1234", "VIN123", "Czarny", 45000, 6.5, 30, 120000, 5, "Benzyna");
        Ciezarowka ciezarowka = new Ciezarowka("PO4567", "VIN456", "Biały", 120000, 15, 100, 300000, 8000, "Diesel");
        Motocykl motocykl = new Motocykl("KR7890", "VIN789", "Czerwony", 18000, 4, 12, 20000, true, "Benzyna");
        SprzetBudowlany sprzet = new SprzetBudowlany("LU4321", "VIN321", "Żółty", 250000, 25, 80, 5000, 1200, "Diesel");

        osobowy.prowadz(100);
        osobowy.zatankuj(20);
        System.out.println("Paliwo: " + osobowy.getTypPaliwa());

        ciezarowka.prowadz(150);
        motocykl.prowadz(60);
        sprzet.prowadz(5);
    }
}