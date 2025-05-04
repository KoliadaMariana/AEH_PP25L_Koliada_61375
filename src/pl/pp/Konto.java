package pl.pp;

public class Konto { private String numerKonta;
    private double saldo;
    private String wlasciciel;
    private String telefon;
    private String email;


    public Konto() {
    }

    public Konto(String numerKonta, double saldo, String wlasciciel, String email, String telefon) {
        this.numerKonta = numerKonta;
        this.saldo = saldo;
        this.wlasciciel = wlasciciel;
        this.telefon = telefon;
        this.email = email;

    }

    public void wplata(double kwota) {
        if (kwota > 0) {
            saldo += kwota;
            System.out.println("Wpłata PLN " + kwota + " została wykonana. Nowe saldo: PLN " + saldo);
        } else {
            System.out.println("Kwota musi być większa niż 0.");
        }
    }

    public void wyplata(double kwota) {
        if (kwota <= saldo) {
            saldo -= kwota;
            System.out.println("Pobrano PLN " + kwota + " z konta. Pozostałe saldo: PLN " + saldo);
        } else {
            System.out.println("Brak środków. Masz tylko PLN " + saldo + " na koncie.");
        }
    }

    public String getNumerKonta() {
        return numerKonta;
    }

    public void setNumerKonta(String numerKonta) {
        this.numerKonta = numerKonta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
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
}


