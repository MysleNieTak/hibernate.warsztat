package pl.sda.hibernate.komendy;

import pl.sda.hibernate.DataAccessObject;
import pl.sda.hibernate.model.Pojazd;

public class KomendaDodajPojazd implements Komenda {
    private DataAccessObject<Pojazd> dataAccessObject;
    public KomendaDodajPojazd(){
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "dodaj pojazd";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj markę pojazdu: ");
        String marka = Komenda.scanner.nextLine();

        System.out.println("Podaj model pojazdu: ");
        String model = Komenda.scanner.nextLine();

        System.out.println("Podaj vin pojazdu: ");
        String vin = Komenda.scanner.nextLine();

        System.out.println("Podaj nr rejestrowy pojazdu: ");
        String nrRej = Komenda.scanner.nextLine();


        Pojazd pojazd = Pojazd.builder()
                .marka(marka)
                .model(model)
                .nrRej(nrRej)
                .vin(vin)
                .build();

        dataAccessObject.insert(pojazd);



    }
}
