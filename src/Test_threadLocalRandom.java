import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ThreadLocalRandom;

public class Test_threadLocalRandom {

    public static void main(String[] args) throws NoSuchMethodException {
        Class<ThreadLocalRandom> clazz = ThreadLocalRandom.class;
        Method getProbeMethod = clazz.getDeclaredMethod("getProbe");
        getProbeMethod.setAccessible(true);
        for(int i=0; i<10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName()+"   "+getProbeMethod.invoke(ThreadLocalRandom.current()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

}
