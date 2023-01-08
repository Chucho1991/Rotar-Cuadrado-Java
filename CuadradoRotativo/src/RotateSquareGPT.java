import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RotateSquareGPT extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		// Creamos una transformación de rotación
		AffineTransform transform = new AffineTransform();
		transform.rotate(Math.PI / 4, 100, 100); // 45 grados en radianes

		// Aplicamos la transformación al contexto gráfico
		g2d.setTransform(transform);

		// Dibujamos el cuadrado rotado
		g2d.setColor(Color.BLUE);
		g2d.fillRect(50, 50, 100, 100);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new RotateSquareGPT());
		frame.setVisible(true);
	}

}
