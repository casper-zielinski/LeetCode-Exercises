public class PayPalPayment implements PayMentStrategy {
    @Override
    public void pay(double amount) {
        System.out.printf("%s € via PayPal bezahlt \n", amount);
    }
}
