/**
 * A class for testing the Scanner class
 *
 * @author Tia Newhall
 *
 * Copyright (c) 2000 Tia Newhall, Lisa Meeden
 */ 


import java.lang.*;
import java.io.*;

public class Test {


    public static void main (String args[]) {

		try {
			if (args.length != 1) {
	               System.err.println("usage: java TextScanner1"
	                 + "file location");
	               System.exit(0);
	        }
	        
		    Scanner scanner = new Scanner(args[0], Scanner.SCANFILE);
		    int count = 0;
		    while(!scanner.atEndOfFile()) {
			count++;	
			String token = scanner.getNextToken();
		        System.out.println("the "+count+"th token is #" + token + "#");
		    }
		} catch (FileNotFoundException e) {
		    System.out.println(e);
		} catch (IOException e) {
		    System.out.println(e);
		}
    }
}
