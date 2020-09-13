package piped_io_Stream;

public class Line {
	
	private int[] puntoA = new int[3];
	private int[] puntoB = new int[3];
	
	public Line(int[] puntoA, int[] puntoB) {
		super();
		this.puntoA = puntoA;
		this.puntoB = puntoB;
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
