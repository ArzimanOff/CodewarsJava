/*
https://www.codewars.com/kata/526989a41034285187000de4/train/java
*/

package com.codewars.arziman_off.kuy5;

public class CountIpAddresses {
    public static long ipsBetween(String start, String end) {
        return ipToLongInt(end) - ipToLongInt(start);
    }

    public static long ipToLongInt(String ip) {
        long ans = 0;
        int[] intsOfIp = new int[4];
        String[] numsOfIp = ip.trim().split("\\.");

        for (int i = 0; i < 4; i++) {
            // записываем в массив intsOfIp значения из массива numsOfIp в ОБРАТНОМ ПОРЯДКЕ!
            intsOfIp[i] = Integer.parseInt(numsOfIp[4 - i - 1]);
            // побитовый сдвиг влево (<<) для каждого октета (intsOfIp[i])
            ans += (long) intsOfIp[i] << (i * 8);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(ipsBetween("10.0.0.0", "10.0.0.50"));
        System.out.println(ipsBetween("20.0.0.10", "20.0.1.0"));
        System.out.println(ipsBetween("0.0.0.0", "255.255.255.255"));
    }
}
