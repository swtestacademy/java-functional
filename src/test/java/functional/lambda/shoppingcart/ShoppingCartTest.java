package functional.lambda.shoppingcart;

import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

    int itemCount = 0;

    CartAction addItem = (message, status) -> {
        itemCount++;
        System.out.println(message + " | Item count in the cart is: " + itemCount + " | Cart existence: " + status);
    };

    CartAction deleteItem = (message, status) -> {
        itemCount--;
        System.out.println(message + " | Item count in the cart is: " + itemCount + " | Cart existence: " + status);
    };

    CartAction deleteCart = (message, status) -> {
        itemCount = 0;
        System.out.println(message + " | Item count in the cart is: " + itemCount + " | Cart existence: " + status);
    };

    private void action(CartAction action, String message, boolean status) {
        action.apply(message, status);
    }

    @Test
    public void shoppingCartTest() {
        action(addItem, "Item has been added!", true);
        action(addItem, "Item has been added!", true);
        action(addItem, "Item has been added!", true);
        action(deleteItem, "Item has been deleted!", true);
        action(deleteItem, "Item has been deleted!", true);
        action(deleteCart, "Cart has been deleted!", false);
        action(addItem, "Item has been added!", true);
        action(deleteItem, "Item has been deleted!", true);
        action(addItem, "Item has been added!", true);
        action(addItem, "Item has been added!", true);
        action(deleteCart, "Cart has been deleted!", false);
    }
}
