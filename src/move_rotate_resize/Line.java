package move_rotate_resize;

import java.io.Serializable;

public class Line implements Serializable{
	
	private int[] puntoA = new int[3];
	private int[] puntoB = new int[3];
	
	public Line(int[] puntoA, int[] puntoB) {
		super();
		this.puntoA = puntoA;
		this.puntoB = puntoB;
	}
	
	
	public void PrintVector() {
		
		System.out.print("(");
 	    for(int i=0; i<3; i++) {
 	    	if(i<2) {
 	    		System.out.print(getPuntoA()[i] + "-");
 	    	}else {
 	    		System.out.print(getPuntoA()[i]);
 	    	}
 	    }
 	    System.out.print(")\n(");
 	    
 	    for(int i=0; i<3; i++) {
 	    	if(i<2) {
 	    		System.out.print(getPuntoB()[i] + "-");
 	    	}else {
 	    		System.out.print(getPuntoB()[i]);
 	    	} 	    }
 	    System.out.println(")");
	}
	

	public int[] getPuntoA() {
		return puntoA;
	}
	public void setPuntoA(int[] puntoA) {
		this.puntoA = puntoA;
	}

	public int[] getPuntoB() {
		return puntoB;
	}
	public void setPuntoB(int[] puntoB) {
		this.puntoB = puntoB;
	}
}
