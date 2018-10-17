package project;

public class Primes {

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {  //тоже самое что и i = i +1 или i += 1
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeWhile(int n) { //эквивалентна for, но для счетчиков чаще используют for, а не while
        int i = 2;
        while (i < n && n % i != 0) {
            i++;
        }
        return i == n;
    }

}
