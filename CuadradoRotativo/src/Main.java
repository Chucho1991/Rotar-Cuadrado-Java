import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		System.out.println("Ingresar Distancia Lado: ");
		BigDecimal ladoMedida = in.nextBigDecimal();
		System.out.println("Distancia Lado: " + ladoMedida);

		System.out.println("Ingresar Coordenada X Inicial: ");
		BigDecimal xIni = in.nextBigDecimal();
		System.out.println("X Inicial: " + xIni);

		System.out.println("Ingresar Coordenada Y Inicial: ");
		BigDecimal yIni = in.nextBigDecimal();
		System.out.println("Y Inicial: " + yIni);

		CoorCuadrado coordenadas = new CoorCuadrado(ladoMedida, xIni, yIni);
		CoorCuadrado coordenadasINI = new CoorCuadrado(ladoMedida, xIni, yIni);
		System.out.println(coordenadas.toString());

		for (Integer i = 1; i <= 360; i++) {
			System.out.println("");
			System.out.println("================ANGULO " + i + "================");
			coordenadas.getCoorCuadradoRotacion(i, coordenadasINI);
			CoorCuadrado coordenadasGiro = coordenadas;
			System.out.println(coordenadasGiro.toString());
			System.out.println("==========================================");
		}

		in.close();
	}
}

class CoorCuadrado {

	private BigDecimal x1;
	private BigDecimal x2;
	private BigDecimal x3;
	private BigDecimal x4;
	private BigDecimal y1;
	private BigDecimal y2;
	private BigDecimal y3;
	private BigDecimal y4;

	public CoorCuadrado() {
		super();
	}

	@SuppressWarnings("deprecation")
	public CoorCuadrado(BigDecimal ladoMedida, BigDecimal x1, BigDecimal y1) {
		super();
		this.x1 = x1.setScale(4, BigDecimal.ROUND_HALF_UP);
		this.y1 = y1.setScale(4, BigDecimal.ROUND_HALF_UP);
		this.x2 = x1.setScale(4, BigDecimal.ROUND_HALF_UP);
		this.y2 = y1.add(ladoMedida).setScale(4, BigDecimal.ROUND_HALF_UP);
		this.x3 = x1.add(ladoMedida).setScale(4, BigDecimal.ROUND_HALF_UP);
		this.y3 = y1.setScale(4, BigDecimal.ROUND_HALF_UP);
		this.x4 = x1.add(ladoMedida).setScale(4, BigDecimal.ROUND_HALF_UP);
		this.y4 = y1.add(ladoMedida).setScale(4, BigDecimal.ROUND_HALF_UP);
	}

	@SuppressWarnings("deprecation")
	public void getCoorCuadradoRotacion(Integer angulo, CoorCuadrado cc ) {

		Double anguloRad = (angulo * (Math.PI / 180));
		System.out.println("Angulo en radianes: " + anguloRad);

		this.x1 = calculaXprima(cc.getX1(), cc.getY1(), anguloRad).setScale(4, BigDecimal.ROUND_HALF_UP);
		this.y1 = calculaYprima(cc.getX1(), cc.getY1(), anguloRad).setScale(4, BigDecimal.ROUND_HALF_UP);
		this.x2 = calculaXprima(cc.getX2(), cc.getY2(), anguloRad).setScale(4, BigDecimal.ROUND_HALF_UP);
		this.y2 = calculaYprima(cc.getX2(), cc.getY2(), anguloRad).setScale(4, BigDecimal.ROUND_HALF_UP);
		this.x3 = calculaXprima(cc.getX3(), cc.getY3(), anguloRad).setScale(4, BigDecimal.ROUND_HALF_UP);
		this.y3 = calculaYprima(cc.getX3(), cc.getY3(), anguloRad).setScale(4, BigDecimal.ROUND_HALF_UP);
		this.x4 = calculaXprima(cc.getX4(), cc.getY4(), anguloRad).setScale(4, BigDecimal.ROUND_HALF_UP);
		this.y4 = calculaYprima(cc.getX4(), cc.getY4(), anguloRad).setScale(4, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal calculaXprima(BigDecimal x, BigDecimal y, Double anguloRad) {
		return (x.multiply(new BigDecimal(Math.cos(anguloRad))))
				.subtract(y.multiply(new BigDecimal(Math.sin(anguloRad))));
	}

	public BigDecimal calculaYprima(BigDecimal x, BigDecimal y, Double anguloRad) {
		return (x.multiply(new BigDecimal(Math.sin(anguloRad)))).add(y.multiply(new BigDecimal(Math.cos(anguloRad))));
	}

	public BigDecimal getX1() {
		return x1;
	}

	public void setX1(BigDecimal x1) {
		this.x1 = x1;
	}

	public BigDecimal getX2() {
		return x2;
	}

	public void setX2(BigDecimal x2) {
		this.x2 = x2;
	}

	public BigDecimal getX3() {
		return x3;
	}

	public void setX3(BigDecimal x3) {
		this.x3 = x3;
	}

	public BigDecimal getX4() {
		return x4;
	}

	public void setX4(BigDecimal x4) {
		this.x4 = x4;
	}

	public BigDecimal getY1() {
		return y1;
	}

	public void setY1(BigDecimal y1) {
		this.y1 = y1;
	}

	public BigDecimal getY2() {
		return y2;
	}

	public void setY2(BigDecimal y2) {
		this.y2 = y2;
	}

	public BigDecimal getY3() {
		return y3;
	}

	public void setY3(BigDecimal y3) {
		this.y3 = y3;
	}

	public BigDecimal getY4() {
		return y4;
	}

	public void setY4(BigDecimal y4) {
		this.y4 = y4;
	}

	@Override
	public String toString() {
		return "Coordenadas: [(" + x1 + "," + y1 + "), (" + x2 + "," + y2 + "), (" + x3 + "," + y3 + "), (" + x4 + ","
				+ y4 + ")]";
	}
}
