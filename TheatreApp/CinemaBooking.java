import java.util.Scanner;

public class CinemaBooking {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean[] seats = new boolean[30]; // Array to track seat availability
        int choice;

        System.out.println("Welcome to Crazy Cinema!");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. View Seating Chart");
            System.out.println("2. Book a Seat");
            System.out.println("3. Cancel a Seat");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    displaySeatingChart(seats);
                    break;
                case 2:
                    bookSeat(seats, input);
                    break;
                case 3:
                    cancelSeat(seats, input);
                    break;
                case 4:
                    System.out.println("Thank you for using the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void displaySeatingChart(boolean[] seats) {
        System.out.println("\nCurrent Seating Chart:");
        for (int i = 0; i < seats.length; i++) {
            if (i % 5 == 0 && i != 0) System.out.println();
            System.out.print((seats[i] ? "[X]" : "[ ]") + " ");
        }
        System.out.println("\nNote: [X] = Booked, [ ] = Available");
    }

    private static void bookSeat(boolean[] seats, Scanner input) {
        System.out.print("\nEnter the seat number you want to book (0-29): ");
        int seatNumber = input.nextInt();

        if (seatNumber < 0 || seatNumber >= seats.length) {
            System.out.println("Invalid seat number. Please select a seat between 0 and 29.");
            return;
        }

        if (seats[seatNumber]) {
            System.out.println("Seat " + seatNumber + " is already booked. Suggesting an available seat...");
            suggestAvailableSeat(seats);
        } else {
            seats[seatNumber] = true;
            System.out.println("Seat " + seatNumber + " booked successfully!");
        }
    }

    private static void suggestAvailableSeat(boolean[] seats) {
        for (int i = 0; i < seats.length; i++) {
            if (!seats[i]) {
                System.out.println("Suggested Seat: " + i);
                return;
            }
        }
        System.out.println("No seats available.");
    }

    private static void cancelSeat(boolean[] seats, Scanner input) {
        System.out.print("\nEnter the seat number you want to cancel (0-29): ");
        int seatNumber = input.nextInt();

        if (seatNumber < 0 || seatNumber >= seats.length) {
            System.out.println("Invalid seat number. Please select a seat between 0 and 29.");
            return;
        }

        if (!seats[seatNumber]) {
            System.out.println("Seat " + seatNumber + " is not booked yet.");
        } else {
            seats[seatNumber] = false;
            System.out.println("Seat " + seatNumber + " has been successfully canceled.");
        }
    }
}