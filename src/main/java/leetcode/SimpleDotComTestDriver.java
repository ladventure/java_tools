package leetcode;

import java.util.Random;
import java.util.Scanner;

public class SimpleDotComTestDriver {


    public static void main(String[] args) {
        SimpleDotCom dot = new SimpleDotCom();
        //初始化战舰
        int[][] loctions = new int[7][7];
        for (int i = 0 ;i<loctions.length;i++){
            for(int j=0;j<loctions.length;j++){
           loctions[i][j]=0;
            }
        }

        getShip(loctions);

        Scanner sc = new Scanner(System.in);
        dot.SetlocationCells(loctions);
        while (true) {

            String userguess = sc.nextLine();
            String result = dot.checkYourself(userguess);
            if (result.equals("kill")) {
                break;
            }
        }


    }
//    检查x，y点是否可以为战舰
    private static boolean check(int[][] loctions,int x,int y){
        if( x>0 && x<7 && y>0 && y<7 && loctions[x][y]==0){
            return true;
        }
        return false;
    }
    //确定三个长方形
    private static boolean tryGetOneShip(int[][] loctions) {
        Random r = new Random();
        int head_x = r.nextInt(7);
        int head_y = r.nextInt(7);
        int dir = r.nextInt(4);
//        if (!tryGetOneShip(loctions, head_x, head_y)) {
//            return false;
//        }
        //0-上   1-下   2-左   3-右
        if (dir == 0) {
            if(check(loctions,head_x,head_y) && check(loctions,head_x,head_y-1) && check(loctions,head_x,head_y-2)){
                loctions[head_x][head_y]=1;
                loctions[head_x][head_y-1]=1;
                loctions[head_x][head_y-2]=1;
                return true;
            }
        } else if (dir == 1) {
            if(check(loctions,head_x,head_y) && check(loctions,head_x+1,head_y) && check(loctions,head_x+2,head_y)){
                loctions[head_x][head_y]=1;
                loctions[head_x+1][head_y]=1;
                loctions[head_x+2][head_y]=1;
                return true;
            }
        } else if (dir == 2) {
            if(check(loctions,head_x,head_y) && check(loctions,head_x,head_y+1) && check(loctions,head_x,head_y+2)){
                loctions[head_x][head_y]=1;
                loctions[head_x][head_y+1]=1;
                loctions[head_x][head_y+2]=1;
                return true;
            }
        } else {
            if(check(loctions,head_x,head_y) && check(loctions,head_x-1,head_y) && check(loctions,head_x-2,head_y)){
                loctions[head_x][head_y]=1;
                loctions[head_x-1][head_y]=1;
                loctions[head_x-2][head_y]=1;
                return true;
            }
        }

        return false;
    }

    private static void getShip(int[][] loctions) {

        for (int i = 0; i < 3; ) {
            if(tryGetOneShip(loctions)){
                i++;
            }
        }
    }
}

class SimpleDotCom{
    int[][] locationCells;
    int numOfHits = 0;
    public void SetlocationCells(int[][] locs){
        locationCells = locs;
    }
    public String checkYourself(String stringGuess){
        String[] spilt=stringGuess.split(",");
        int guess_x = Integer.parseInt(spilt[0]);
        int guess_y = Integer.parseInt(spilt[1]);
        String result = "miss";

        if(locationCells[guess_x][guess_y]==1){
            locationCells[guess_x][guess_y]=0;
            result = "hint";
            numOfHits++;
        }

        if(numOfHits == 9){
            result = "kill";
        }
        System.out.println(result);
        return result;
    }

}
