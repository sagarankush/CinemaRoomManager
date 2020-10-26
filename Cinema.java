import java.util.Scanner;

public class Cinema {
    static int row;
    static int seat;
    static char[][] hall;
    static double totalTickets = 0;
    static double ticketsPurchased = 0;
    static double percentage = 0;
    static int currentIncome = 0;
    static int totalIncome = 0;
    public static void main(String[] args) {
        Cinema cin = new Cinema();
        cin.questionnaire();
    }

    void questionnaire() {
        Scanner scanner = new Scanner(System.in);

        makeHall();

        int q;
        do {
            System.out.println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
            q = scanner.nextInt();
            switch (q) {
                case 1: 
                    printHall();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    printStats();
                case 0:
                    break;
            }
        } while (q != 0);
    }

    void printStats() {
        int tp = (int) ticketsPurchased;
        System.out.println("\nNumber of purchased tickets: " + tp);
        if (totalTickets != 0) {
            percentage = (ticketsPurchased * 100) / totalTickets;
        }
        System.out.printf("Percentage: %.2f%% \n", percentage);
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }

    void makeHall() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        row = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seat = scanner.nextInt();
        totalTickets = row * seat;
        if (totalTickets > 60) {
            totalIncome = (row / 2) * seat * 10 + (row - (row / 2)) * seat * 8;
        } else {
            totalIncome = (int) totalTickets * 10;
        }
        hall = new char[row + 1][seat + 1];
        hall[0][0] = ' ';
        for (int i = 1; i <= seat; i++) {
            hall[0][i] = Integer.toString(i).charAt(0);
        }
        for (int i = 1; i <= row; i++) {
            hall[i][0] = Integer.toString(i).charAt(0);
            for (int j = 1; j <= seat; j++) {
                hall[i][j] = 'S';
            }
        }
    }

    void printHall() {
        System.out.println("\nCinema:");
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= seat; j++) {
                System.out.print(hall[i][j] + " ");
            }
            System.out.println();
        }
    }

    void buyTicket() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\nEnter a row number:");
            int noOfRow = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int noOfSeat = scanner.nextInt();
            if (noOfRow > 9 || noOfSeat > 9) {
                System.out.println("Wrong input!");
                continue;
            }
            if (hall[noOfRow][noOfSeat] == 'B') {
                System.out.println("\nThat ticket has already been purchased!");
                continue;
            }
            if (((row * seat) > 60) && (noOfRow > (row/2))) {
                System.out.println("Ticket price: $8");
                currentIncome += 8;
                ticketsPurchased += 1;
            } else {
                System.out.println("Ticket price: $10");
                currentIncome += 10;
                ticketsPurchased += 1;
            }
            hall[noOfRow][noOfSeat] = 'B';
            break;
        }
    }
}