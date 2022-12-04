package pl.sda.hibernate.komendy;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.hibernate.DataAccessObject;
import pl.sda.hibernate.HibernateUtil;
import pl.sda.hibernate.model.Mechanik;

public class KomendaAktualizujMechanik implements Komenda {

    private DataAccessObject <Mechanik>dataAccessObject;
    public KomendaAktualizujMechanik(){
        this.dataAccessObject = new DataAccessObject<>();
    }
    @Override
    public String getKomenda() {
        return "aktualizuj mechanik";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj id mechanika:");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        // TODO: sprawdź, czy rekord istnieje zanim podasz X dodatkowych danych.



        System.out.println("Podaj imię mechanika: ");
        String imie = Komenda.scanner.nextLine();


        System.out.println("Podaj kwalifikację mechanika: ");
        String kwalifikacja = Komenda.scanner.nextLine();

        System.out.println("Podaj specjalizację mechanika: ");
        String specjalizacja = Komenda.scanner.nextLine();


     Mechanik mechanik = Mechanik.builder()
             .specjalizacja(specjalizacja)
             .kwalifikacja(kwalifikacja)
             .imie(imie)
             .id(id) // dopisujemy ID ponieważ do aktualizacji usimy podać IDaktualizowanego rekordu
             .build();
            dataAccessObject.update(Mechanik.class, id, mechanik);
    }
}
