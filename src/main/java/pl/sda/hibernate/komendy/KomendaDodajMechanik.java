package pl.sda.hibernate.komendy;

import pl.sda.hibernate.DataAccessObject;
import pl.sda.hibernate.model.Mechanik;

public class KomendaDodajMechanik implements Komenda {

    private DataAccessObject <Mechanik>dataAccessObject;
    public KomendaDodajMechanik(){
        this.dataAccessObject = new DataAccessObject<>();
    }
    @Override
    public String getKomenda() {
        return "dodaj mechanik";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj imię mechanika: ");
        String imie = Komenda.scanner.nextLine();

        System.out.println("Podaj kwalifikację mechanika: ");
        String kwalifikacja = Komenda.scanner.nextLine();

        System.out.println("Podaj specjalizację mechanika: ");
        String specjalizacja = Komenda.scanner.nextLine();


        Mechanik mechanik = Mechanik.builder()
                .imie(imie)
                .kwalifikacja(kwalifikacja)
                .specjalizacja(specjalizacja)
                .build();

    dataAccessObject.insert(mechanik);


    }
}
