public class SavingsAccount extends Account{

    private boolean isActive;

    public SavingsAccount(float balance, float annualRate, int numberConsignments, float numberWithdrawals, boolean isActive, float monthlyCommission){
        super(balance,annualRate,numberConsignments,numberWithdrawals,monthlyCommission);
        this.isActive = this.balance > 9999;
    }

    @Override
    public void consign(float amount){
        if (this.isActive){
            this.balance += amount;
            numberConsignments++;
        }else{
            System.out.println("La cuenta esta inactiva, no se puede consignar");
        }
    }

    @Override
    public void withdraw(float amount){
        if (this.isActive){
            float newBalance = balance - amount;
            if(newBalance >= 0){
                balance -= amount;
                numberWithdrawals++;
            }else{
                System.out.println("La cantidad a retirar excede el saldo actual.");
            }
        }else{
            System.out.println("La cuenta esta inactiva, no se puede retirar.");
        }

    }

    @Override
    public void monthlyStatement(){
        if (numberWithdrawals > 4){
            monthlyCommission += 1000;
        }
        balance -= monthlyCommission;
        this.isActive = this.balance > 9999;
    }

    public void mostrar(){
        System.out.println("Su saldo actual es: " + balance);
        System.out.println("Su comision mensual es: " + monthlyCommission);
        System.out.println("Se han hecho " + (numberWithdrawals + numberConsignments) + " transacciones." );
    }

}
