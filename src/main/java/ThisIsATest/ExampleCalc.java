package ThisIsATest;

public class ExampleCalc {

    public int a=0;
    public int b=0;
    public int sum=0;

    public int addieren(int a, int b){

        sum = a + b;

        return sum;
    }

    public static void main(String[] args){

        ExampleCalc ex = new ExampleCalc();

        System.out.println(ex.addieren(3,3));

    }

}
