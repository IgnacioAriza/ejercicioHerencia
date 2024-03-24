import static java.lang.Math.abs;

public class CurrentAccount extends Account{
    private float overdraft = 0;

    public CurrentAccount(float overdraft, float balance, int numberConsignments, float numberWithdrawals,float annualRate, float monthlyCommission){
        super(balance, numberWithdrawals, numberConsignments, annualRate, monthlyCommission);
        this.overdraft = 0;
    }

    @Override
    public void withdraw(float amount){
        numberWithdrawals++;
        float newBalance = balance - amount;
        if(newBalance >= 0){
            balance -= amount;
            numberWithdrawals++;
        }else{
            overdraft = overdraft + abs(newBalance);
            balance = 0;
        }
    }

    @Override
    public void consign(float amount){
        numberConsignments++;
        if (overdraft > 0){
            overdraft = overdraft - amount;
            if (overdraft < 0){
                balance = balance + abs(overdraft);
                overdraft = 0;
            }
        }else {
            balance = balance + amount;
        }
    }

    public void monthlyStatement(){}

    public void mostrar(){
        System.out.println("Su saldo actual es: " + balance);
        System.out.println("Su comision mensual es: " + monthlyCommission);
        System.out.println("Se han hecho " + (numberWithdrawals + numberConsignments) + " transacciones." );
        System.out.println("Su sobregiro es de: " + overdraft);
    }
}
