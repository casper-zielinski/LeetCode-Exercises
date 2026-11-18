public class ShoppingCart {
    public void checkout(double amount, PayMentStrategy payMentStrategy) {
        payMentStrategy.pay(amount);
    }
}
