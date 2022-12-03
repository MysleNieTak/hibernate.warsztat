package pl.sda.hibernate.komendy;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.hibernate.HibernateUtil;
import pl.sda.hibernate.model.Mechanik;
import pl.sda.hibernate.model.Pojazd;

public class KomendaDodajMechanik implements Komenda {

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

        try(Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();



            session.persist(mechanik);


            transaction.commit();

        } catch (Exception e){
            System.err.println("Błąd: "+ e);
        }



    }
}
