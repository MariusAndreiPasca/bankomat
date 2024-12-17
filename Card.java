public class Card {
    private String clientName;
    private String cardNr;
    private int pin;
    private double balance;

    public Card(String clientName, String cardNr, int pin, double balance) {
        this.clientName = clientName;
        this.cardNr = cardNr;
        this.pin = pin;
        this.balance = balance;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        if(clientName != null && !clientName.isBlank()) {
            this.clientName = clientName;
        } else {
            System.out.println("Fehler setClientName(): name soll nicht null oder nicht definiert sein");
        }
    }

    public String getCardNr() {
        return cardNr;
    }

    public void setCardNr(String cardNr) {
        this.cardNr = cardNr;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean verifyPin(int introPin) {
        return this.pin == introPin;
    }

    public void withdraw(double amount) {
        if(amount > 10 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! Remaining balance: " + balance + " EUR");
        } else {
            System.out.println("Insufficient funds or invalid amount!");
        }
    }

    public void deposit(double amount) {
        if(amount > 10) {
            balance += amount;
            System.out.println("Deposit successful! Updated balance: " + balance + " EUR");
        } else {
            System.out.println("Invalid amount!");
        }
    }
}
