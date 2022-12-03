package pl.sda.hibernate.komendy;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.hibernate.HibernateUtil;
import pl.sda.hibernate.model.Pojazd;

public class KomendaDodajPojazd implements Komenda {

    @Override
    public String getKomenda() {
        return "dodaj pojazd";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj markę pojazdu: ");
        String marka = Komenda.scanner.nextLine();

        System.out.println("Podaj model pojazdu: ");
        String model = Komenda.scanner.nextLine();

        System.out.println("Podaj vin pojazdu: ");
        String vin = Komenda.scanner.nextLine();

        System.out.println("Podaj nr rejestrowy pojazdu: ");
        String nrRej = Komenda.scanner.nextLine();


        Pojazd pojazd = Pojazd.builder()
                .marka(marka)
                .model(model)
                .nrRej(nrRej)
                .vin(vin)
                .build();

        try(Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();



            session.persist(pojazd);


            transaction.commit();

        } catch (Exception e){
            System.err.println("Błąd: "+ e);
        }



    }
}
