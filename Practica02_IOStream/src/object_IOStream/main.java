package object_IOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

//import move_rotate_resize.Line;

public class main {

	public static void main(String[] args) {// throws IOException{
		
		Scanner sc = new Scanner(System.in);
		
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		
		Point33D lp1 = new Point33D(0,0,0);	//line segment first point = A
		Point33D lp2 = new Point33D(5,5,5);	//line segment second point = B
//		Point3D[]	DataSet = new Point3D[4];
//		Point3D[] 	ResultSet = new Point3D[3];
		
		
		
		FileOutputStream file = null;
	    try {
	    	
	    	file = new FileOutputStream("console.txt");
		    
	    	ObjectOutputStream oos = new ObjectOutputStream(file);
	    	
	    	System.out.println("---------Second activity---------");
			System.out.println("Hello human, lets create a line!");
			System.out.println("To continue, please enter an");
			System.out.println("Axis x, Axis y, Axis z respectively");
			lp2.setAxisX(sc1.nextInt());
		    lp2.setAxisY(sc2.nextInt());
		    lp2.setAxisZ(sc3.nextInt());
		
		    System.out.println("So, there is a directed line segments");
		    System.out.println("with this properties:");
		    System.out.print("Point A = " );	lp1.printP3D();
		    System.out.print("Point B = " );	lp2.printP3D();
		    System.out.println("Magnitude: ");	System.out.println(lp2.getMagnitude());
		    System.out.println("Direction: ");	lp2.getDirection();
	    	
		    oos.writeObject(lp1);
		    oos.writeObject(lp2);
//		    oos.writeObject(lp1.getAxisX());
//		    oos.writeObject(lp1.getAxisY());
//		    oos.writeObject(lp1.getAxisZ());
//		    oos.writeObject(lp2.getAxisX());
//		    oos.writeObject(lp2.getAxisY());
//		    oos.writeObject(lp2.getAxisZ());
		    
//	    	System.out.println("Creando línea");
//		    for(int i=0; i<3; i++) {
//			    System.out.print("Ingrese coordenada "+(i+1)+" del punto A: ");
//			    DotInA[i] = sc.nextInt();
//			    lp1.setAxisX(sc.nextInt());
//			    //dos.writeInt(DotInA[i]);
//		    }
//		    linea0.setPuntoA(DotInA);
		    //oos.writeObject(linea0);
		   
		    
//		    for(int i=0; i<3; i++) {
//			    System.out.print("Ingrese coordenada "+(i+1)+" del punto B: ");
//			    DotInB[i] = sc.nextInt();
//		    }
//		    linea0.setPuntoB(DotInB);
//		    oos.writeObject(linea0);
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
	    	
//	    	LINE OBJECTRECEPTION = NEW LINE(NULL, NULL);
//	    	ObjectReception = (Line) ois.readObject();
	    	
//	    	//for (int i = 0; i < 6; i++) {
//				System.out.println(ObjectReception.getAxisX());
//				System.out.println(ObjectReception.getAxisY());
//				System.out.println(ObjectReception.getAxisZ());
//				
//				System.out.println(ObjectReception.getPuntoB()[0]);
//				System.out.println(ObjectReception.getPuntoB()[1]);
//				System.out.println(ObjectReception.getPuntoB()[2]);
//
//			//}
				//To translate the line segment
			    System.out.println("Define the translation vector <t> ");
			    System.out.println("Enter Axis x, Axis y, Axis z respectively:"); 
			    int tx = sc.nextInt();
			    int ty = sc.nextInt();
			    int tz = sc.nextInt();
			    Point33D t = new Point33D(tx,ty,tz);
			    System.out.print("Defining <t>... T = ");
			    t.printP3D();
			   
			    
			    System.out.println("Point A: ");
			    Point33D lp11 = new Point33D(1,1,1);
			    lp11 = (Point33D) ois.readObject();
			    lp11.translate(lp11, t);
			    
			    System.out.println("Point B:");
			    Point33D lp22 = new Point33D(6,6,6);
			    lp22 = (Point33D) ois.readObject();
			    lp22.translate(lp22, t);
//			    lp2.translate(lp2,t);
			    
			    //To rotate the line segment
			    System.out.println("Now, define wich axis's gonna rotate");
			    System.out.println("Enter true/false to Axis x, Axis y, Axis z respectively:"); 
			    boolean rx = sc.nextBoolean();
			    boolean ry = sc.nextBoolean();
			    boolean	rz = sc.nextBoolean();
			    lp2.rotate(lp2, rx, ry, rz);
			    
			    //To scale the line segment
			    System.out.println("Finaly, Define the scaling number <s> to set the line ");
			    int s = sc.nextInt();
			    lp2.scale(lp2, s);
	    	
		} catch (IOException e) {
			System.out.println("Error E/S");
			e.printStackTrace();
		} 
	    catch (ClassNotFoundException e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
//		System.out.println("---------Second activity---------");
//		System.out.println("Hello human, lets create a line!");
//		System.out.println("To continue, please enter an");
//		System.out.println("Axis x, Axis y, Axis z respectively");
//		lp2.setAxisX(sc.nextInt());
//	    lp2.setAxisY(sc.nextInt());
//	    lp2.setAxisZ(sc.nextInt());
//	
//	    System.out.println("So, there is a directed line segments");
//	    System.out.println("with this properties:");
//	    System.out.print("Point A = " );	lp1.printP3D();
//	    System.out.print("Point B = " );	lp2.printP3D();
//	    System.out.println("Magnitude: ");	System.out.println(lp2.getMagnitude());
//	    System.out.println("Direction: ");	lp2.getDirection();
	    
//	    //To translate the line segment
//	    System.out.println("Define the translation vector <t> ");
//	    System.out.println("Enter Axis x, Axis y, Axis z respectively:"); 
//	    int tx = sc.nextInt();
//	    int ty = sc.nextInt();
//	    int tz = sc.nextInt();
//	    Point3D t = new Point3D(tx,ty,tz);
//	    System.out.print("Defining <t>... T = ");
//	    t.printP3D();
//	    System.out.println();
//	    System.out.println("Point A = ");
//	    lp1.translate(lp1, t);
//	    System.out.println("Point B = ");
//	    lp2.translate(lp2,t);
//	    
//	    //To rotate the line segment
//	    System.out.println("Now, define wich axis's gonna rotate");
//	    System.out.println("Enter true/false to Axis x, Axis y, Axis z respectively:"); 
//	    boolean rx = sc.nextBoolean();
//	    boolean ry = sc.nextBoolean();
//	    boolean	rz = sc.nextBoolean();
//	    lp2.rotate(lp2, rx, ry, rz);
//	    
//	    //To scale the line segment
//	    System.out.println("Finaly, Define the scaling number <s> to set the line ");
//	    int s = sc.nextInt();
//	    lp2.scale(lp2, s);
	    
	    
	    
	    
	    
	    
	    
	    
	    
	//--------    
	    

//		Scanner sc = new Scanner(System.in);
//
//	    int[] DotInA = new int[3];
//	    int[] DotInB = new int[3];
//	    
//	    Line linea0 = new Line(null, null);
//	    
//	    
//	    
//	    
//	    
//	    
//	    
//	    
//	    
//	    System.out.println("Imprimiendo nuevo vector");
//
//	    linea0.PrintVector();
//	    
//
//	    
//	    System.out.println("Trasladando");
////	    System.out.print("Escoger eje: ");
////	    er = sc.nextLine();
//	    System.out.print("Cantidad de unidades a desplazar: ");
//	    unidades = sc.nextInt();
//	    
//	    for(int i=0; i<3; i++) {
//	    	DotInA[i] = DotInA[i] + unidades;
//	    }
//    	linea0.setPuntoA(DotInA);
//
//	    
//	    for(int i=0; i<3; i++) {
//	    	DotInB[i] = DotInB[i] + unidades;
//	    }
//    	linea0.setPuntoB(DotInB);
//
//	   
//
//    	 System.out.println("Imprimiendo nuevo vector");
// 	    
// 	    linea0.PrintVector();
//	    
	 
	    
	}

}
