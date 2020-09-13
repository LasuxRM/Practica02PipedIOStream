package move_rotate_resize;

import java.util.*;

public class MoveRotateResize3D {

	public static void main(String[] args) {
		
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
