package move_rotate_resize;

import java.util.*;

public class MoveRotateResize3D {

	public static void main(String[] args) {
		
		int unidades;
		
		Scanner sc = new Scanner(System.in);

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
	    
	    

	    
	    System.out.println("Trasladando");
//	    System.out.print("Escoger eje: ");
//	    er = sc.nextLine();
	    System.out.print("Cantidad de unidades a desplazar: ");
	    unidades = sc.nextInt();
	    
	    for(int i=0; i<3; i++) {
	    	DotInA[i] = DotInA[i] + unidades;
	    }
    	linea0.setPuntoA(DotInA);

	    
	    for(int i=0; i<3; i++) {
	    	DotInB[i] = DotInB[i] + unidades;
	    }
    	linea0.setPuntoB(DotInB);

	   

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
