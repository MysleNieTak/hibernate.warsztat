package pl.sda.hibernate.komendy;

import pl.sda.hibernate.DataAccessObject;
import pl.sda.hibernate.model.Mechanik;
import pl.sda.hibernate.model.SerwisPojazdu;

import java.util.Optional;

public class KomendaZnajdzSerwisPojazdu implements Komenda {

    private DataAccessObject<SerwisPojazdu> dataAccessObject;

    public KomendaZnajdzSerwisPojazdu(){
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "znajdz serwis pojazdu";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj id szukanego serwisu");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

  Optional<SerwisPojazdu> serwisPojazduOptional= dataAccessObject.find(SerwisPojazdu.class,id);

  if(serwisPojazduOptional.isPresent()){ // Optional = sprawdzenie ifem!!!
      System.out.println(serwisPojazduOptional.get());
  } else {
      System.out.println("Nie znaleziono serwisu!");
  }

    }
}
