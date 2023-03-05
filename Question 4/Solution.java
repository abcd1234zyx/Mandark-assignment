import java.util.*;
class Solution {
	public static void main(String [] args) {
		Scanner obj =new Scanner(System.in);
		System.out.println("Enter xAxis");
		int xAxis=obj.nextInt();
		System.out.println("Enter yAxis");
		int yAxis=obj.nextInt();
		obj.nextLine();
		System.out.println("Enter directions");
		String directions =obj.nextLine();
		ArrayList<Integer> distance=calcDistance(directions);
		int verticalDistance=distance.get(0);
		int horizontalDistance=distance.get(1);
		double minDistance =manHattanDistance(verticalDistance,horizontalDistance);
		System.out.printf("ManHattan Distance is %,.1f",minDistance);
	}
	public static ArrayList<Integer> calcDistance(String directions){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int verticalDistance=0,horizontalDistance=0;
		for(int i=0;i<directions.length();i++) {
			if(directions.charAt(i)=='N') {
				verticalDistance++;
			}
			else if(directions.charAt(i)=='S') {
				verticalDistance--;
			}
			else if(directions.charAt(i)=='E') {
				horizontalDistance++;
			}
			else {
				horizontalDistance--;
			}
		}
		arr.add(Math.abs(horizontalDistance));
		arr.add(Math.abs(verticalDistance));
		
		return arr;
	}
	public static double manHattanDistance(int verticalDistance,int horizontalDistance) {
		int squareVerticalDistance= verticalDistance * verticalDistance;
		int squareHorizontalDistance = horizontalDistance * horizontalDistance;
		return Math.sqrt(squareHorizontalDistance+squareVerticalDistance);
	}
}
