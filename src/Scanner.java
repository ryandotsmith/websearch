/**
 * Scanner class that scans through an input file returning the tokens
 * To use:
 *    Call the constructor Scanner(filename, Scanner.SCANFILE) with the name of 
 *    the file to scan, then call getNextToken() to get the next token in the 
 *    file 
 *    a token is either (1) a single non-alphabetic and non-numeric character 
 *    or (2) a String of contiguous alphabetic and numberic characters up until
 *    either a white space character(s) or a token of the first type 
 *    to test if there are any more tokens call atEndOfFile() 
 *    
 *    To scan a String for tokens call the constructor:
 *		 Scanner(inputString, Scanner.SCANSTRING)    
 *
 * @author Tia Newhall
 *
 * Copyright (c) 2000 Tia Newhall, Lisa Meeden
 */
import java.lang.*;
import java.util.*;
import java.io.*;


public class Scanner {

    private StreamTokenizer fstream;
    /** Specifies that the Scanner is tokenizing a file **/ 
    public static int SCANFILE   = 0;
    /** Specifies that the Scanner is tokenizing a string **/ 
    public static int SCANSTRING = 1;

    /**
     * Constructor takes input string representing either a file name or
     * a string to parse, and one of either SCANFILE or SCANSTRING and
     * and initializes the scanner 
     */
    public Scanner(String line, int isfile) throws FileNotFoundException {
	if(isfile == SCANFILE) {
	    File fd = new File(line);
            if(!fd.exists()) {
                throw new FileNotFoundException("no such file: " + line);
            }
            fstream = new StreamTokenizer(
                        new BufferedReader(new InputStreamReader(
                                               new FileInputStream(fd))));
	} else {
	    fstream = new StreamTokenizer(new StringReader(line));	
	}
	InitTokenizer(fstream);
    }

     private void InitTokenizer(StreamTokenizer fstream) {
	fstream.resetSyntax();
	fstream.wordChars('a','z'); fstream.wordChars('A','Z');
	fstream.wordChars('0','9'); fstream.whitespaceChars('\t','\t');
	fstream.whitespaceChars(' ',' ');   fstream.whitespaceChars('\n','\n');
	fstream.whitespaceChars('\b','\b'); fstream.whitespaceChars('\r','\r');
	fstream.whitespaceChars('\f','\f'); fstream.whitespaceChars('\f','\f');
	fstream.ordinaryChar('\\'); fstream.ordinaryChar('/');
	fstream.ordinaryChar('<');  fstream.ordinaryChar('>');
	fstream.ordinaryChar('?');  fstream.ordinaryChar(':');
	fstream.ordinaryChar(';');  fstream.ordinaryChar('"');
	fstream.ordinaryChar('\''); fstream.ordinaryChar('~');
	fstream.ordinaryChar('`');  fstream.ordinaryChar('@');
	fstream.ordinaryChar('#');  fstream.ordinaryChar('$');
	fstream.ordinaryChar('%');  fstream.ordinaryChar('^');
	fstream.ordinaryChar('&');  fstream.ordinaryChar('*');
	fstream.ordinaryChar('(');  fstream.ordinaryChar(')');
	fstream.ordinaryChar('-');  fstream.ordinaryChar('_');
	fstream.ordinaryChar('+');  fstream.ordinaryChar('=');
	fstream.ordinaryChar('{');  fstream.ordinaryChar('[');
	fstream.ordinaryChar('}');  fstream.ordinaryChar(']');
	fstream.ordinaryChar('|');  fstream.ordinaryChar('.');
	fstream.ordinaryChar(',');
    }

    /**
     * return true when there are no more tokens in the file or string
     * @return true when there are no more tokens in the file or string
     */
    public boolean atEndOfFile() throws IOException {
	int token = fstream.nextToken();
	fstream.pushBack();
	if(token == StreamTokenizer.TT_EOF) {
	    return true;
        } else { 
	   return false;
	}
    }

    /**
     * return the next token in the file or string
     * @return the next token in the file or string
     */
    public String getNextToken() throws IOException {
	fstream.nextToken();
	if(fstream.ttype == StreamTokenizer.TT_NUMBER )
	   return (Double.toString(fstream.nval)); 
	else if (fstream.ttype == StreamTokenizer.TT_WORD)
	   return(fstream.sval);
	else 
	   return ((new Character((char)fstream.ttype)).toString());

    }
}
