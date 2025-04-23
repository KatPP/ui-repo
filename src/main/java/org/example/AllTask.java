package org.example;

// Даны два целых положительных числа a и b (b > a). Надо сложить каждое второе число в диапазоне [a, b] начиная с первого (то есть суммировать через одно число).
//
//Например,
//
//[1, 2] => 1
//
//[1, 3] => 1 + 3 = 4
//
//[1, 5] => 1 + 3 + 5 = 9
//
//[0, 5] => 0 + 2 + 4 = 6
public class AllTask {
    public static void main(String[] args) {
        System.out.println(sum(1, 2));

    }

    public static int sum(int a, int b) {
        int res = 0;
        for (int i = a; i <= b; i = i + 2) {
            res = res + i;
        }
        return res;
    }

}
