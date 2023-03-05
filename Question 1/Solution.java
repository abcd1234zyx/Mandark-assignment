import java.util.*;  
class Solution {
	public static void main(String []args) {
		ArrayList<Integer>firstArray=new ArrayList<Integer>();
		ArrayList<Integer>secondArray= new ArrayList<Integer>();
		System.out.println("Enter size");
		Scanner obj = new Scanner(System.in);
		int size=obj.nextInt();
		System.out.println("First Array Elements");
		for(int i=0;i<size;i++) {
			int value =obj.nextInt();
				firstArray.add(value);
		}
		System.out.println("Second Array Elements");
		for(int i=0;i<size;i++) {
			int value=obj.nextInt();
			secondArray.add(value);
		}
		int answer=minimumMultipicationOfMaximumAfterSwapping(firstArray,secondArray);
		System.out.println("Answer is "+answer);
	}
	public static int minimumMultipicationOfMaximumAfterSwapping(ArrayList<Integer>firstArray,ArrayList<Integer>secondArray) {
		int size=firstArray.size();
		int firstElement=Integer.MIN_VALUE,secondElement=Integer.MIN_VALUE;
		for(int i=0;i<size;i++) {
			firstElement=Math.max(firstElement,Math.min(firstArray.get(i),secondArray.get(i)));
			secondElement=Math.max(secondElement,Math.max(firstArray.get(i),secondArray.get(i)));
		}
		return firstElement*secondElement;
	}
}
