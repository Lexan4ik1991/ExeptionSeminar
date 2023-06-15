import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class HomeWork1 {

    public static void main(String[] args) {
        // method1(null);
        //method2();
       // DivisionZero();
        method4Array();

    }

    //NullPointerExeption
    public static void method1(String str) {
        int length = str.length();
        System.out.println(length);
    }

    //ArrayIndexOutOfBoundsException
    public static void method2() {
        int[] array = new int[5];
        int elm = array[6];
        System.out.println(elm);
    }

    public static void DivisionZero() {
        int firstNumber;
        int secondNumber;

        try {
            firstNumber = 1;
            secondNumber = 0;
            int result = firstNumber / secondNumber;
        } catch (ArithmeticException e) {
            System.out.println(e + ": На ноль делить нельзя!");

        }
    }
          public static void method4Array(){
          int[] array1 = createArray();
          int[] array2 = createArray();

            System.out.println("Первый массив " + Arrays.toString(array1));
            System.out.println("Второй массив " + Arrays.toString(array2));
            System.out.println("Разница двух  массивов " + differenceArray(array1, array2));
            System.out.println("Частное двух массивов " + divideArray(array1, array2));
}

    public static ArrayList<Integer> differenceArray(int[] a1, int[] a2) {
        ArrayList<Integer> res = new ArrayList<>();
        int min = Math.min(a1.length, a2.length);
        int max = Math.max(a1.length, a2.length);
        if (min < 1) {
            throw new RuntimeException("Один из массивов пуст");
        }
        if (min < max) {
            throw new RuntimeException("Длинны массивов не равны!");
        }
        for (int i = 0; i < min; i++) {
            res.add(a1[i] - a2[i]);
        }
        return res;
    }

    public static ArrayList<Float> divideArray(int[] a1, int[] a2) {
        ArrayList<Float> res = new ArrayList<>();
        int min = Math.min(a1.length, a2.length);
        int max = Math.max(a1.length, a2.length);
        if (min < 1) {
            throw new RuntimeException("один из массивов пуст");
        }
        if (min < max) {
            throw new RuntimeException("Длинны массивов не равны!");
        }
        for (int i = 0; i < min; i++) {
            if (a2[i] != 0) {
                res.add((float) (a1[i] / a2[i]));
            } else {
                throw new RuntimeException("Деление на ноль");
            }
        }
        return res;
    }
    public static int [] createArray() {
        Random random = new Random();
        int [] arr = new int[random.nextInt(2) + 4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }
        return arr;
    }
}

