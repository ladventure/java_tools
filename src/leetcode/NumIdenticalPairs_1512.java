package leetcode;

/**
 * @author dylan.ll
 * @date 2020/10/30 20:48
 */
public class NumIdenticalPairs_1512 {
    public int numIdenticalPairs(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,1,1,3};
        System.out.println(new NumIdenticalPairs_1512().numIdenticalPairs(nums));
    }
}
