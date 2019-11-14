package sample;

import java.util.Random;

public class CardReader {

    static boolean processPayment (){

        Random random = new Random();
        int randomNumber=random.nextInt(5)+1;
        if (randomNumber==5) {
            return false;
        }else {
            return true;
        }
    }
}

