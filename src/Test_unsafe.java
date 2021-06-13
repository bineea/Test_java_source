import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Test_unsafe {

    private int x;
    private static Unsafe UNSAFE;

    static {
        try {
            Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);
            UNSAFE = (Unsafe) unsafeField.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws NoSuchFieldException {

        int j = 1;
        System.out.println("j << (31 - Integer.numberOfLeadingZeros(3)) = "+(j << (31 - Integer.numberOfLeadingZeros(3))));
        System.out.println("j * 3 = "+(j * 3));
        System.out.println("j << (31 - Integer.numberOfLeadingZeros(4)) = "+(j << (31 - Integer.numberOfLeadingZeros(4))));
        System.out.println("j * 4 = "+(j * 4));
        System.out.println("j << (31 - Integer.numberOfLeadingZeros(5)) = "+(j << (31 - Integer.numberOfLeadingZeros(5))));
        System.out.println("j * 5 = "+(j * 5));
        System.out.println("j << (31 - Integer.numberOfLeadingZeros(6)) = "+(j << (31 - Integer.numberOfLeadingZeros(6))));
        System.out.println("j * 6 = "+(j * 6));
        System.out.println("j << (31 - Integer.numberOfLeadingZeros(7)) = "+(j << (31 - Integer.numberOfLeadingZeros(7))));
        System.out.println("j * 7 = "+(j * 7));
        System.out.println("j << (31 - Integer.numberOfLeadingZeros(8)) = "+(j << (31 - Integer.numberOfLeadingZeros(8))));
        System.out.println("j * 8 = "+(j * 8));
        System.out.println("j << (31 - Integer.numberOfLeadingZeros(10)) = "+(j << (31 - Integer.numberOfLeadingZeros(10))));
        System.out.println("j * 10 = "+(j * 10));
        System.out.println("j << (31 - Integer.numberOfLeadingZeros(10)) = "+(j << (31 - Integer.numberOfLeadingZeros(12))));
        System.out.println("j * 12 = "+(j * 12));
        System.out.println("j << (31 - Integer.numberOfLeadingZeros(16)) = "+(j << (31 - Integer.numberOfLeadingZeros(16))));
        System.out.println("j * 16 = "+(j * 16));


        int[] testInt = new int[] {1,2,3};
        System.out.println("UNSAFE.arrayIndexScale:"+UNSAFE.arrayIndexScale(testInt.getClass()));
        String[] testString = new String[] {"111","222","333"};
        System.out.println("UNSAFE.arrayIndexScale:"+UNSAFE.arrayIndexScale(testString.getClass()));
        long[] testLong = new long[] {1L,2L,3L};
        System.out.println("UNSAFE.arrayIndexScale:"+UNSAFE.arrayIndexScale(testLong.getClass()));

        class testInner {
            private int x = 0;
            private long y = 0L;
        }

        testInner[] testInners = new testInner[]{new testInner()};
        System.out.println("UNSAFE.arrayIndexScale:"+UNSAFE.arrayIndexScale(testLong.getClass()));
        /*内部类
        final Test_unsafe test_unsafe = new Test_unsafe();
        class Test_inner {
            public void test_inner2outer() {
                System.out.println("test_inner2outer:" + test_unsafe.x);
            }
        }*/

        final Test_unsafe test_unsafe = new Test_unsafe();

        /*Unsafe实现cas操作
        long x_offset = UNSAFE.objectFieldOffset(test_unsafe.getClass().getDeclaredField("x"));
        int tmp = test_unsafe.x;
        UNSAFE.compareAndSwapInt(test_unsafe, x_offset, tmp, tmp+=1);
        System.out.println("x offset :"+x_offset);
        System.out.println("tmp:"+tmp);*/

        /*Unsafe实现具体cas操作
        final long x_offset = UNSAFE.objectFieldOffset(test_unsafe.getClass().getDeclaredField("x"));

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        int tmp = UNSAFE.getInt(test_unsafe, x_offset);
                        if(UNSAFE.compareAndSwapInt(test_unsafe, x_offset, tmp, tmp+=1)) {
                            System.out.println("~~~1:"+tmp);
                        }
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        int tmp = UNSAFE.getInt(test_unsafe, x_offset);
                        if(UNSAFE.compareAndSwapInt(test_unsafe, x_offset, tmp, tmp+=1)) {
                            System.out.println("~~~2:"+tmp);
                        }
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/
    }

}
