package piped_io_Stream;

import java.io.*;
import java.util.*;

public class main {

	public static void main(String[] args) throws IOException{
		
		Line	linea01		= new Line(0,5);
		Line	lineafinal	= new Line(0,0);
		int[]	ConjNumbers	= new int[] {5,1,4,2,3};
		int[]	ConjNumReception	= new int[ConjNumbers.length];
				
		PipedInputStream	pins	= new PipedInputStream(); 
	    PipedOutputStream	pouts	= new PipedOutputStream();
	    
	    pouts.connect(pins);
	    
	    Thread hilo01	= new Thread() {
	    	public void run() {
	    		
	    		try {
	    			for(int i=0; i<ConjNumbers.length; i++) {
	    				
	    				//pouts.write(linea01.getEjeX());
	    				
	    				pouts.write(ConjNumbers[i]);
	    				System.out.println("PipedOutputStream escribiendo ConjNumbers["+i+"]="+ConjNumbers[i]);
	    				Thread.sleep(2000);
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
	    				System.out.println("PipedInputStream Leyendo j="+j);
	    				ConjNumReception[n]=j;
	    				n++;
	    			}
	    			pins.close();
	    			
	    		}catch(Exception e) {
	    			System.out.println(e);
	    		}
	    		
	    		Arrays.sort(ConjNumReception);
	    		for(int k=0; k<ConjNumReception.length; k++) {
	    			
	    	    	System.out.print(ConjNumReception[k]);
	    	    }
	    		System.out.print("\n");
	    		for(int k=ConjNumReception.length-1; k>-1; k--) {
	    			
	    	    	System.out.print(ConjNumReception[k]);
	    	    }
	    	}
	    };
	    
	    hilo01.start();
	    hilo02.start();
	    
	    
	    
	}

}
