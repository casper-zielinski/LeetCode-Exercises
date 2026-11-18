public class CreditCardPayment implements PayMentStrategy{
    @Override
    public void pay(double amount) {
        System.out.printf("%s € via Kredit Karte bezahlt \n", amount);
    }
}
