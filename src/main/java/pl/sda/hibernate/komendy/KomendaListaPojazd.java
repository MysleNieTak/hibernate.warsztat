package pl.sda.hibernate.komendy;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import pl.sda.hibernate.HibernateUtil;
import pl.sda.hibernate.model.DataAccessObject;
import pl.sda.hibernate.model.Pojazd;

import java.util.List;

public class KomendaListaPojazd implements Komenda {

    private DataAccessObject<Pojazd> dataAccessObject;

    public KomendaListaPojazd(){
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista pojazd";
    }

    @Override
    public void obsluga() {

        List<Pojazd> pojazdy = dataAccessObject.findAll(Pojazd.class);
        pojazdy.forEach(System.out::println);
    }



}
