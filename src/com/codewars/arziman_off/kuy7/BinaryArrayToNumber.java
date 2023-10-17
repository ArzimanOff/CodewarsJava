/*
https://www.codewars.com/kata/578553c3a1b8d5c40300037c/train/java
*/

package com.codewars.arziman_off.kuy7;

import java.util.List;

public class BinaryArrayToNumber {

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        int ans = 0;
        for (int i = 0; i < binary.size(); i++){
            if (binary.get(i) == 1){
                ans += (int) Math.pow(2, (binary.size() - i - 1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(ConvertBinaryArrayToInt(List.of(0, 0, 0, 1)));
        System.out.println(ConvertBinaryArrayToInt(List.of(0, 1, 0, 1)));
        System.out.println(ConvertBinaryArrayToInt(List.of(1, 1, 1, 1)));
    }
}
