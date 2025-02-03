package org.example;

import java.util.Random;

public class RandomGenerators {

    public static String generateRandomEmail() {
        Random random = new Random();
        return "kristnitesting" + random.nextInt(90000) + "@kristini.bg";
    }

}
