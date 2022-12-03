package pl.sda.hibernate.komendy;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import pl.sda.hibernate.HibernateUtil;
import pl.sda.hibernate.model.DataAccessObject;
import pl.sda.hibernate.model.Pojazd;

import java.util.List;

public class KomendaListaPojazd implements Komenda {

    @Override
    public String getKomenda() {
        return "lista pojazd";
    }

    @Override
    public void obsluga() {

    try(Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
        TypedQuery<Pojazd> zapytanie = session.createQuery("FROM Pojazd", Pojazd.class);
        List<Pojazd> lista = zapytanie.getResultList();

        lista.forEach(System.out::println);


    } catch (Exception e){
        System.err.println("Błąd: "+e);
    }


    }
}
