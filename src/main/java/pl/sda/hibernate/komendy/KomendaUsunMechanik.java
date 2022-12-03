package pl.sda.hibernate.komendy;

import pl.sda.hibernate.DataAccessObject;
import pl.sda.hibernate.model.Mechanik;

public class KomendaUsunMechanik implements Komenda {

    private DataAccessObject<Mechanik> dataAccessObject;

    public KomendaUsunMechanik(){
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun mechanik";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj id usuwanego mechanika: ");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        if(dataAccessObject.delete(Mechanik.class,id)){
            System.out.println("Usunięto mechanika");
        } else {
            System.err.println("Nie udało się usunąć mechanika");
        }

    }



}
