import java.util.List;

public class Test {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.checkout(122, new PayPalPayment());

        cart.checkout(2, new StripePayment());

        cart.checkout(45.66, new CreditCardPayment());
    }
}
