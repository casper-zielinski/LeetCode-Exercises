public class StripePayment implements PayMentStrategy {

    @Override
    public void pay(double amount) {
        System.out.printf("%s € über Stripe bezahlt \n", amount);
    }
}
