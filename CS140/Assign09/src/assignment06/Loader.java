package assignment06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Loader {
	
	public static void load(Memory memory, File assembled) throws CodeAccessException, DataAccessException{
		boolean beforeData = true;
		int count = 0;
		try {
			Scanner inp = new Scanner(assembled);
			
			while(inp.hasNextLine()){
				String line1 = inp.nextLine();
				
				if(line1.equals("-1")){
					beforeData = false;
				}
				else if(beforeData && inp.hasNextLine()){
					String line2 = inp.nextLine();
					memory.setCode(count, Integer.parseInt(line1), Integer.parseInt(line2));
					count++;
				}
				else if(!beforeData && inp.hasNextLine()){
					String line2 = inp.nextLine();
					memory.setData(Integer.parseInt(line1), Integer.parseInt(line2));
				}
			}
			inp.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
