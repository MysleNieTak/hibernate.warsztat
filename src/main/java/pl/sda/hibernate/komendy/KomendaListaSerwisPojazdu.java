package pl.sda.hibernate.komendy;

import pl.sda.hibernate.DataAccessObject;
import pl.sda.hibernate.model.Pojazd;
import pl.sda.hibernate.model.SerwisPojazdu;

import java.util.List;

public class KomendaListaSerwisPojazdu implements Komenda {

    private DataAccessObject<SerwisPojazdu> dataAccessObject;

    public KomendaListaSerwisPojazdu(){
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista serwisów pojazdu";
    }

    @Override
    public void obsluga() {

        List<SerwisPojazdu> serwisPojazdu = dataAccessObject.findAll(SerwisPojazdu.class);
        serwisPojazdu.forEach(System.out::println);
    }



}
