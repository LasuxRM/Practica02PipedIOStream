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
		Point3D lp1 = new Point3D(0,0,0);	//line segment first point = A
		Point3D lp2 = new Point3D(5,5,5);	//line segment second point = B
		
		
		FileOutputStream file = null;
	    try {
	    	
	    	file = new FileOutputStream("console.txt");
		    
	    	ObjectOutputStream oos = new ObjectOutputStream(file);
	    	
	    	System.out.println("---------Second activity---------");
			System.out.println("Hello human, lets create a line!");
			System.out.println("To continue, please enter an");
			System.out.println("Axis x, Axis y, Axis z respectively");
			lp2.setAxisX(sc.nextInt());
		    lp2.setAxisY(sc.nextInt());
		    lp2.setAxisZ(sc.nextInt());
		
		    System.out.println("So, there is a directed line segments");
		    System.out.println("with this properties:");
		    System.out.print("Point A = " );	lp1.printP3D();
		    System.out.print("Point B = " );	lp2.printP3D();
		    System.out.println("Magnitude: ");	System.out.println(lp2.getMagnitude());
		    System.out.println("Direction: ");	lp2.getDirection();
	    	
		    oos.writeObject(lp1);
		    oos.writeObject(lp2);

		    
		    
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
	    	

				//To translate the line segment
			    System.out.println("Define the translation vector <t> ");
			    System.out.println("Enter Axis x, Axis y, Axis z respectively:"); 
			    int tx = sc.nextInt();
			    int ty = sc.nextInt();
			    int tz = sc.nextInt();
			    Point3D t = new Point3D(tx,ty,tz);
			    System.out.print("Defining <t>... T = ");
			    t.printP3D();
			   
			    
			    System.out.println("Point A: ");
			    Point3D lp11 = new Point3D(1,1,1);
			    lp11 = (Point3D) ois.readObject();
			    lp11.translate(lp11, t);
			    
			    System.out.println("Point B:");
			    Point3D lp22 = new Point3D(6,6,6);
			    lp22 = (Point3D) ois.readObject();
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
		
	    
	}

}
