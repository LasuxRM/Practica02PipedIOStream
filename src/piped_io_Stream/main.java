package piped_io_Stream;

import java.io.*;
import java.lang.reflect.Array;

public class main {

	public static void main(String[] args) throws IOException{
		
		Line	linea01		= new Line(0,5);
		Line	lineafinal	= new Line(0,0);
		int[]	ConjNumbers	= new int[] {5,1,4,2,3};
				
		PipedInputStream	pins	= new PipedInputStream(); 
	    PipedOutputStream	pouts	= new PipedOutputStream();
	    
	    pouts.connect(pins);
	    
	    Thread hilo01	= new Thread() {
	    	public void run() {
	    		
	    		try {
	    			for(int i=50; i<=60; i++) {
	    				
	    				pouts.write(linea01.getEjeX());
	    				
	    				pouts.write(i);
	    				System.out.println("PipedOutputStream escribiendo i="+i);
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
	    			int j;
	    			while((j = pins.read()) != -1) {
	    				System.out.println("PipedInputStream Leyendo j="+j);
	    			}
	    			pins.close();
	    			
	    		}catch(Exception e) {
	    			System.out.println(e);
	    		}
	    		
	    	}
	    };
	    
	    hilo01.start();
	    hilo02.start();
	}

}
