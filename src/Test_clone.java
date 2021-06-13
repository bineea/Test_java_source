public class Test_clone implements Cloneable {

    private String firstField;
    private Inner secondField;
    private int thirdField;

    public static void main(String[] args) throws CloneNotSupportedException {
        Test_clone test = new Test_clone();
        test.checkClone();
    }

    public void checkClone() throws CloneNotSupportedException {
        Test_clone test_one = new Test_clone();
        test_one.firstField = "test_one:firstField";
        Inner to_se = new Inner();
        to_se.innerfield = "test_one:secondField";
        test_one.secondField = to_se;
        test_one.thirdField = 11;

        Test_clone test_two = (Test_clone) test_one.clone();
        test_one.thirdField = 22;
        test_one.secondField.innerfield = "test_two:secondField";
        test_one.firstField = "test_two:secondField";

        System.out.println("test_one.firstField："+test_one.firstField);
        System.out.println("test_one.secondField.innerfield："+test_one.secondField.innerfield);
        System.out.println("test_one.secondField："+test_one.secondField);
        System.out.println("test_one.thirdField："+test_one.thirdField);
        System.out.println("-----------------------------------------");
        System.out.println("test_two.firstField："+test_two.firstField);
        System.out.println("test_two.secondField.innerfield："+test_two.secondField.innerfield);
        System.out.println("test_two.secondField："+test_two.secondField);
        System.out.println("test_two.thirdField："+test_two.thirdField);
    }

    class Inner {
        private String innerfield;
    }
}
