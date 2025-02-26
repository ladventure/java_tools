package leetcode;

/**
 * @author dylan.ll
 * @date 2020/10/30 11:24
 */
public class CountDigitOne_43 {
    public int countDigitOne(int n) {
        return countRu(n);
    }

    public int countRu(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }
        //获取最高位的10的次方
        int tenCou = getTenCouple(n);
        //获取最高位的数字
        int high = n / tenCou;
        //获取除去最高位的数字
        int remain = n % tenCou;
        //如果最高位=1
        if (high == 1) {
            //countRu(tenCou-1)+1 ： 比如1234，表示0-999 然后加上最高位1000中的1，
            // countRu(remain)：1000-1234 中后面的234 的数
            //remain ：表示1000-1234 中数字所有的最高位的1
            return countRu(tenCou-1)+1 + countRu(remain)+remain;
        } else {
            //最高位不为1，则有high 个 tenCou-1数，比如2345，则有2个999的数，分别是0-999 和1000-1999中 不算1 的部分；
            // tenCou个表示1000-19999 中1最高位1 的个数，
            //countRu(remain) 表示2000-2345 中1的个数
            return high*countRu(tenCou-1)+tenCou+countRu(remain);
        }

    }

    public int getTenCouple(int n) {
        String string = String.valueOf(n);

        return (int) Math.pow(10, string.length()-1);
    }


    public static void main(String[] args) {
        //long start=System.currentTimeMillis();
        System.out.println(new CountDigitOne_43().countDigitOne(1410065408));
        //System.out.println(System.currentTimeMillis()-start);

    }
}
