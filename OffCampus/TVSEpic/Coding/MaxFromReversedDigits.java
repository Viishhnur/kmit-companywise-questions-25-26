
/*
 You are given a array of integers, you need to reverse the individual element of the array,
 then for each element , rearrange the digits of the elements to form the maximum element and then replace all unique odd digit with # , 
 even with * and zero with $ , Print the result of formed symbols in form of final String/

 Note:- The order of characters in the final string is determined by the sequence of unique digits from each element in the array , procesed
 in order from the first to the last

🔍 Example

Input:

3
1201 21 10

Explanation:

    1201 → Reverse = 1021 → Max from digits = 2110

    21 → Reverse = 12 → Max from digits = 21

    10 → Reverse = 1 → Max from digits = 1

Now unique digits order is 2,1,0 -> resultant string is *#$

Output:
*#$

 Constraints

    1 <= arr.length <= 10^5

    0 <= arr[i] <= 10^5
 */
import java.util.*;

public class MaxFromReversedDigits {

    // Main method to process the array
    public static String transformAndSort(String[] nums, final int n) {
        for (int i = 0; i < n; i++) {
            String num = nums[i];

            // Step 1: Reverse the number and convert to char array
            char[] digits = new StringBuilder(num).reverse().toString().toCharArray();

            // Step 2: Remove leading zeros 
            int j = 0;
            while(j < digits.length && digits[j] == '0'){
                j++;
            }
            
            // Step3:- Now sort the array from j to end 
            Arrays.sort(digits,j,digits.length);

            // Step 4:- Extract the chars from j , end and reverse it and store it 
            StringBuilder tmp = new StringBuilder();

            for( ; j < digits.length ; j++){
                tmp.append(digits[j]);
            }

            nums[i] = tmp.reverse().toString();
        }


        LinkedHashSet<Character> st = new LinkedHashSet<>();

        for(String num : nums){
            for(char ch : num.toCharArray()){
                st.add(ch);
            }
        }

        StringBuilder res = new StringBuilder();

        for(char ch : st){
            res.append(ch == '0' ? '$' : (ch - '0') % 2 == 0 ? '*' : '#');
        }
            

        return res.toString();
    }

    // Driver code for testing
    public static void main(String[] args) {

        int n;
        String[] nums;
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
            nums = new String[n];

            for (int i = 0; i < n; i++) {
                nums[i] = sc.next();
            }
        }

        System.out.println(transformAndSort(nums, n)); 
    }
}
