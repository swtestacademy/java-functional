package basics.datatypes;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class ReferenceTypeExample {

    @Test
    public void referenceTypeExample() {
        int[] myArr = new int[] { 4, 5 };
        modifyAndSum(myArr);
        sum(myArr);
        System.out.println("Sum inside main: " + (myArr[0] + myArr[1])); //Sum method has changed myArr because of reference type!
    }

    private static void modifyAndSum(int[] arr){
        arr = Arrays.copyOf(arr, arr.length); //Here, we are creating a new array! The modifications won't affect original array.
        arr[0]--;
        System.out.println("Sum After modification: " + (arr[0] + arr[1]));
    }

    private static void sum(int[] arr){
        System.out.println("Sum inside sum method: " + (arr[0] + arr[1])); //Here we are adding values of original array.
        arr[0]--; //Here, we are modifying the original array because we sent as reference.
    }

}
