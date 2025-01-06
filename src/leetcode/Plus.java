package leetcode;

import java.math.BigInteger;

public class Plus {
//100的相加
    public int sum(int i){
        if(i == 1){
            return 1;
        }
        return i+sum(i-1);
    }

    public static void main(String[] args) {
        Plus plus = new Plus();
        System.out.println(plus.sum(100));
        BigerSum big = new BigerSum();
        System.out.println(big.sum(100));
    }
}

//100的乘阶
class BigerSum{
    public BigInteger sum(int i){
        if(i == 1){
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(i).multiply(sum(i-1));
    }

        }
