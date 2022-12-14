package pl.sda.hibernate;

import pl.sda.hibernate.komendy.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Komenda> listaKomend = new ArrayList<>(
                List.of( // list.of zwraca wynik, któy jest listą, nie możemy dodawać i usuwać, dlatego tworzymy nowąArrayList
                        new KomendaDodajPojazd(),
                        new KomendaDodajMechanik(),
                        new KomendaListaMechanik(),
                        new KomendaListaPojazd(),
                        new KomendaZnajdzPojazd(),
                        new KomendaZnajdzMechanik(),
                        new KomendaUsunPojazd(),
                        new KomendaUsunMechanik(),
                        new KomendaZnajdzSerwisPojazdu(),
                        new KomendaDodajSerwisPojazdu(),
                        new KomendaListaSerwisPojazdu(),
                        new KomendaUsunSerwisPojazdu()

                )
        );
        System.out.println("Lista dostępnych komend: ");
        listaKomend.forEach(komenda -> System.out.println(komenda.getKomenda())); //wypisanie wszystkich komend

        System.out.println("podaj komendę:");
        String komenda = Komenda.scanner.nextLine();

        for (Komenda dostepnaKomenda : listaKomend) {

            if (dostepnaKomenda.getKomenda().equalsIgnoreCase(komenda)) {
                dostepnaKomenda.obsluga();
            }
        }
    }
}