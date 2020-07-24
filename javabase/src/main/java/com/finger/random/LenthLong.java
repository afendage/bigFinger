package com.finger.random;

import org.junit.Test;

import java.util.Arrays;

public class LenthLong {

    int lengthOfLongestSubstring(String s) {
        if(null == s || s.length()<1){
            return 0;
        }
        if(s!=null && s.length()==1){
            return 1;
        }
        char [] arrays = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int strLen = 0;
        for (int i =0;i<arrays.length-1;i++) {
            sb.append(arrays[i]);

            // 大于 0 ， 就存在重复
            int repeat = sb.toString().indexOf(String.valueOf(arrays[i+1]));
            if((i+2) == arrays.length && repeat<0){
                sb.append(arrays[i+1]);
                repeat = sb.toString().indexOf(String.valueOf(arrays[i+1]));
            }
            int maxLen = repeat >=0 ?sb.toString().length():repeat;
            // 获取重复字符最长的
            if(maxLen>strLen){
                strLen = sb.toString().length();
            }
            // 存在重复- 重置sb
            if(repeat>=0){
                sb = new StringBuilder();
            }
        }
        if(strLen==0){
            strLen = s.length();
        }
        return strLen;
    }

    int lengthOfLongestSubstring1(String s) {
        // 问题：存在重复最长的字符串
        // 思路：重复点定在哪里- 每个字符循环所有字符做判断， 然后取最长
        char[] arrays = s.toCharArray();
        int result = 0;
        for(int i=0;i<arrays.length;i++){
            StringBuilder eachSb = new StringBuilder();
            for(int j =0;j<arrays.length;j++){
               String str = eachSb.append(arrays[j]).toString();
                //取最长
               int repeat = str.indexOf(arrays[i]);
               if(repeat>=0 && repeat>=result){
                   result = str.length();
               }
           }
        }
        return result;
    }


    @Test
    public void t(){
        int result = this.lengthOfLongestSubstring1("pwwkew");
        System.out.println(result);
    }


    public void duplicateZeros(int[] arr) {
        String str = Arrays.toString(arr).replaceAll(" ","");
        int arrlen= arr.length;
        str = str.replaceAll("0","0,0").replace("[","").replace("]","");
        String [] chars = str.split(",");
        for(int i = 0 ;i< arrlen;i++){
            arr[i] = Integer.valueOf(chars[i]);
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void tt(){
        int[] arr = {1,0,2,3,0,4,5,0};
        this.duplicateZeros(arr);
    }
}
