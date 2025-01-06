package leetcode;

import java.util.Scanner;


public class GuessNumber {
    /*
     * > 需要的功能:
     * >1.随机生成一个1~1000之间的整数
     * >2.用户每猜测一次，控制台提示大了，小了，对了
     * >3.若猜对，宣布游戏结束，并询问用户是否继续开始新游戏
     * >4.用户不论猜对与否，输入0都开始新游戏
     */
    static String guessTrue = "猜对啦！";
    static String guessSmall = "猜小啦~";
    static String guessBig = "猜大了~";
    static String onemoreGame = "行嘞~这就开始";
    static String removeGame = "拜拜啦~";

    static int result=0;
    static Scanner user;
    public static void main(String[] args){
        user = new Scanner(System.in);
        Start();//开始游戏
        playGame();
        for (; ifonemoreGame();){
            Start();//开始游戏
            playGame();
        }

    }
    //开始游戏
    private static void Start(){
        System.out.println("让我们开始吧！");
        result=getrandom();
    }
    //获取随机数
    private static int getrandom(){
        int result = (int)(Math.random()*1000+1);
        return result;
    }
    private static  void playGame(){
       for(;;){
           int guess=getUserGuess();
           if(guess==result){
               System.out.println(guessTrue);
               return;
           }
           if(guess> result){
                System.out.println(guessBig);
           }else {
               System.out.println(guessSmall);
           }
       }
    }
    //判断是否再来一局，yes 或 no
    private static boolean ifonemoreGame(){
        System.out.println("next game? yes /no");
        for(;true;){

                String userGuess = user.nextLine();
                if ("yes".equals(userGuess.toLowerCase())){
                    return true;
                }
                if("no".equals(userGuess.toLowerCase())){
                    return false;
            }
                System.out.println("请输入 yes or no");
        }

    }

    /**
     * 获取一个用户输入的0-1000整数
     * @return
     */
    public static int  getUserGuess(){
        for(;true;){
            try {
                int userGuess = Integer.parseInt(user.nextLine());
                if (userGuess <=0 || userGuess >=1000){
                    System.out.println("请输入1-1000的整数哦");
                    continue;
                }
                return userGuess;
            } catch (NumberFormatException e) {
                System.out.println("plase input interger");
            }
        }
    }

}
