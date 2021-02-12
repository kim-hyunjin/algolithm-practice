package com.github.kimhyunjin.basic;

/**
 * 유클리드 호제법을 사용한
 * 최대공약수(GCD, Greatest Common Divisor)
 * 최소공배수(LCM, Least Common Multiple)
 * 구하기
 */
public class GCDandLCM {

    public static int gcd(int a, int b) {
        while (b!=0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
