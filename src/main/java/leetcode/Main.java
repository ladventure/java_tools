package leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

    }
    private static List<Integer[]> getSubList(List<Integer> list,Integer n){
        if(list==null){
            return null;
        }
        List<Integer[]> result=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i < list.size() ; i++) {
            map.put(list.get(i),map.getOrDefault(list.get(i),0)+1);
        }
        for (int i = 0; i < list.size() ; i++) {
            Integer plus=n-list.get(i);
            if(map.containsKey(plus)){
                for (int j = 0; j < map.get(plus); j++) {
                    result.add(new Integer[]{plus,list.get(i)});
                }
            }
        }
        return result;
    }

}
