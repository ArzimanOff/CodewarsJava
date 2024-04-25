package com.other_tasks;

import java.util.Scanner;

public class PasswordHack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        aaa(n);
        //System.out.println(countSteps(n, k));
    }

    public static void aaa(int n) {
        int cnt = 0;
        long i = (long) Math.pow(10, n - 1);
        long j = (long) Math.pow(10, n);
        int err = 0;
        for (; i < j; i++){
            if (parityIsAlternating(i)){
                n = bbb(cnt);
                if (i != n){
                    System.out.println( i + " != " + n + " -> " + cnt + " разница : " + (n - i));
                    err++;
                }
                cnt++;
            }
        }
        System.out.println(err);
    }

    public static int bbb(int i){
        return (i/625 + 1)*10000 +
                (((i/125 - i/625*5)*2)*1000 + 1000 * ((i/625)%2) ) +
                (((i/25 - i/125*5)*2)*100 + 100 * ((i/625 + 1)%2) ) +
                (((i/5 - i/25*5)*2)*10 + 10 * ((i/625)%2) ) +
                (((i - i/5*5)*2)+ ((i/625 + 1)%2) );
    }


    public static int countSteps(int n, int k){
        int ans = 0;
        long i = 0;
        long j = 0;
        if (n == 0){
            return 0;
        } else if (n == 1){
            return k;
        } else {
            i = (long) Math.pow(10, n - 1);
            j = (long) Math.pow(10, n);
            // узнаем наименьшее n-значное кратное k
            while (i % (long)k != 0){
                i++;
            }
            for (; i < j; i += k){
                if (parityIsAlternating(i)){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static boolean parityIsAlternating(long num){
        String numStr = Long.toString(num);

        for (int i = 1; i < numStr.length(); i++) {
            int currentDigit = numStr.charAt(i) - '0';
            int prevDigit = numStr.charAt(i - 1) - '0';

            if ((currentDigit % 2 == 0 && prevDigit % 2 == 0) ||
                    (currentDigit % 2 != 0 && prevDigit % 2 != 0)) {
                return false;
            }
        }
        return true;
    }
}

