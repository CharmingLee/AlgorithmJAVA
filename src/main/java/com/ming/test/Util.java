package com.ming.test;

/**
 * Created by charminglee on 17-7-19.
 *
 */
public class Util {

    public int count = 0;

    class UtileInsid {
        private int count = -1;

        public void test(){
            System.out.println(Util.this.count);
        }
    }

    public UtileInsid getUi(){
        return new UtileInsid();
    }

    public static int maxSUM(int[] arr){
        int maxSum = 0;
        int thisSum = 0;
        for (int i : arr) {
            thisSum += i;

            if (thisSum > maxSum)
                maxSum = thisSum;
            else if (thisSum < 0)
                thisSum = 0;
        }

        return maxSum;
    }

    public static int maxSUM2(int[] arr){
        int maxSum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int thisSum = 0;
            for (int j = i; j < arr.length; j++) {
                thisSum += arr[i];

                if (thisSum > maxSum)
                    maxSum = thisSum;
            }
        }

        return maxSum;
    }

    public static int binarySearch(int[] arr, int a){
        int low = 0;
        int max = arr.length - 1;

        while (low <= max){
            int mid = (low + max) / 2;

            if (arr[mid] < a)
                low = mid + 1;
            else if (arr[mid] > a)
                max = mid - 1;
            else
                return mid;

        }

        return -1;
    }

    public static long gcd(long m, long n){
        while (n != 0){
            long rem = m%n;
            System.out.println("m = " + m + "; n = " + n + "; rem = " + rem);
            m = n;
            n = rem;
        }

        return m;
    }

}
