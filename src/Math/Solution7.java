package Math;
/*
 * #7 Reverse Integer
 * Reverse digits of an integer.
 */
import java.math.BigInteger;


public class Solution7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution7 s = new Solution7();
		int x = 123;
		System.out.println(s.reverse(x));
	}

	public int reverse(int x){
		String s = null;
		if (x < 0){
			s = String.valueOf(x);
			s = s.substring(1, s.length());
		}else{			
			s = String.valueOf(x);
		}
		
		char[] cc = s.toCharArray();
		int start = 0;
		int end = cc.length-1;
		while (start<end){
			char temp = cc[start];
			cc[start] = cc[end];
			cc[end] = temp;
			start++;
			end--;
		}
		
		s = String.valueOf(cc);
		BigInteger b = new BigInteger(s);
		BigInteger c = new BigInteger(String.valueOf(Integer.MAX_VALUE));
		if (b.compareTo(c) == 1){
			return 0;
		}
		
		if (x < 0){
			return Integer.parseInt("-"+s);
		}
		
		return Integer.parseInt(s);
	}
}
