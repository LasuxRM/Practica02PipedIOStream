package piped_io_Stream;

import java.io.*;
import java.util.*;
//import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		
//		Line	linea01		= new Line(0,5);
//		Line	lineafinal	= new Line(0,0);
		int[]	NumberSet	= new int[5];
		int[]	NumberSetSorted	= new int[NumberSet.length];
/*		
		System.out.println("Enter five numbers");
		for (int i=0; i<5; i++) {
			NumberSet[i] = sc.nextInt();
		}
		//int a=System.in.read();
*/		
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
	    
	    //hilo01.start();
	   // hilo02.start();
	    
//Segunda parte
	    
	    int[] DotInA = new int[3];
	    int[] DotInB = new int[3];
	    
	    Line linea0 = new Line(null, null);
	    
	    System.out.println("Creando línea");
	    for(int i=0; i<3; i++) {
		    System.out.print("Ingrese coordenada "+(i+1)+" del punto A: ");
		    DotInA[i] = sc.nextInt();
	    }
	    linea0.setPuntoA(DotInA);
	    
	    for(int i=0; i<3; i++) {
		    System.out.print("Ingrese coordenada "+(i+1)+" del punto B: ");
		    DotInB[i] = sc.nextInt();
	    }
	    linea0.setPuntoB(DotInB);
	    
	    /*
	    System.out.println("Trasladando");
	    System.out.print("Escoger eje: ");
	    er = sc.nextLine();
	    System.out.print("Cantidad de unidades a desplazar: ");
	    unidades = sc.nextInt();
	    
	   */
	    
	    System.out.println("Imprimiendo nuevo vector");

	    System.out.print("(");
	    for(int i=0; i<3; i++) {
		    System.out.print(linea0.getPuntoA()[i]);
	    }
	    System.out.print(")\n(");
	    for(int i=0; i<3; i++) {
		    System.out.print(linea0.getPuntoB()[i]);
	    }
	    System.out.println(")");
	}
}
