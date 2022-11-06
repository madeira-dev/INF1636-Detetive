package controller;
import java.util.Random;
public class Dados {
    public static int joga_dados() {
        Random result = new Random();
        int val1=1;
        val1 += result.nextInt(6);

        return val1;
    }
}
