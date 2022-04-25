package com.simple.thread.basics.intrinsiclock;

/**
 * @Author Simple
 * @Create 2021/9/2 10:48
 * 脏读
 *      出现读取属性值意外，读取的是中间值，而不是修改之后的值
 *      原因：对共享数据的修改 与对共享数据的读取不同步
 *      解决方法：
 *          不仅对修改数据的代码块同步，还要对读取数据的代码块同步
 */
public class Test07 {
    private static final int CYCLE_COUNT = 100;
    public static void main(String[] args) throws InterruptedException {
        // 开启线程设置用户名和密码
        PublicValue publicValue = new PublicValue();
        SubThread subThread = new SubThread(publicValue);
        subThread.start();

        // 为了修改成功后main线程能读取到
        Thread.sleep(1000);
        // 在main线程中读取用户名和密码
        publicValue.getValue();
    }

    static class PublicValue {
        private String name = "Simple";
        private String password = "666";

        public synchronized void getValue() {
            System.out.println(Thread.currentThread().getName()+",getter --name : "+name+" , getter --pwd :"+password);
        }

        public synchronized void setValue(String name, String password) {
            this.name = name;
            try {
                // 模拟修改数据花费的时间
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.password = password;
            System.out.println(Thread.currentThread().getName()+",setter --name : "+name+" , setter --pwd :"+password);
        }
    }

    static class SubThread extends Thread {
        private PublicValue publicValue;

        public SubThread(PublicValue publicValue) {
            this.publicValue = publicValue;
        }

        @Override
        public void run() {
            publicValue.setValue("Mxt","123");
        }
    }

}
