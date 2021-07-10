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
        int[] intNumbers = new int[numbers.length()];
        Set<String> numSet = new HashSet<>();

        for (int i = 0; i < numbers.length(); i++) {
            String strNum = numbers.substring(i, i+1);
            intNumbers[i] = Integer.parseInt(strNum);
            numSet.add(strNum);
        }

        heapPermutation(intNumbers, intNumbers.length, intNumbers.length, numSet);

        int answer = 0;
        for (String num : numSet) {
            System.out.println(num);
            if (isPrime(Integer.parseInt(num))) {
                answer++;
            }
        }
        return answer;
    }

    // Prints the array
    private static void storeNumber(int a[], int n, Set<String> storage)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(a[i]);
        }
//        System.out.println(sb);
        storage.add(sb.toString());
    }

    // Generating permutation using Heap Algorithm
    private static void heapPermutation(int a[], int size, int n, Set<String> storage)
    {
        // if size becomes 1 then store the obtained
        // permutation
        if (size == 1)
            storeNumber(a, n, storage);

        for (int i = 0; i < size; i++) {
            heapPermutation(a, size - 1, n, storage);

            // if size is odd, swap 0th i.e (first) and
            // (size-1)th i.e (last) element
            if (size % 2 == 1) {
                int temp = a[0];
                a[0] = a[size - 1];
                a[size - 1] = temp;
            }

            // If size is even, swap ith
            // and (size-1)th i.e last element
            else {
                int temp = a[i];
                a[i] = a[size - 1];
                a[size - 1] = temp;
            }
        }
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
