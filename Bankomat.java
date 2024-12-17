import java.util.Scanner;

public class Bankomat {

        public static void main(String[] args) {
            // Create a card
            Card card = new Card("John Smith", "1234 5678 9101 1121", 1234, 1500.0);

            // Create an ATM and insert the card
            Bankomat bank = new Bankomat();
            bank.insertCard(card);
        }


    private Card currentCard;
    private Scanner scanner;

    public Bankomat() {
        this.scanner = new Scanner(System.in);
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void insertCard(Card card) {
        System.out.println("Welcome, " + card.getClientName() + "!");
        currentCard = card;
        authenticate();
    }

    public void authenticate() {
        int attempts = 3;
        while (attempts > 0) {
            System.out.println("Enter your PIN: ");
            int enteredPin = scanner.nextInt();
            if (currentCard.verifyPin(enteredPin)) {
                System.out.println("PIN is correct! Access granted.");
                displayMenu();
            } else {
                attempts--;
                System.out.println("Incorrect PIN. Remaining attempts: " + attempts);
            }
        }
        System.out.println("Too many failed attempts. Card blocked!");
        currentCard = null;
    }

    private void displayMenu() {
        while(true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Exit");
            System.out.print("Option: ");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Current balance: " + currentCard.getBalance() + " RON");
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    currentCard.withdraw(withdrawalAmount);
                    break;
                case 3:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    currentCard.deposit(depositAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using our services!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
