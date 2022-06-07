package main.auxilliary_tools;

import java.util.Random;

public abstract class Dice {

    public static Random random = new Random();

    public static int d4(int multiplier) {
        return (random.nextInt(4) + 1) * multiplier;
    }

    public static int d6(int multiplier) {
        return (random.nextInt(6) + 1) * multiplier;
    }

    public static int d8(int multiplier) {
        return (random.nextInt(8) + 1) * multiplier;
    }

    public static int d10(int multiplier) {
        return (random.nextInt(10) + 1) * multiplier;
    }

    public static int d12(int multiplier) {
        return (random.nextInt(12) + 1) * multiplier;
    }

    public static int d20() {
        return random.nextInt(20) + 1;
    }


}
