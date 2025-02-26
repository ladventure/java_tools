package utils;

import org.junit.jupiter.api.Test;


public class UtilsTest {

    @Test
    public void testQuickSort() {
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        QuickSort.quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
    }
}
