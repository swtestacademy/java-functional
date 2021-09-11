public class main {
    public static void main(String[] args) {
        int num1 = 22;
        int num2 = num1;
        System.out.println("num1: " + num1 + "\nnum2: " + num2);

        String str1 = "sw test academy";
        String str2 = str1;
        System.out.println("str1: " + str1 + "\nstr2: " + str2);

        System.out.println("\nAfter modifications.\n");

        num1 = 28;
        System.out.println("num1: " + num1 + "\nnum2: " + num2);

        str1 = "hello world!";
        System.out.println("str1: " + str1 + "\nstr2: " + str2);
    }
}
