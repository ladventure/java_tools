package leetcode;

public class Dog {
    String name;

    public static void main(String[] args) {
        //创建Dog的对象
        Dog dog1 = new Dog();
        dog1.bark();
        dog1.name = "frid";
        //创建Dog的数组
        Dog[] dog = new Dog[3];
        //关门放狗
        dog[0] = new Dog();
        dog[1] = new Dog();
        dog[2] = dog1;
        //通过数组引用存取Dog
        dog[0].name = "nacy";
        dog[1].name = "mark";
        //dog[2]的名字是？
        System.out.println(dog[2].name);
        //逐个对Dog执行bark()
        int x = 0;
        while (x<dog.length){
            dog[x].bark();
            x=x+1;
        }



    }
    public void bark() {
        System.out.println(name +  " says Ruff!");
    }
    public void eat() {  }
    public void chaseCat() {  }
}


