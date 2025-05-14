package pl.pp;

public class Magazyn { private int numerMagazynu;
    private int pojemnoscMagazynu;
    private int zajetaPrzestrzen = 0;
    private String wlasciciel;
    private String email;
    private String telefon;

    public Magazyn(int numerMagazynu, int pojemnoscMagazynu, String wlasciciel, String email, String telefon) {
        setNumerMagazynu(numerMagazynu);
        setPojemnoscMagazynu(pojemnoscMagazynu);
        setWlasciciel(wlasciciel);
        setEmail(email);
        setTelefon(telefon);
    }
    public int getNumerMagazynu() {
        return numerMagazynu;
    }

    public void setNumerMagazynu(int numerMagazynu) {
        this.numerMagazynu = numerMagazynu;
    }

    public int getPojemnoscMagazynu() {
        return pojemnoscMagazynu;
    }

    public void setPojemnoscMagazynu(int pojemnoscMagazynu) {
        this.pojemnoscMagazynu = pojemnoscMagazynu;
    }

    public int getZajetaPrzestrzen() {
        return zajetaPrzestrzen;
    }

    public void setZajetaPrzestrzen(int zajetaPrzestrzen) {
        this.zajetaPrzestrzen = zajetaPrzestrzen;
    }

    public String getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(String wlasciciel) {
        this.wlasciciel = wlasciciel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void dodajTowar(int ilosc) {
        if (getZajetaPrzestrzen() + ilosc <= getPojemnoscMagazynu()) {
            setZajetaPrzestrzen(getZajetaPrzestrzen() + ilosc);
            System.out.println("Dodano " + ilosc + " jednostek towaru. Pozostała przestrzeń magazynowa: "
                    + (getPojemnoscMagazynu() - getZajetaPrzestrzen()) + " jednostek.");
        } else {
            System.out.println("Za mało miejsca w magazynie. Pozostała przestrzeń magazynowa: " +
                    (getPojemnoscMagazynu() - getZajetaPrzestrzen()) + " jednostek.");
        }
    }
    public void usunTowar(int ilosc) {
        if (ilosc <= getZajetaPrzestrzen()) {
            setZajetaPrzestrzen(getZajetaPrzestrzen() - ilosc);
            System.out.println("Usunięto " + ilosc + " jednostek towaru. Pozostała przestrzeń magazynowa: "
                    + (getPojemnoscMagazynu() - getZajetaPrzestrzen()) + " jednostek.");
        } else {
            System.out.println("Nie można usunąć więcej towaru niż jest w magazynie. Zajęta przestrzeń: " + getZajetaPrzestrzen() + " jednostek.");
        }
    }
    public void sprawdzZajetosc() {
        System.out.println("Zajęta przestrzeń magazynowa: " + getZajetaPrzestrzen());
        System.out.println("Dostępna przestrzeń magazynowa: " + (getPojemnoscMagazynu() - getZajetaPrzestrzen()));
    }
    public void aktualizujKontakt(String nowyEmail, String nowyTelefon) {
        setEmail(nowyEmail);
        setTelefon(nowyTelefon);
        System.out.println("Zaktualizowano dane kontaktowe właściciela.");
        System.out.println("Nowy email: " + getEmail());
        System.out.println("Nowy numer telefonu: " + getTelefon());
    }
}
