package leetcode;

import org.junit.jupiter.api.Test;

public class FindMedianSortedArrays_4_寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int left = (nums1.length + nums2.length + 1) / 2;
        int right = (nums1.length + nums2.length + 2) / 2;

        return (double) (getKth(nums1, nums2, left, 0, nums1.length - 1, 0, nums2.length - 1) + getKth(nums1, nums2, right, 0, nums1.length - 1, 0, nums2.length - 1)) /2;
    }

    //    查找2个有序列表合并之后第k 小的数字
    private int getKth(int[] nums1, int[] nums2,int k,int s1,int e1,int s2,int e2){

//        nums1 is empty
        if(s1>e1){
            return nums2[s2+k-1];
        }
//        nums2 is empty
        if(s2>e2){
            return nums1[s1+k-1];
        }
        if(k==1){
            return Math.min(nums1[s1],nums2[s2]);
        }
        int i=s1+Math.min(e1-s1+1, k / 2) - 1,j=s2+Math.min(e2-s2+1, k / 2) - 1;
        if(nums1[i]<nums2[j]){
            return getKth(nums1,nums2,k-(i-s1+1),i+1,e1,s2,e2);
        }else {
            return getKth(nums1,nums2,k-(j-s2+1),s1,e1,j+1,e2);
        }


    }

    @Test
    public void test(){
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
