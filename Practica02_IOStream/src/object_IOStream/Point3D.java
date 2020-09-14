package object_IOStream;

import java.io.Serializable;
import java.util.Scanner;

public class Point3D implements Serializable {
	
	private int axisX;
	private int axisY;
	private int axisZ;
	private double m;	//magnitude
	private double d;	//direction
	
	
	public Point3D(int x, int y, int z) {
		super();
		this.axisX = x;
		this.axisY = y;
		this.axisZ = z;
		this.m = Math.pow((axisX*axisX)+(axisY*axisY)+(axisZ*axisZ),0.5);
		
	}
	public int getAxisX() {
		return axisX;
	}

	public void setAxisX(int axisX) {
		this.axisX = axisX;
	}

	public int getAxisY() {
		return axisY;
	}

	public void setAxisY(int axisY) {
		this.axisY = axisY;
	}

	public int getAxisZ() {
		return axisZ;
	}

	public void setAxisZ(int axisZ) {
		this.axisZ = axisZ;
	}
	public void printP3D() {
		System.out.println("["+ axisX +","+ axisY +","+ axisZ +"]");
	}
	
	public double getMagnitude() {
		return m;
	}
	public void getDirection() {
		double xd = axisX/m;
		double yd = axisY/m;
		double zd = axisZ/m;
		System.out.println("["+ xd +","+ yd +","+ zd +"]");
			
	}
	public void translate(Point3D originP,Point3D traslateP) {
		originP.axisX = originP.axisX + traslateP.axisX;
		originP.axisY = originP.axisY + traslateP.axisY;
		originP.axisZ = originP.axisZ + traslateP.axisZ;
		System.out.println("The new line position after translate it, is:");
		originP.printP3D();
	}
	public void rotate(Point3D p, boolean x, boolean y, boolean z) {
		if(x) {p.axisX = -p.axisX;} 
		if(y) {p.axisY = -p.axisY;}	
		if(z) {p.axisZ = -p.axisZ;}
		System.out.println("The new line position after rotate it, is:");
		p.printP3D();
	}
	public void scale(Point3D p, int s) {
		p.axisX = p.axisX * s;
		p.axisY = p.axisY * s;
		p.axisZ = p.axisZ * s;
		System.out.println("The new line position after scale it, is:");
		p.printP3D();
	}

}
