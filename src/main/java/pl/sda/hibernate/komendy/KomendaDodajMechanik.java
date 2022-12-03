package pl.sda.hibernate.komendy;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.hibernate.HibernateUtil;
import pl.sda.hibernate.model.DataAccessObject;
import pl.sda.hibernate.model.Mechanik;
import pl.sda.hibernate.model.Pojazd;

public class KomendaDodajMechanik implements Komenda {

    private DataAccessObject <Mechanik>dataAccessObject;
    public KomendaDodajMechanik(){
        this.dataAccessObject = new DataAccessObject<>();
    }
    @Override
    public String getKomenda() {
        return "dodaj mechanik";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj imię mechanika: ");
        String imie = Komenda.scanner.nextLine();

        System.out.println("Podaj kwalifikację mechanika: ");
        String kwalifikacja = Komenda.scanner.nextLine();

        System.out.println("Podaj specjalizację mechanika: ");
        String specjalizacja = Komenda.scanner.nextLine();


        Mechanik mechanik = Mechanik.builder()
                .imie(imie)
                .kwalifikacja(kwalifikacja)
                .specjalizacja(specjalizacja)
                .build();

    dataAccessObject.insert(mechanik);


    }
}
