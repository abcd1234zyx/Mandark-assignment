import java.util.*;

import java.io.*;

class Solution {
	public static void main(String[]args) throws Exception {
		String employeeFile="employees.csv" ,managerFile="manager.csv" , singleNameEmployeeFile="single_name_employees.csv";
		if(checkAndCreateFile(managerFile)==false) {
			System.out.println("Not able to create managers file");
			return;
		}
		if(checkAndCreateFile(singleNameEmployeeFile)==false) {
			System.out.println("Not able to create single name employee file");
			return;
		}
		if(checkFile(employeeFile) == false) {
			System.out.println("There is no employee file in this directory");
			return;
		}
		BufferedReader reader = new BufferedReader(new FileReader(employeeFile));
		String line = null;
		reader.readLine();
		ArrayList<String> values = new ArrayList<String>(); 
        BufferedWriter managerWriter = bufferReturn(managerFile);
        BufferedWriter singleNameWriter = bufferReturn(singleNameEmployeeFile);
		while ((line = reader.readLine()) != null) {
			values=seperateCommaSplit(line);
			if(singleNameEmployee(values) == true) {
				singleNameWriter.write(line);
				singleNameWriter.write("\n");
			}
			if(managerEmployee(values) == true) {
				managerWriter.write(line);
				managerWriter.write("\n");
			}
		}
		managerWriter.close();
		singleNameWriter.close();
	}
	private static boolean singleNameEmployee(ArrayList<String> values) {
		for(int i=0;i<values.get(0).length();i++) {
			if(values.get(0).charAt(i)== ' ') {
				return false;
			}
		}
		return true;
	}
	private static boolean managerEmployee(ArrayList<String> values) {
		
		if(values.get(1).trim().equals("Manager" ) == true && values.get(2).equals("R&D")) {
			return true;
		}
		return false;
	}
	private static boolean checkAndCreateFile(String name) {
		if(checkFile(name)==false) {
			System.out.println("There is no "+name+" file in this directory");
			return createFile(name);
		}
		System.out.println("File Exist");
		return true;
	}
	private static boolean createFile(String name) {
		File file = new File(name);
		try {
			file.createNewFile();
			return true;
		}
		catch(Exception ex) {
			System.out.println("exception" +ex.getMessage());
		}
		return false;
		
	}
	private static boolean checkFile(String name ) {
		File f = new File(name);
		return f.exists();
	}
	private static ArrayList<String> seperateCommaSplit(String line) {
		String[] elements = line.split(",");
		List<String> values = Arrays.asList(elements);
		return new ArrayList<String>(values);
		
	}
	private static BufferedWriter bufferReturn(String name) {
		try {
				FileWriter writer = new FileWriter(name);
				return new BufferedWriter(writer);
		}
		catch(Exception ex) {
			System.out.println("exception" +ex.getMessage());
		}
		return null;
	}
	
}