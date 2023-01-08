import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CoorCuadradoMain extends JPanel {

	private int x1;
	private int x2;
	private int x3;
	private int x4;
	private int y1;
	private int y2;
	private int y3;
	private int y4;
	
	private int ladoMedida;
	
	private int x1N;
	private int x2N;
	private int x3N;
	private int x4N;
	private int y1N;
	private int y2N;
	private int y3N;
	private int y4N;
	
	private int angulo;
	
	public CoorCuadradoMain(int ladoMedida, int x1, int y1) {
		super();
		
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x1;
		this.y2 = y1 + ladoMedida;
		this.x3 = x1 + ladoMedida;
		this.y3 = y1;
		this.x4 = x1 + ladoMedida;
		this.y4 = y1 + ladoMedida;
		
		this.ladoMedida = ladoMedida;
		
		System.out.println(this.toString());
		
		Timer timer = new Timer(10, e -> repaint());
		timer.start();
	}

	public int calculaXprima(int x, int y, Double anguloRad) {
		
		Double xp = x * Math.cos(anguloRad) - y * Math.sin(anguloRad); 
		
		return xp.intValue();
	}

	public int calculaYprima(int x, int y, Double anguloRad) {
		
		Double yp = x * Math.sin(anguloRad) + y * Math.cos(anguloRad); 
		
		return yp.intValue();
		
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		

		System.out.println("Angulo: " + angulo);
		Double anguloRad = (angulo * (Math.PI / 180));
		System.out.println("Angulo en radianes: " + anguloRad);
					
		this.x1N = calculaXprima(x1, y1, anguloRad) + ladoMedida;
		this.y1N = calculaYprima(x1, y1, anguloRad) + ladoMedida;
		this.x2N = calculaXprima(x2, y2, anguloRad) + ladoMedida;
		this.y2N = calculaYprima(x2, y2, anguloRad) + ladoMedida;
		this.x3N = calculaXprima(x3, y3, anguloRad) + ladoMedida;
		this.y3N = calculaYprima(x3, y3, anguloRad) + ladoMedida;
		this.x4N = calculaXprima(x4, y4, anguloRad) + ladoMedida;
		this.y4N = calculaYprima(x4, y4, anguloRad) + ladoMedida;
		
		System.out.println(this.toString());
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setBackground(Color.BLUE);
		g2d.setColor(Color.BLUE);
		int[] xPoints = { x1N, x2N, x3N, x4N };
		int[] yPoints = { y1N, y2N, y3N, y4N };
		g2d.drawPolygon(xPoints, yPoints, 4); // Dibujamos el cuadrado
				
		angulo++;
		
		if (angulo == 361) 
			angulo = 0;
	}
	
	@Override
	public String toString() {
		return "Coordenadas: [(" + x1N + "," + y1N + "), (" + x2N + "," + y2N + "), (" + x3N + "," + y3N + "), (" + x4N + ","
				+ y4N + ")]";
	}
	
	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		System.out.println("Ingresar Distancia Lado: ");
		Integer ladoMedida = in.nextInt();
		System.out.println("Distancia Lado: " + ladoMedida);

		Integer xIni = -(ladoMedida)/2;
		Integer yIni = -(ladoMedida)/2;
		
		in.close();

		JFrame frame = new JFrame();
		frame.setSize(1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new CoorCuadradoMain(ladoMedida, xIni, yIni));
		frame.setVisible(true);
	}
	
	
}