package com.company;

import java.util.Random;

public class Main {
    public static int bossHealth = 700;
    public static int bossDamage = 50;
    public static String bossDefenceType = " ";
    public static int[] heroesHealths = {250, 250, 250};
    public static int[] heroesDamages = {20, 20, 20};
    public static String[] heroesAttacktypes = {"Physical", "Magical", "Kinetic"};

    public static void changeBossDefence() {
        Random r = new Random();
        int randomIndex = r.nextInt(heroesAttacktypes.length);
        bossDefenceType = heroesAttacktypes[randomIndex];
    }

    public static void round() {
        changeBossDefence();
//        printStatistics();
        heroesHit();
        if (bossHealth >0) {
            bossHit();
        }
        bossHit();
        printStatistics();
    }

    public static void printStatistics() {
        System.out.println("---------------------");
        System.out.println("Boss health: " + bossHealth);
//        System.out.println("Warrior health: " + heroesHealths[0]);
//        System.out.println("Magic health: " + heroesHealths[1]);
//        System.out.println("Kinetic health: " + heroesHealths[2]);
        for (int i = 0; i < heroesAttacktypes.length; i++) {
            System.out.println(heroesAttacktypes[i] + " + health:" + heroesHealths[i]);
        }
        System.out.println("-------------------");

    }


    public static void main(String[] args) {
        printStatistics();

        while (!isFinished()) {
            round();

        }


    }

    public static boolean isFinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        if (heroesHealths[0] <= 0 && heroesHealths[1] <= 0 && heroesHealths[2] <= 0) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;
    }

    public static void bossHit() {
        for (int i = 0; i < heroesHealths.length; i++) {
            heroesHealths[i] = heroesHealths[i] - bossDamage;

        }
    }

    public static void heroesHit() {

        for (int i = 0; i < heroesDamages.length; i++) {
            if (!heroesAttacktypes[i].equals(bossDefenceType)) {// heroesTypes[i] != bossDefenceType
                Random r = new Random();
                int coefficient = r.nextInt(2) + 2;
                bossHealth = bossHealth - heroesDamages[i] * coefficient;
                System.out.println(heroesAttacktypes[i] + "critical attack" + heroesDamages[i] * coefficient);
            }
            else {

            }
            bossHealth = bossHealth - heroesDamages[i];
        }
//        for (int tempDamage : heroesDamages) {
//            bossHealth = bossHealth - tempDamage;
//        }

    }

}
