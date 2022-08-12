import java.util.Arrays;

public class Main {

    /**
     * Napisz ciało metody isAdult, która dla podanej liczby lat zwróci true jeśli osoba jest pełnoletnia
     * lub false jeśli nie jest pełnoletnia
     */
    public static boolean isAdult(int age) {
        return age >= 18;
    }

    /**
     * Napisz ciało metody sumTab, która dla dowolnej tablicy int[] powinna zwrócić sumę elementów
     * znajdujących się w tablicy
     * np: dla tablicy [0, 1, 2, 3] metoda zwróci 6
     */
    public static int sumTab(int[] tab) {
        return Arrays.stream(tab).sum();
    }

    //Metoda uruchomieniowa, można sprawdzić za jej pomocą poprawność działania metod
    public static void main(String[] args) {
        System.out.println("Czy pełnoletni: " + isAdult(18));
        System.out.println("Suma wyrazów tablicy: " + sumTab(new int[]{0,1,2,3}));
    }
}

