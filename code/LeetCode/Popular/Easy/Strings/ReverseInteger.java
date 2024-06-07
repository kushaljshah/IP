package LeetCode.Popular.Easy.Strings;

/**
 * Created by kushal.shah
 */
public class ReverseInteger {

    public static int reverse1(int x) {

        int result = 0;
        while (x != 0) {
            int mod = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && mod > 7)) return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && mod < -8)) return 0;
            result = (result * 10) + mod;

        }

        return result;
    }

    public static int reverse(int x) {

        int ans = 0;

        while(x!=0){
            int r = x%10;
            x = x/10;

            if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && r > 7) ) return -1;
            if(ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE/10 && r < -8) ) return -2;

            ans = (ans*10) + r ;
            System.out.println("r: " + String.valueOf(r));
            System.out.println("ans: " + String.valueOf(ans));
        }



        return ans;


    }

    public static void main(String[] args) {
//        System.out.println(reverse(-2147483648));
        System.out.println(reverse(1234));
//        System.out.println(reverse(Integer.MAX_VALUE));
//        System.out.println(reverse(Integer.MIN_VALUE));
    }
}
