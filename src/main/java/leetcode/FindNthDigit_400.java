package leetcode;

/**
 * @author dylan.ll
 * @date 2020/10/30 16:42
 */
public class FindNthDigit_400 {

        public int findNthDigit(int n) {

            int i=1;

            while(true){

                long tmp= (long)(Math.pow(10,i)-Math.pow(10,i-1))*i;
                if(n>tmp){
                    n=n-(int)tmp;
                }else {
                    break;
                }
                i++;
            }
            long gloal=(long)Math.pow(10,(i-1))+(long)Math.ceil( (double)n/i)-1;

            int remain=(n%i==0 ? i-1:n%i-1);
            return Long.toString(gloal).charAt(remain) - '0';

        }

    public static void main(String[] args) {
        System.out.println(new FindNthDigit_400().findNthDigit(1000000000));
        //for (int i = 0; i <=400 ; i++) {
        //    System.out.print(i);
        //}
    }
}
