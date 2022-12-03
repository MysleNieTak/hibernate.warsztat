package pl.sda.hibernate.komendy;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import pl.sda.hibernate.HibernateUtil;
import pl.sda.hibernate.model.Mechanik;
import pl.sda.hibernate.model.Pojazd;

import java.util.List;

public class KomendaListaMechanik implements Komenda {

    @Override
    public String getKomenda() {
        return "lista mechanik";
    }

    @Override
    public void obsluga() {

    try(Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
        TypedQuery<Mechanik> zapytanie = session.createQuery("FROM Mechanik", Mechanik.class);
        List<Mechanik> lista = zapytanie.getResultList();

        lista.forEach(System.out::println);
        

    } catch (Exception e){
        System.err.println("Błąd: "+e);
    }


    }
}
