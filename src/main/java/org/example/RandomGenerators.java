package org.example;

import java.util.Random;

public class RandomGenerators {

    public static String generateRandomEmail() {
        Random random = new Random();
        int randomNumber = 10000 + random.nextInt(90000);
        return "kristnitesting" + randomNumber + "@kristini.bg";
    }

}
