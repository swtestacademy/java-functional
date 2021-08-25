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
    public void shoppingCartTest1() {
        System.out.println("Shopping Cart Test 1! Function as parameter!");
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
        System.out.println("--------------------------------------------");
    }

    @Test
    public void shoppingCartTest2() {
        System.out.println("Shopping Cart Test 2! Direct lambda function call!");
        addItem.apply("Item has been added!", true);
        addItem.apply( "Item has been added!", true);
        addItem.apply( "Item has been added!", true);
        deleteItem.apply("Item has been deleted!", true);
        deleteItem.apply("Item has been deleted!", true);
        deleteCart.apply("Cart has been deleted!", false);
        addItem.apply("Item has been added!", true);
        deleteItem.apply("Item has been deleted!", true);
        addItem.apply("Item has been added!", true);
        addItem.apply("Item has been added!", true);
        deleteCart.apply("Cart has been deleted!", false);
        System.out.println("--------------------------------------------");
    }
}
