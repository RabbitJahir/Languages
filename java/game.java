import java.util.Random;
import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        SlotGame1.start();
    }
}

class SlotGame1 {
    static double usrBalance = 50;
    static double bet = 0;
    static double payOut = 0;

    static String[] items = { "🌑", "🍀", "🧭", "🍘" };
    static String[] slotResult = new String[3];

    static void start() {
        Scanner sc = new Scanner(System.in);

        boolean isPlaying = true;
        System.out.println("Welcome to  *** JUA *** LAND ");
        System.out.println("by LulzSec6824");

        while (isPlaying) {
            System.out.println("1.CashIn \n2.Play Slots \n3.CashOut \n4.Exit");
            switch (sc.nextInt()) {
                case 1 -> depositAmount(sc);
                case 2 -> playSlots(sc);
                case 3 -> withDrawAmount(sc);
                case 4 -> isPlaying = false;
                default -> System.out.println("Invalid Option");
            }
        }

        sc.close();
    }

    static void depositAmount(Scanner sc) {
        double amount = 0;

        do {
            System.out.print("Koto CashIn? : ");
            amount = sc.nextDouble();
            if (amount < 100) {
                System.out.println("100 TK r kom CashIN nai ( GORIBS ) ");
            }
        } while (amount < 100);

        usrBalance += amount;
    }

    static void withDrawAmount(Scanner sc) {
        double amount = 0;

        do {
            System.out.print("Withdraw koto dibi? : ");
            amount = sc.nextDouble();
            if (amount < 100) {
                System.out.println("100 TK r kom CashOUT nai");
            }
        } while (amount < 100);

        usrBalance -= amount;
    }

    static void betAmount(Scanner sc) {
        double betMoney = 0;
        do {
            System.out.print("Enter betMoney of Bet : ");
            betMoney = sc.nextDouble();
            if (betMoney < 5) {
                System.out.println("5 Tk r kom e Spin Nai ");
            } else if (betMoney > usrBalance) {
                System.out.println("TK nai Bro");
            }
        } while (betMoney < 5 || betMoney > usrBalance);
        bet = betMoney;
    }

    static void slotSpinner() {

        for (int i = 0; i < slotResult.length; i++) {
            int randNumber = new Random().nextInt(0, items.length);
            slotResult[i] = items[randNumber];
        }
        displaySlotResult(slotResult);
    }

    static void displaySlotResult(String[] slotResult) {
        System.out.println("***************");
        for (int i = 0; i < slotResult.length / 3; i++) {
            System.out.printf(" %s | %s | %s ", slotResult[i], slotResult[i + 1], slotResult[i + 2]);
        }
        System.out.println("\n***************");
    }

    static void playSlots(Scanner sc) {
        if (usrBalance < 5) {
            System.out.println("TEKA NAI BRO, CashIN kor");
            return;
        }

        betAmount(sc);
        usrBalance -= bet;
        slotSpinner();
        checkWinning();

        System.out.printf("Balance: %.2f TK\n", usrBalance);
        bet = 0;
        payOut = 0;
    }

    static void checkWinning() {
        if (slotResult[0].equals(slotResult[1]) && slotResult[1].equals(slotResult[2])) {
            payOut = bet * 10;
            System.out.println("!!!  JACKPOT! 3 Match  !!!");
        } else if (slotResult[0].equals(slotResult[1]) || slotResult[1].equals(slotResult[2])
                || slotResult[0].equals(slotResult[2])) {
            payOut = bet * 2;
            System.out.println("!!  2 Match  !!");
        } else {
            System.out.println("Better luck next time!");
        }

        usrBalance += payOut;
        if (payOut > 0) {
            System.out.printf("Payout: %.2f TK\n", payOut);
        }
    }
}
