package leetcode;

/**
 * @author dylan.ll
 * @date 2020/10/28 16:52
 */
public class EqualSubstring_1208 {
    public int equalSubstring(String s, String t, int maxCost) {

        int n=s.length();
        int[] dis=new int[n];

        //cal dis
        for(int i=0;i<n;i++){
            dis[i]=Math.abs(s.charAt(i)-t.charAt(i));
        }


        int lastLen=0;
        // init
        if(dis[0]<=maxCost){
            lastLen=1;
        }

        for(int i=1;i<n;i++){

            int lenN=0;
            int costN=0;
            for(int j=i;j>=0;j--){
                if(costN+dis[j]>maxCost){
                    break;
                }
                costN+=dis[j];
                lenN++;
            }
            if(lenN>lastLen){
                lastLen=lenN;
            }
        }

        return lastLen;
    }

    public static void main(String[] args) {
        new EqualSubstring_1208().equalSubstring("abcd","acde",0);
    }
}
