package com.leetcode.arziman_off.medium;

import java.util.HashMap;
import java.util.Map;

public class MinimumRoundsToCompleteAllTasks {
    public static void main(String[] args) {
        int[] arr = {2,2,3,3,2,4,4,4,4,4};
        System.out.println(minimumRounds(arr));
    }
    public static int minimumRounds(int[] tasks) {
        int cnt = 0;
        // подсчет кол-ва задач определенной сложности
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : tasks) {
            if (!map.containsKey(i)){
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        // пройдемся по всем значениям ключей
        // если ключ 1, то значит есть всего одна задача с такой сложностью, и
        // должно вернуться -1
        // иначе вычитаем максимально возможное кол-во задач в день, то есть 3
        for (Integer key : map.values()){
            if (key == 1){
                return -1;
            } else {
                cnt += key / 3;
                if (key % 3 != 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
