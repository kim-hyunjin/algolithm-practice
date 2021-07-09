package com.github.kimhyunjin.programmers.exhaustive_search;

import java.util.HashSet;
import java.util.Set;

/**
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 *
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * numbers는 길이 1 이상 7 이하인 문자열입니다.
 * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
 * "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 */
public class PrimeNumber {
    public static int solution(String numbers) {
        char[] numberChars = numbers.toCharArray();
        Set<String> numSet = new HashSet<>();

        for (int i = 0; i < numberChars.length; i++) {
            permutation(numberChars, numberChars.length, i + 1, numSet);
        }

        int answer = 0;
        for (String num : numSet) {
            if (isPrime(Integer.parseInt(num))) {
                answer++;
            }
        }
        return answer;
    }

    private static void permutation(char[] numChar, int length, int pickSize, Set<String> numSet) {

    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String numbers = "17";
        int answer = solution(numbers);
        int expected = 3;
        if (answer == expected) {
            System.out.println("OK");
        } else {
            System.out.println("NOT OK");
        }

        String numbers2 = "011";
        int answer2 = solution(numbers2);
        int expected2 = 2;
        if (answer2 == expected2) {
            System.out.println("OK");
        } else {
            System.out.println("NOT OK");
        }
    }
}