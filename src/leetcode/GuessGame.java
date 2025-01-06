package leetcode;

public class GuessGame {
    public static void main(String[] args) {
        Guessgame gg = new Guessgame();
        gg.startgame();

    }


}
class Player{
    int number = 0; //要猜的数字
    public void guess(){
        number = (int)(Math.random()*10);
        System.out.println("我猜的是"+number);
    }

}
class Guessgame{
    //用3个实例变量分别表示3个Player对象
    Player p1;
    Player p2;
    Player p3;
    public void startgame(){
        //创建Player对象
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();
        //声明3个变量保存是否猜中
        int guessp1 = 0;
        int guessp2 = 0;
        int guessp3 = 0;
        //声明3个变量来保存猜测的数字
        boolean p1Right = false;
        boolean p2Right = false;
        boolean p3Right = false;
        //产生谜底数字
        int targetNumber = (int)(Math.random() * 10);
        System.out.println("我认为0-9之间的数字是");
        while (true){
            System.out.println("谜底数是"+targetNumber);
            //调用Player的guess方法
            p1.guess();
            p2.guess();
            p3.guess();
            //取得每个Player所猜测的数字并列出来
            guessp1 = p1.number;
            System.out.println("第一个人猜的数字是 "+guessp1);
            guessp1 = p2.number;
            System.out.println("第一个人猜的数字是 "+guessp2);
            guessp1 = p3.number;
            System.out.println("第一个人猜的数字是 "+guessp3);
            //检查是否猜中，若是猜中则去设定是否猜中的变量
            if(guessp1 == targetNumber){
                p1Right = true;
            }
            if(guessp2 == targetNumber){
                p2Right = true;
            }
            if(guessp3 == targetNumber){
                p3Right = true;
            }
            //如果有一个或多个猜中
            if(p1Right || p2Right || p3Right){
                System.out.println("游戏结束");
                break;
            }else {
                System.out.println("没猜中，继续吧");
            }
        }

    }

}
