import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class Zadanie2 {

    /**
     * Liczba doskonała to liczba, której suma dzielników bez niej samej równy jest tej liczbie
     * 6 jest liczbą doskonałą, bo jej dzielniki to: 1,2,3,6 a 1+2+3 = 6
     * 28 jest liczbą doskonałą, bo jej dzielniki to: 1,2,4,7,28 a 1+2+4+7 = 28
     * <p>
     * Zadanie: napisz ciało metody findNPerfectNumbers, która znajdzie n pierwszych liczb doskonałych i zwróci je w postaci listy
     */

//            6
//            28
//            496
//            8128
//            33550336
//            8589869056
//            137438691328
//            2305843008139952128
//            2658455991569831744654692615953842176
//            191561942608236107294793378084303638130997321548169216
//            13164036458569648337239753460458722910223472318386943117783728128
//            14474011154664524427946373126085988481573677491474835889066354349131199152128
    public static ArrayList<BigInteger> findNPerfectNumbers(int n) {
        ArrayList<BigInteger> perfects = new ArrayList<BigInteger>();
        perfects.add(new BigInteger("6"));
        int x = n - 1;
        int count = 1;
        int p = 1;
        while (count < x + 1) {
            if (isMersennePrime(p)) {
                count++;
                BigInteger mersenne = new BigInteger("2").pow(p).subtract(BigInteger.ONE);
                BigInteger factor = new BigInteger("2").pow(p - 1);
                BigInteger perfect = mersenne.multiply(factor);
                perfects.add(perfect);
            }
            p++;
        }
        return perfects;
    }

    static boolean isMersennePrime(int p) {
        BigDecimal seriesSum = new BigDecimal(4);
        BigDecimal TWO = new BigDecimal(2);
        BigDecimal ZERO = new BigDecimal(0);
        BigDecimal mersenne = TWO.pow(p).subtract(new BigDecimal(1));
        for (int i = 1; i <= p - 2; i++) {
            seriesSum = seriesSum.multiply(seriesSum).subtract(TWO);
            seriesSum = seriesSum.remainder(mersenne);
        }
        if (seriesSum.compareTo(ZERO) == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findNPerfectNumbers(8));
    }
}