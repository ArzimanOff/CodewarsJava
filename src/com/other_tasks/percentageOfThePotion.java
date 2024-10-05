package com.other_tasks;

public class percentageOfThePotion {

    public static void main(String[] args) {
        System.out.println(stepCnt(65));
    }
    public static int stepCnt(int k){
        if (k == 0 || k == 100) return 1;
        int es = k; //40
        int w = 100 - k; //60
        int min = (es > w) ? w : es; // 40

        for (int i = min; i > 1; i--){ //20
            if (es % i == 0 && w % i == 0){
                es /= i; //2
                w /= i; //3
            }
        }
        return es + w;
    }
}
