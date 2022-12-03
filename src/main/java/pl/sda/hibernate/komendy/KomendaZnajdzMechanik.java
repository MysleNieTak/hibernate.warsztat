package pl.sda.hibernate.komendy;

import org.hibernate.Session;
import pl.sda.hibernate.HibernateUtil;
import pl.sda.hibernate.model.DataAccessObject;
import pl.sda.hibernate.model.Mechanik;
import pl.sda.hibernate.model.Pojazd;

import java.util.Optional;

public class KomendaZnajdzMechanik implements Komenda {

    private DataAccessObject<Mechanik> dataAccessObject;

    public KomendaZnajdzMechanik(){
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "znajdz mechanik";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj id szukanego mechanika");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

  Optional<Mechanik> mechanikOptional= dataAccessObject.find(Mechanik.class,id);

  if(mechanikOptional.isPresent()){ // Optional = sprawdzenie ifem!!!
      System.out.println(mechanikOptional.get());
  } else {
      System.out.println("Nie znaleziono mechanika!");
  }

    }
}
