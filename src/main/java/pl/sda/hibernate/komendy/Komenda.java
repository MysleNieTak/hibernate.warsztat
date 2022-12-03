package pl.sda.hibernate.komendy;

import java.util.Scanner;

public interface Komenda {

    public static final Scanner scanner = new Scanner(System.in);

    String getKomenda(); // co użytkownik ma wpsiać, zebby obiekt wykonał swoją logikę
    void obsluga();
}
