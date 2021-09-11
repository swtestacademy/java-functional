package basics.datatypes;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class ReferenceTypeExample {
    @Test
    public void referenceTypeExample() {
        int[] myArr = new int[] { 4, 5 };
        System.out.println("Before modifyAndSum method:" + (myArr[0] + myArr[1])); //The sum of the numbers in the array before everything.
        modifyAndSum(myArr);
        System.out.println("After modifyAndSum method:" + (myArr[0] + myArr[1])); //modifyAndSum method did not change original array.
        sum(myArr);
        System.out.println("After sum method: " + (myArr[0] + myArr[1])); //Sum method changed myArr because of reference type!
    }

    private static void modifyAndSum(int[] arr) {
        arr = Arrays.copyOf(arr, arr.length); //Here, we are creating a new array! The modifications won't affect original array.
        arr[0]--;
        System.out.println("Inside modifyAndSum method: " + (arr[0] + arr[1]));
    }

    private static void sum(int[] arr) {
        System.out.println("Inside sum method: " + (arr[0] + arr[1])); //Here we are adding values of original array.
        arr[0]--; //Here, we are modifying the original array because we sent as reference.
    }

    @Test
    public void referencePrimitiveTypesTest() {
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
