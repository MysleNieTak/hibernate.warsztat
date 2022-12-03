package pl.sda.hibernate.komendy;

import pl.sda.hibernate.DataAccessObject;
import pl.sda.hibernate.model.Mechanik;
import pl.sda.hibernate.model.SerwisPojazdu;

public class KomendaUsunSerwisPojazdu implements Komenda {

    private DataAccessObject<SerwisPojazdu> dataAccessObject;

    public KomendaUsunSerwisPojazdu(){
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun serwis pojazdu";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj id usuwanego serwisu pojazdu: ");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        if(dataAccessObject.delete(SerwisPojazdu.class,id)){
            System.out.println("Usunięto serwis pojazdu");
        } else {
            System.err.println("Nie udało się usunąć serwisu pojazdu");
        }

    }



}
