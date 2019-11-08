package sample;

import java.util.Random;

<<<<<<< Updated upstream

public class CardReader {

=======
public class CardReader {

    // Written by Johanna
>>>>>>> Stashed changes
    static boolean processPayment (){

        Random random = new Random();
        int randomNumber=random.nextInt(5)+1;
        if (randomNumber==5) {
            return false;
        }else {
            return true;
        }
    }
<<<<<<< Updated upstream
}
=======
}
>>>>>>> Stashed changes
