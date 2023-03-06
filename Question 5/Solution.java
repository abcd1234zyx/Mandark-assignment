import java.util.*;
class Solution {
	public static void main(String []args) {
		Scanner obj=new Scanner(System.in);
		int number=obj.nextInt();
		System.out.println(isDivisorSum(number));
	}
	public static String isDivisorSum(int number) {
		int count=1;
		int limit=(int)Math.sqrt(number);
		if(limit==Math.sqrt(number)) {
			count+= Math.round(Math.sqrt(number));
		}
		for(int i=2;i<Math.sqrt(number);i++) {
			if(number%i ==0) {
				count+=i;
				count+=number/i;
			}
		}
		if(count==number) {
			return "true";
		}
		return "false";
	}
}