package leetcode;

public class PhoneNumber {

    public static void main(String[] args) {
        int num3 = 137;
        String s[] = new String[10];
        for (int j = 0;j<s.length;j++){
            StringBuilder str = new StringBuilder("");
            for(int i =0 ; i<8;i++){
                double num1 = Math.random() * 10;
                str.append((int)num1);
            }
            String a = num3+""+str.toString();
            s[j] = a;
            System.out.println(a);

        }


    }
}
