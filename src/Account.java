public class Account {

    protected float balance;
    protected int numberConsignments = 0;
    protected int numberWithdrawals = 0;
    protected float annualRate;
    protected float monthlyCommission = 0;

    public int getNumberConsignments() {
        return numberConsignments;
    }

    public void setNumberConsignments(int numberConsignments) {
        this.numberConsignments = numberConsignments;
    }

    public Account(float balance, float annualRate, int numberConsignments, float numberWithdrawals, float monthlyCommission) {
        this.balance = balance;
        this.annualRate = annualRate;
        this.numberConsignments = 0;
        this.numberWithdrawals = 0;
        this.monthlyCommission = 0;
    }

    public void consign(float amount){
        balance += amount;
        numberConsignments++;
    }

    public void withdraw(float amount){
        float newBalance = balance - amount;
        if(newBalance >= 0){
            balance -= amount;
            numberWithdrawals++;
        }else{
            System.out.println("La cantidad a retirar excede el saldo actual.");
        }
    }

    public void calculateInterest(){
        float monthlyRate = annualRate / 12;
        float monthlyInterest = balance * monthlyRate;
        balance += monthlyInterest;
    }

    public void monthlyStatement(){
        balance -= monthlyCommission;
        calculateInterest();
    }

    public Account(){

    }

}