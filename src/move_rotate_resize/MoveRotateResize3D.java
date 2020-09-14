package move_rotate_resize;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class MoveRotateResize3D {

	public static void main(String[] args) {
		
		int unidades;
		
		Scanner sc = new Scanner(System.in);

	    int[] DotInA = new int[3];
	    int[] DotInB = new int[3];
	    
	    Line linea0 = new Line(null, null);
	    FileOutputStream file = null;
	    try {
	    	
	    	file = new FileOutputStream("console.txt");
		    
	    	ObjectOutputStream oos = new ObjectOutputStream(file);
	    	
	    	System.out.println("Creando línea");
		    for(int i=0; i<3; i++) {
			    System.out.print("Ingrese coordenada "+(i+1)+" del punto A: ");
			    DotInA[i] = sc.nextInt();
			    //dos.writeInt(DotInA[i]);
		    }
		    linea0.setPuntoA(DotInA);
		    //oos.writeObject(linea0);
		   
		    
		    for(int i=0; i<3; i++) {
			    System.out.print("Ingrese coordenada "+(i+1)+" del punto B: ");
			    DotInB[i] = sc.nextInt();
		    }
		    linea0.setPuntoB(DotInB);
		    oos.writeObject(linea0);
		    /*
		    oos.writeInt(linea0.getPuntoB()[0]);
		    oos.writeInt(linea0.getPuntoB()[1]);
		    oos.writeInt(linea0.getPuntoB()[2]);
	    	*/
		    
		    
		}catch(FileNotFoundException e1){
			System.out.println(101);
			e1.printStackTrace();
		}
	    catch (IOException e2) {
	    	System.out.println(202);
	    	e2.printStackTrace();
	    }finally {
			try {
				file.close();
			} catch (IOException e3) {
				System.out.println(303);
				e3.printStackTrace();
			}
		}
	    
	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("console.txt"));){
	    	
	    	Line ObjectReception = new Line(null, null);
	    	ObjectReception = (Line) ois.readObject();
	    	
	    	//for (int i = 0; i < 6; i++) {
				System.out.println(ObjectReception.getPuntoA()[0]);
				System.out.println(ObjectReception.getPuntoA()[1]);
				System.out.println(ObjectReception.getPuntoA()[2]);
				
				System.out.println(ObjectReception.getPuntoB()[0]);
				System.out.println(ObjectReception.getPuntoB()[1]);
				System.out.println(ObjectReception.getPuntoB()[2]);

			//}
	    	
		} catch (IOException e) {
			System.out.println("Error E/S");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		}
	    
	    
	    
	    
	    
	    System.out.println("Imprimiendo nuevo vector");

	    linea0.PrintVector();
	    

	    
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
 	    
 	    linea0.PrintVector();
	}

}
