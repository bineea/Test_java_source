public class Test_array {

    public static void main(String[] args) {
        ToArray[] toArrays = new ToArray[3];
        ToArray to1 = new ToArray(1, "1");
        ToArray to2 = new ToArray(2, "2");
        ToArray to3 = new ToArray(3, "3");

        toArrays[0] = to1;
        toArrays[1] = to2;
        toArrays[2] = to3;

        toArrays[0].toPrint();
        toArrays[1].toPrint();
        toArrays[2].toPrint();

        toArrays[0].intVal = 11;
        toArrays[1].intVal = 22;
        toArrays[2].intVal = 33;

        to1.toPrint();
        to2.toPrint();
        to3.toPrint();
    }
}

class ToArray {
    public int intVal;
    public String strValue;

    public ToArray(int intVal, String strValue) {
        this.intVal = intVal;
        this.strValue = strValue;
    }

    public void toPrint() {
        System.out.println("intVal:"+this.intVal+";strValue:"+this.strValue);
    }
}