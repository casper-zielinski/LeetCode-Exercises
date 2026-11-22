public class PaymentFactory {

    public static PayMentStrategy create(PaymentType paymentType) {
        return switch (paymentType) {
            case PAYPAL -> new PayPalPayment();
            case STRIPE -> new StripePayment();
            case CREDIT_CARD -> new CreditCardPayment();
        };
    }
}
