package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author dylan.ll
 * @date 2020/10/28 16:24
 */
public class UniqueOccurrences_1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> numCount=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(numCount.containsKey(arr[i])){
                numCount.put(arr[i],numCount.get(arr[i])+1);
            }else{
                numCount.put(arr[i],1);
            }
        }

        Set<Integer> countC = new HashSet<>(numCount.values());
        return numCount.size()==(countC.size());
    }
}
