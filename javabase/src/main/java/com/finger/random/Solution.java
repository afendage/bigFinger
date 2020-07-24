package com.finger.random;

import org.junit.Test;

/**
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 *
 * 示例 1：
 *
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 *
 * 示例 2：
 *
 * 输入：n = 4421
 * 输出：21
 * 解释：
 * 各位数之积 = 4 * 4 * 2 * 1 = 32
 * 各位数之和 = 4 + 4 + 2 + 1 = 11
 * 结果 = 32 - 11 = 21
 */

public class Solution {

    /**
     * 方法一 ： 转为字符数组
     * @param n
     * @return
     */
    public int subtractProductAndSum(int n){
        char[] nums = String.valueOf(n).toCharArray();
        System.out.println("个位数："+nums[nums.length-1]+"十位数："+nums[nums.length-2]+"百位数："+nums[nums.length-3]);
        int cj = Integer.parseInt(String.valueOf(nums[0])) * Integer.parseInt(String.valueOf(nums[1])) * Integer.parseInt(String.valueOf(nums[2]));
        int sum = Integer.parseInt(String.valueOf(nums[0])) + Integer.parseInt(String.valueOf(nums[1])) + Integer.parseInt(String.valueOf(nums[2]));
        int result = cj - sum;
        return result;
    }

    /**
     * 方法二： 计算出
     * @param n
     * @return
     */
    public int subtractProductAndSum1(int n){
        int bai = n/100%10;//百位除以100%10
        int shi = n%100/10;//十位%100/10
        int ge = n%10;      //个位直接%10
        System.out.println("百位是"+bai+"十位是"+shi+"个位数是"+ge);
        int result = bai * shi * ge -(bai + shi + ge);
        return result;
    }

    /**
     * 取余计算- 动态
     * @param n
     * @return
     */
    public int subtractProductAndSum2(int n) {
        int sum = 0;
        int product = 1;
        while (n > 0) {
            int num = n % 10;
            sum += num;
            product *= num;
            n /= 10;
        }
        return product - sum;
    }


    @Test
    public void t(){
        int result = this.subtractProductAndSum(234);
        System.out.println(result);

        int result1 = this. subtractProductAndSum1(234);
        System.out.println(result1);

        int result2 = this.subtractProductAndSum2(234);
        System.out.println(result2);
    }

    @Test
    public void t1(){
        System.out.println(234/1000);
    }

}
