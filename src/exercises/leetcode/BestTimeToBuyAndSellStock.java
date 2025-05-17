package exercises.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {2,4,1};
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));
    }
    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price:prices){

            if (price<minPrice){
                minPrice = price;
            }

            else if (price - minPrice>maxProfit){
                maxProfit = price - minPrice;
            }
        }



        return maxProfit;
    }


}
