package com.simple.javathreaddemo.lambda;

/**
 * @author Simple
 * @date 2021/3/12 9:39
 */
public class TestLambda1 {
    //静态内部类
    static class Like2 implements ILike{

        @Override
        public void lambda() {
            System.out.println("静态内部类+lambda");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();//用接口创建对象，接口new实现类
        like.lambda();
        like = new Like2();
        like.lambda();

        //局部内部类
        class  Like3 implements ILike{

            @Override
            public void lambda() {
                System.out.println("局部内部类+lambda");
            }
        }
        like=new Like3();
        like.lambda();

        //匿名内部类
        like = new Like(){
            @Override
            public void lambda() {
                System.out.println("匿名内部类+lambda");
            }
        };
        like.lambda();

        //用lambda简化
        like = ()->{
            System.out.println("lambda表达式");
        };

        like.lambda();

    }
}
