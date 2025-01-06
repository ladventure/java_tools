package leetcode;

/**
 * @author dylan.ll
 * @date 2020/10/28 17:30
 */
public class RemoveDuplicates_1209 {
    public String removeDuplicates(String s, int k) {
        if(s.length()==0){
            return s;
        }
        if(k==1){
            return "";
        }
        StringBuilder builder=new StringBuilder(s);

        for(int i=1,thisNUm=1;i<builder.length();i++){

            if(i==0){
                thisNUm=1;
                continue;
            }
            if(builder.charAt(i)==builder.charAt(i-1)){
                thisNUm++;
            }else{
                thisNUm=1;
            }

            if(thisNUm==k){
                builder.delete(i-k+1,i+1);
                i=i-k;
                thisNUm=1;

                //计算之前的num
                for (int j = i-1; j >=0 ; j--) {
                    if(builder.charAt(j)==builder.charAt(j+1)){
                        thisNUm++;
                    }else {
                        break;
                    }
                }

            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates_1209().removeDuplicates("nnwssswwnvbnnnbbqhhbbbhmmmlllm",3));
    }
}
