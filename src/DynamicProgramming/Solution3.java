package DynamicProgramming;
/*
 * Given a string, find the length of the longest substring without repeating characters.
 */
import java.util.HashSet;
import java.util.Set;

public class Solution3 {
	
	public static void main(String[] args){
		String s = "abcabcbb";
		
		Solution3 sol = new Solution3();
		System.out.println(sol.lengthOfLongestSubstring(s));
	}
	
	/*
	 * 用dp+HashSet会超时，原因是需要变脸i之前的dp[i-1]个字符判断是否重复
	 */
	/*
	public int lengthOfLongestSubstring(String s) {
        if (s==null || s.length()==0)
        	return 0;
        
		int[] dp = new int[s.length()];
		dp[0] = 1;
		
		for (int i=1;i<s.length();i++){
			int len = dp[i-1];
			String cur = s.substring(i, i+1);
			Set<String> set = new HashSet<>();
			set.add(cur);
			int k = 1;
			for (int j=i-1;j>=i-len;j--){
				if (set.contains(s.substring(j, j+1))){
					break;
				}
				set.add(s.substring(j, j+1));
				k++;
			}
			dp[i] = k;
		}
		
		int max = dp[0];
		for (int i=0;i<dp.length;i++){
			if (dp[i]>max)
				max = dp[i];
		}
		return max;
    }
	*/
	
	public int lengthOfLongestSubstring(String s) {
	    int i = 0, j = 0, max = 0;
	    Set<Character> set = new HashSet<>();
	    
	    while (j < s.length()) {
	        if (!set.contains(s.charAt(j))) {
	            set.add(s.charAt(j++));
	            max = Math.max(max, set.size());
	        } else {
	            set.remove(s.charAt(i++));
	        }
	    }
	    
	    return max;
	}
}
