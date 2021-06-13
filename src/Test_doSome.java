public class Test_doSome {

    private static boolean ready;
    private static int number;

    private static class InnerClassThread extends Thread {
        public void run() {
            while(!ready) {
                System.out.println("*****");
            }
            System.out.println("00000");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InnerClassThread testInner =  new InnerClassThread();
        testInner.start();
        Thread.sleep(5000);
        number = 100;
        ready = true;
    }
}
