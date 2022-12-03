package pl.sda.hibernate.komendy;

import pl.sda.hibernate.DataAccessObject;
import pl.sda.hibernate.model.Mechanik;

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
