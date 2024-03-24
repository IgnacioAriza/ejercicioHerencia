//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SavingsAccount s1 = new SavingsAccount(13000,7,0,0,true,0);

        s1.consign(6500);
        s1.withdraw(3100);
        s1.monthlyStatement();
        s1.mostrar();
    }
}