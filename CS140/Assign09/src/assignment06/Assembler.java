package assignment06;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Assembler {
	
	static Set<String> allowsImmediate = new HashSet<String>();
	static Set<String> allowsIndirect = new HashSet<String>();
	static Set<String> noArgument = new HashSet<String>();
	static Map<String, Integer> opcode = new HashMap<String, Integer>();
	
	static{
		allowsImmediate.add("ADD");
		allowsImmediate.add("LOD");
		allowsImmediate.add("SUB");
		allowsImmediate.add("MUL");
		allowsImmediate.add("DIV");
		allowsImmediate.add("AND");
		
		allowsIndirect.add("ADD");
		allowsIndirect.add("LOD");
		allowsIndirect.add("STO");
		allowsIndirect.add("JUMP");
		allowsIndirect.add("JMPZ");
		allowsIndirect.add("SUB");
		allowsIndirect.add("MUL");
		allowsIndirect.add("DIV");
		
		noArgument.add("NOP");
		noArgument.add("HALT");
		noArgument.add("NOT");
		
		opcode.put("LOD", 0x1);
		opcode.put("STO", 0x2);
		opcode.put("JUMP", 0xB);
		opcode.put("JMPZ", 0xC);
		opcode.put("NOP", 0x0);
		opcode.put("HALT", 0xF);
		opcode.put("ADD", 0x3);
		opcode.put("SUB", 0x4);
		opcode.put("MUL", 0x5);
		opcode.put("DIV", 0x6);
		opcode.put("AND", 0x7);
		opcode.put("NOT", 0x8);
		opcode.put("CMPZ", 0x9);
		opcode.put("CMPL", 0xA);
	}
	

	/*
	 * first thing it does is check that the file is there and works.
	 * 
	 * then it steps through the file line by line
	 * 
	 * it trims the lines if there is nothing there and first checks for a '#'
	 * if it is there then it checks that the first part of the argument is
	 * allowed to be immediate. if so then it checks that there are the right
	 * number of parts and then runs whatever the code is
	 * 
	 * same thing if it sees an '&' sign only checks to see if it is in the above 
	 * list for being allowed to be in indirect. runs through the same stuff.
	 * 
	 * if it has no sign then checks if it is above and sets the value to be
	 * zero because thats what we were told to do.
	 * 
	 * if it runs into the line "DATA" then there is an error that we are getting
	 * code after the line data and we are told as such. 
	 * 
	 * 
	 * for example if you run ADD with the argument it will get the accumulator
	 * and add the data at the location of arg.
	 * if you run ADD# it will flag as immediate and it will get the accumulator
	 * and add it to the passed in argument
	 * if you run ADD& it will flag as indirect and it will add the data at the
	 * location of the location of arg with the accumulator.
	 * 
	 * 
	 * @param input file and the output file
	 * @return is goodProgram which tells us if it worked or not
	 */
	public static boolean assemble(File input, File output){
		boolean goodProgram = false; // will be used at end of method
		try {
		    goodProgram = true;
		    Scanner inp = new Scanner(input);
		    PrintWriter outp = new PrintWriter(output);
		    boolean blankLineHit = false; //keep track of when we hit a blank line for when you do error checking
		    boolean inCode = true; //keep track that we are in the code, not in data
		    int lineCounter = 0; // for use in reporting errors
		    while(inp.hasNextLine() && goodProgram) {
		// ...lots and lots of if's, make use of the Sets and Map described in the Pippin Instruction Set handout, Page 3.
		// Note that we split a String line into parts using String[ ] parts = line.trim().split("\\s+");
		// To convert a hexadecimal String to a int, you will use int num = Integer.parseInt(parts[1], 16);
		// IMPORTANT, if you want to see that a String str is a member of a String Set strs, you use 
		// if(strs.contains(str))
		// and if you want to see that a String str is a key of the Map ops, you use
		// if(ops.containsKey(str))
		    	
		    	
		    	String line = inp.nextLine();
		    	lineCounter++;
		    	if(blankLineHit && line.trim().length() > 0){
		    		goodProgram = false;
		    		System.out.println("Assembler ERROR: File contains blank lines that are not at the end");
		    		System.out.println("Error occurs right before line " + lineCounter + ": " + line);
		    	}
		    	else if(!blankLineHit && line.trim().length() == 0){
		    		blankLineHit = true;
		    	}
		    	else if(!blankLineHit && line.trim().length() > 0){
		    		if(line.charAt(0) == ' ' || line.charAt(0) == '\t'){
		    			goodProgram = false;
		    			System.out.println("Assembler ERROR: Line contains leading spaces or tabs");
			    		System.out.println("Error occurs at line " + lineCounter + ": " + line);
		    		}
		    		
		    		else{
			    	
				    	String[] parts = line.trim().split("\\s+");
				    	int code = 0;
		    			
		    			if (line.trim().equals("DATA")){
				    		inCode = false;
				    		outp.println(-1);
				    	}
		    			
				    	if(inCode){
				    		if (parts[0].charAt(parts[0].length() - 1) == '#'){
				    			// System.out.println("Entering # loop");
				    			if(opcode.containsKey(parts[0].substring(0, parts[0].length() - 1))){
				    				if (allowsImmediate.contains(parts[0].substring(0, parts[0].length() - 1))){
				    					
				    					code = opcode.get(parts[0].substring(0, parts[0].length() - 1));
				    					outp.println(code*4+1);
				    					if(parts.length > 2){
				    						System.out.println("Assembler ERROR: Too many arguments.");
				    						System.out.println("Assembler Error occurs at line " + lineCounter + ": " + line);
				    						goodProgram = false;
				    					}
				    					else if(parts.length == 1){
				    						System.out.println("Assembler ERROR: Not enough arguments.");
				    						System.out.println("Assembler Error occurs at line " + lineCounter + ": " + line);
				    						goodProgram = false;
				    					}
				    					else{
					    					try{
					    						int num = Integer.parseInt(parts[1], 16);
					    						outp.println(num);
					    					} catch (NumberFormatException e){
					    						System.out.println("Assembler ERROR: Argument is not a numerical.");
					    						System.out.println("Assembler Error occurs at line " + lineCounter + ": " + line);
					    						goodProgram = false;
					    					}
					    				}
				    				}
				    			}
				    			else{
				    				System.out.println("Assembler ERROR: Instruction does not exist.");
				    				System.out.println("Assembler Error occurs at line " + lineCounter + ": " + line);
				    				goodProgram = false;
				    			}
				    		}
				    		
				    		else if(parts[0].charAt(parts[0].length() - 1) == '&'){
				    			
				    			if(opcode.containsKey(parts[0].substring(0, parts[0].length() - 1))){
				    				
				    				if (allowsIndirect.contains(parts[0].substring(0, parts[0].length() - 1))){
				    					
				    					code = opcode.get(parts[0].substring(0, parts[0].length() - 1));
				    					outp.println(code*4+2);
				    					if(parts.length > 2){
				    						System.out.println("Assembler ERROR: Too many arguments.");
				    						System.out.println("Assembler Error occurs at line " + lineCounter + ": " + line);
				    						goodProgram = false;
				    					}
				    					else if(parts.length == 1){
				    						System.out.println("Assembler ERROR: Not enough arguments.");
				    						System.out.println("Assembler Error occurs at line " + lineCounter + ": " + line);
				    						goodProgram = false;
				    					} else{
				    						
					    					try{
					    						int num = Integer.parseInt(parts[1], 16);
					    						outp.println(num);
					    					} catch (NumberFormatException e){
					    						System.out.println("Assembler ERROR: Argument is not a numerical.");
					    						System.out.println("Assembler Error occurs at line " + lineCounter + ": " + line);
					    						goodProgram = false;
					    					}
				    					}
				    				}
				    			}
				    			else{
				    				System.out.println("Assembler ERROR: Instruction does not exist.");
				    				System.out.println("Assembler Error occurs at line " + lineCounter + ": " + line);
				    				goodProgram = false;
				    			}
				    		}
				    		
				    		else if(opcode.containsKey(parts[0])){
				    			code = opcode.get(parts[0]);
			    				outp.println(code*4);
				    			if(noArgument.contains(parts[0])){
				    				if(parts.length > 1){
				    					System.out.println("Assembler ERROR: Too many arguments.");
			    						System.out.println("Assembler Error occurs at line " + lineCounter + ": " + line);
			    						goodProgram = false;
				    				}
				    				else{
				    					outp.println(0);
				    				}
				    			}
				    			
				    			else{
				    				if(parts.length > 2){
			    						System.out.println("Assembler ERROR: Too many arguments.");
			    						System.out.println("Assembler Error occurs at line " + lineCounter + ": " + line);
			    						goodProgram = false;
			    					}
			    					else if(parts.length == 1){
			    						System.out.println("Assembler ERROR: Not enough arguments.");
			    						System.out.println("Assembler Error occurs at line " + lineCounter + ": " + line);
			    						goodProgram = false;
			    					} else{
					    				
			    						try{
				    						int num = Integer.parseInt(parts[1], 16);
				    						outp.println(num);
				    					} catch (NumberFormatException e){
				    						System.out.println("Assembler ERROR: Argument is not numerical.");
				    						System.out.println("Assembler Error occurs at line " + lineCounter + ": " + line);
				    						goodProgram = false;
				    					}
			    					}
				    			}
				    		}
				    		else{
				    			System.out.println("Error: Instruction does not exist or data appears before DATA.");
				    			System.out.println("Assembler Error occurs at line " + lineCounter + ": " + line);
				    			goodProgram = false;
				    		}
				    			
					    }
				    	else if (!line.trim().equals("DATA")){
				    		if(opcode.containsKey(parts[0])){
				    			System.out.println("Assembler ERROR: Code appears after data.");
				    			System.out.println("Assembler Error occurs at line " + lineCounter + ": " + line);
				    			goodProgram = false;
				    		}
				    		else if(parts.length == 2){
				    			try{
				    				outp.println(Integer.parseInt(parts[0],16));
						    		outp.println(Integer.parseInt(parts[1],16));
				    			} catch (NumberFormatException e){
				    				System.out.println("Assembler ERROR: Data is not a number pair.");
				    				System.out.println("Assembler Error occurs at line " + lineCounter + ": " + line);
				    				goodProgram = false;
				    			}
				    		}
				    		else{
					    		System.out.println("Assembler ERROR: Data is not a number pair.");
			    				System.out.println("Assembler Error occurs at line " + lineCounter + ": " + line);
			    				goodProgram = false;
					    			
				    		}
				    	}
			    	}
		    	}
		    } //end of while loop
		    inp.close();
		    outp.close();
		} catch (IOException e){
		    System.out.println("Unable to open the necessary files");
		}
		if(!goodProgram && output != null && output.exists()) {
		    output.delete();
		}
		return goodProgram;
	}
}
