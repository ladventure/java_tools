package leetcode;


import java.util.Arrays;
import java.util.List;

public class calculation {
    static String[] stack1 = new String[100000];
//    List list = new ArrayList();
    static int index1 = -1;

    static String[] stack2 = new String[100000];
    static int index2 = -1;
    String[] p = {"-","+","/","*"};

    public int getNoNum(String abc,int start){
        for(int i=start;i<abc.length();i++){
            if(abc.charAt(i) >= '0' && abc.charAt(i)<='9'){
                continue;
            }
            return i;
        }
        return abc.length();
    }
    public static void main(String[] args) {
        String num = "21*14+3*5/5-1";
        calculation ca = new calculation();
//        ca.push1("STR");
        try {
         System.out.println(ca.excute(num));

        }catch (Exception e){
            e.printStackTrace();
        }


//        System.out.println(Arrays.asList(stack));
//        System.out.println(ca.out());
    }

    public String excute(String num) throws Exception{
        for(int i=0;i<num.length();i++){
            if(num.charAt(i) >= '0' && num.charAt(i)<='9'){
                int numEnd=getNoNum(num,i);
                push1(num.substring(i,numEnd));
                i=numEnd-1;
            }
            else {
                String nextOpe=num.charAt(i)+"";
                if(index2==-1){
                    push2(nextOpe);
                    continue;
                }
                String topOperator=stack2[index2];
                String opetator= compare(topOperator,nextOpe);
                if(opetator.equals(nextOpe)){
                   push2(nextOpe);
                }else {
                    out2();
                    double b=Double.parseDouble(out1());
                    double a=Double.parseDouble(out1());
                    push1(cal(a,b,topOperator)+"");
                    i--;
                }
            }
        }

        while (index2!=-1){
            double b=Double.parseDouble(out1());
            double a=Double.parseDouble(out1());
            push1(cal(a,b,out2())+"");
        }
        return out1();
    }

    public double cal(double a,double b ,String ope) throws Exception{
        if(ope.equals("+")){
            return a+b;
        }else if(ope.equals("-")){
            return a-b;
        }
        else if(ope.equals("*")){
            return a*b;
        }
        else if(ope.equals("/")){
            return a/b;
        }else {
            throw new Exception("非法操作符");
        }

    }
    public void push1(String abc){
        index1++;
        stack1[index1] = abc;

    }
    public String out1(){
        String you = stack1[index1];
        index1--;
        return you;
    }


    public void push2(String abc){
        index2++;
        stack2[index2] = abc;


    }
    public String out2(){
        String you = stack2[index2];
        index2--;
        return you;
    }
    public String compare(String p1,String p2){
       List pList= Arrays.asList(p);
        if(pList.indexOf(p1)>pList.indexOf(p2)){
            return p1;
        }
        return p2;

    }

}
