package functional.lambda.shoppingcart;

@FunctionalInterface
public interface CartAction {
    void apply(String message, boolean isExist);
}
