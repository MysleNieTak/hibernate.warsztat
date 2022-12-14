package pl.sda.hibernate.komendy;

import pl.sda.hibernate.DataAccessObject;
import pl.sda.hibernate.model.Pojazd;

public class KomendaUsunPojazd implements Komenda {

    private DataAccessObject<Pojazd> dataAccessObject;

    public KomendaUsunPojazd(){
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun pojazd";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj id usuwanego pojazdu: ");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);


        if(dataAccessObject.delete(Pojazd.class,id)){
            System.out.println("Usunięto pojazd");
        } else {
            System.err.println("Nie udało się usunąć pojazdu");
        }
    }
}
