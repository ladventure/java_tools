package leetcode;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @author dylan.ll
 * @date 2020/6/13 21:45
 */
public class GetStrongest {
    public int[] getStrongest(int[] arr, int k) {
        int[] res = new int[k];
        int lenth = arr.length;
        Arrays.sort(arr);
        //quickSort(arr);
        int middleIndex = (lenth - 1) / 2;
        int middle = arr[middleIndex];
        for(int i=0,j=lenth - 1,m=0;m<k;m++){
            if(Math.abs(arr[i] - middle) > Math.abs(arr[j] - middle)){
                res[m]=arr[i];
                i++;
            }else {
                res[m]=arr[j];
                j--;
            }
        }
        return res;

    }

    /**
     * 快速排序
     * @param array
     */
    public static void quickSort(int[] array) {
        int len;
        if(array == null
            || (len = array.length) == 0
            || len == 1) {
            return ;
        }
        sort(array, 0, len - 1);
    }

    /**
     * 快排核心算法，递归实现
     * @param array
     * @param left
     * @param right
     */
    public static void sort(int[] array, int left, int right) {
        if(left > right) {
            return;
        }
        int baseIndex=(int) (Math.random()*(right-left)+left);
        swap(left,baseIndex,array);
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while(i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while(array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while(array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置

            if(i < j) {
                swap( i, j,array);
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }
    static void swap(int i,int j,int a[])
    {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static void main(String[] args) {
        //IndexList[] indexList = new IndexList[5];
        //indexList[0] = new IndexList();
        //indexList[0].value = 5;
        //indexList[0].index = 0;
        //
        //indexList[1] = new IndexList();
        //indexList[1].value = 2;
        //indexList[1].index = 1;
        //
        //indexList[2] = new IndexList();
        //indexList[2].value = 1;
        //indexList[2].index = 2;
        //
        //indexList[3] = new IndexList();
        //indexList[3].value = 5;
        //indexList[3].index = 3;
        //
        //indexList[4] = new IndexList();
        //indexList[4].value = 5;
        //indexList[4].index = 4;
        //quickSortIndex(indexList);
        //for (int i = 0; i < indexList.length; i++) {
        //    System.out.println(indexList[i].value + "," + indexList[i].index);
        //}
        int[] arr={-7,22,17,3};
        int k=2;
       System.out.println(JSON.toJSONString(new GetStrongest().getStrongest(arr,k)));


    }
}
