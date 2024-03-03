package com.codewars.arziman_off.kuy6;

import java.util.Arrays;

public class BuildTower {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(towerBuilder(4)));
        System.out.println(Arrays.toString(towerBuilder(8)));
        System.out.println(Arrays.toString(towerBuilder(12)));
    }
    public static String[] towerBuilder(int nFloors) {
        String[] ans = new String[nFloors];
        String n = "*";
        String m = " ";
        int max = (nFloors - 1);
        int cnt = 1;
        for (int i = 0; i < nFloors; i++) {
            String s = "";
            s += m.repeat(max) + n.repeat(cnt) + m.repeat(max--);
            cnt += 2;
            ans[i] = s;
        }
        return ans;
    }
}