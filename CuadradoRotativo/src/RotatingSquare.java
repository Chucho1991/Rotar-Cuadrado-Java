public class RotatingSquare {

	public static void main(String[] args) {
		int size = 5; // Tamaño del cuadrado
		double angle = 0; // Ángulo de rotación inicial
		while (true) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					double x = j - size / 2;
					double y = i - size / 2;
					double xPrime = x * Math.cos(angle) - y * Math.sin(angle);
					double yPrime = x * Math.sin(angle) + y * Math.cos(angle);
					if (Math.abs(xPrime) < size / 2 && Math.abs(yPrime) < size / 2) {
						System.out.print("*"); // Dibujamos el cuadrado rotado
					} else {
						System.out.print(" "); // Dibujamos un espacio en blanco
					}
				}
				System.out.println(); // Saltamos a la siguiente línea
			}
			angle += Math.PI / 50; // Incrementamos el ángulo de rotación
			try {
				Thread.sleep(100); // Esperamos 100 milisegundos
			} catch (InterruptedException ex) {
				// No hacemos nada
			}
			System.out.print("\033[H\033[2J"); // Limpiamos la consola
		}
	}

}
