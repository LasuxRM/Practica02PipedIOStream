package piped_io_Stream;

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		

		int[]	NumberSet	= new int[5];
		int[]	NumberSetSorted	= new int[NumberSet.length];
				
		System.out.println("--------First activity--------");
		System.out.println("Enter five numbers");
		for (int i=0; i<5; i++) {
			NumberSet[i] = sc.nextInt();
		}
		
		
		PipedInputStream	pins	= new PipedInputStream(); 
	    PipedOutputStream	pouts	= new PipedOutputStream();
	    
	    pouts.connect(pins);
	    
	    Thread hilo01	= new Thread() {
	    	public void run() {
	    		
	    		try {
	    			for(int i=0; i<NumberSet.length; i++) {
	    					    				
	    				pouts.write(NumberSet[i]);
	    				System.out.println("PipedOutputStream writing NumberSet["+i+"]="+NumberSet[i]);
	    				Thread.sleep(1000);
	    			}
	    			pouts.close();
	    			
	    		}catch(Exception e) {
	    			System.out.println(e);
	    		}
	    		
	    	}
	    };
	    
	    Thread hilo02	= new Thread() {
	    	public void run() {
	    		
	    		try {
	    			int n=0,j;
	    			while((j = pins.read()) != -1) {
	    				System.out.println("PipedInputStream reading j="+j);
	    				NumberSetSorted[n]=j;
	    				n++;
	    			}
	    			pins.close();
	    			
	    		}catch(Exception e) {
	    			System.out.println(e);
	    		}
	    		
	    		//Sorting
	    		Arrays.sort(NumberSetSorted);
	    		
	    		//Showing sorted set
	    		for(int k=0; k<NumberSetSorted.length; k++) {
	    	    	System.out.print(NumberSetSorted[k]);
	    	    }
	    		
	    		//Showing inverted sorted set
	    		System.out.print("\n");
	    		for(int k=NumberSetSorted.length-1; k>-1; k--) {
	    			
	    	    	System.out.print(NumberSetSorted[k]);
	    	    }
	    	}
	    };
	    
	    hilo01.start();
	    hilo02.start();
	    
	    
	}

}
