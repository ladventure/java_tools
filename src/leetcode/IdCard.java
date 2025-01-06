package leetcode;

import java.util.Arrays;
import java.util.List;

//（1）将前面的身份证号码17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2 ；
//（2）将这17位数字和系数相乘的结果相加；
//（3）用加出来和除以11，看余数是多少；
//（4）余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3 2；
//（5）通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的X。
//PS:（需要按照规则进行校验，严格控制实名真实性，对贷款实名数据质量十分重要）
public class IdCard {
    String num17 = "43010419910113542";
    List<String> list = Arrays.asList("7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2".split(" "));
    List<String> idnum = Arrays.asList("1 0 X 9 8 7 6 5 4 3 2".split(" "));
    public static void main(String[] args) {
        IdCard id = new IdCard();
        int d = id.Coefficient();
        String e = id.number(d);
        String num18 = id.num17 + e ;
        System.out.println(num18);

    }

    /**
     * 乘以系数后相加
     * @return
     */
    public int Coefficient(){

        int count=0;
        for(int i = 0;i<list.size();i++){
            int a = Integer.parseInt(num17.charAt(i)+"") * Integer.parseInt(list.get(i));
             count =count+a;
        }
        return count;
    }
    /**
     * 算出第十八位数
     */
        public String number(int count){
            int b = count%11;
            return idnum.get(b);

        }
}
