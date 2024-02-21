package com.leetcode.arziman_off.medium;

import java.util.HashMap;
import java.util.Map;

public class BitwiseANDofNumbersRange {
    public static void main(String[] args) {
        System.out.println("Ответ: " + rangeBitwiseAnd(13, 15));
    }

    // самый оптимальный способ:
    public static int rangeBitwiseAnd(int left, int right){
        int ans;
        int shift = 0;
        while (left < right){
            left >>= 1;
            right >>= 1;
            shift++;
        }
        ans = left<<shift;
        return ans;
    }

    // не эффективен для больших значений:
//    public static int rangeBitwiseAnd(int left, int right) {
//        String rightBinary = Integer.toBinaryString(right);
//        System.out.println("right в бинарном представлении: " + rightBinary);
//        int rightBitsCnt = rightBinary.length();
//        System.out.println("Кол-во битов в числе right: " + rightBitsCnt);
//        Map<Integer, Integer> bitsMap = new HashMap<>();
//        // пройдемся по всем битам right в обратном порядке и добавим в HashMap
//        for (int i = rightBitsCnt-1; i >= 0; i--){
//            // инициализируем map единицами:
//            bitsMap.put(i, 1);
//        }
//
//        for (int num = right; num >= left; num--){
//            String numBinary = Integer.toBinaryString(num);
//            int numBitsCnt = numBinary.length();
//            for (int i = 0; i < numBitsCnt; i++){
//                int thisBit = Integer.parseInt(String.valueOf(numBinary.charAt(numBitsCnt - 1 - i)));
//                // i = порядок бита
//                // thisBit = что хранится в i-том бите с конца в числе num
//                int newBit = bitsMap.get(i) & thisBit;
//                bitsMap.put(i, newBit);
//            }
//        }
//
//        System.out.println("порядок битов с конца и их значения: " + bitsMap);
//
//        // Преобразуем список в число:
//        int ans = 0;
//        for (int i = 0; i < rightBitsCnt; i++){
//            if (bitsMap.get(i) == 1){
//                ans += (int) Math.pow(2, i);
//            }
//        }
//        return ans;
//    }
}
