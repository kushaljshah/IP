package LeetCode.Popular.Easy.Strings;

/**
 * Created by kushal.shah
 */
public class StringToInteger {

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi("+-12"));
        System.out.println(myAtoi("-+12"));
        System.out.println(myAtoi("00000-42a1234"));
        System.out.println(myAtoi("   +0 123"));
        System.out.println(myAtoi("2147483648"));
        System.out.println(myAtoi("2147483646"));
    }

    public static int myAtoi(String s) {

        int result = 0;
        char sign = '+';
        boolean signed = false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                if(i>0 && (s.charAt(i-1) != ' ')){
                    break;
                }
                continue;
            }

            if(!signed && (s.charAt(i) == '-' || s.charAt(i) == '+')){
                if(i>0 && (s.charAt(i-1) != ' ')){
                    break;
                }
                sign = s.charAt(i);
                signed = true;
                continue;
            }

            if((int) s.charAt(i) < 48 || (int) s.charAt(i) > 57){
                break;
            }else{
                if(sign == '-'){
                    if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && (s.charAt(i) - '0') > 8)){
                        result = Integer.MIN_VALUE;
                        break;
                    }
                }else{
                    if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && (s.charAt(i) - '0') > 7)){
                        result = Integer.MAX_VALUE;
                        break;
                    }
                }

                result = (result * 10) + (s.charAt(i) - '0');
            }
        }

        if(result >0 && sign == '-'){
            result = result * -1;
        }
        return result;
    }
}
