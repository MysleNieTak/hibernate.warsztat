package pl.sda.hibernate.komendy;

import org.hibernate.Session;
import pl.sda.hibernate.HibernateUtil;
import pl.sda.hibernate.model.DataAccessObject;
import pl.sda.hibernate.model.Mechanik;
import pl.sda.hibernate.model.Pojazd;

import java.net.ServerSocket;
import java.util.List;
import java.util.Optional;

public class KomendaZnajdzPojazd implements Komenda {

    private DataAccessObject<Pojazd> dataAccessObject;

    public KomendaZnajdzPojazd(){
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "znajdz pojazd";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj id szukanego pojazdu");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        Optional<Pojazd> pojazdOptional= dataAccessObject.find(Pojazd.class,id);

        if(pojazdOptional.isPresent()){ // Optional = sprawdzenie ifem!!!
            System.out.println(pojazdOptional.get());
        } else {
            System.out.println("Nie znaleziono pojazdu!");
        }

    }



}
