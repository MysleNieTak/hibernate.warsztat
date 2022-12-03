package pl.sda.hibernate.komendy;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import pl.sda.hibernate.HibernateUtil;
import pl.sda.hibernate.model.DataAccessObject;
import pl.sda.hibernate.model.Mechanik;
import pl.sda.hibernate.model.Pojazd;

import java.util.List;

public class KomendaListaMechanik implements Komenda {

    private DataAccessObject<Mechanik> dataAccessObject;

    public KomendaListaMechanik(){
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista mechanik";
    }

    @Override
    public void obsluga() {

        List<Mechanik> mechanicy = dataAccessObject.findAll(Mechanik.class);
        mechanicy.forEach(System.out::println);


    }
}
