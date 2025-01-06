package leetcode;

/**
 * @author dylan.ll
 * @date 2021/11/6 17:39
 */
public class AreNumbersAscending {
    public static void main(String[] args) {
        System.out.println(new AreNumbersAscending().areNumbersAscending("hello world 5 x 5"));
    }
    public boolean areNumbersAscending(String s) {
        String[] splitStr=s.split(" ");
        int step=0;
        for(String str:splitStr){

            try {
               int strNum= Integer.parseInt(str);
               if(strNum<=step){
                   return false;
               }else {
                   step=strNum;
               }
            } catch (NumberFormatException e) {
                //e.printStackTrace();
            }
        }
        return true;
    }
}
