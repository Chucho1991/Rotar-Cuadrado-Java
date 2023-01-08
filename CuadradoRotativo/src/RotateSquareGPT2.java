import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class RotateSquareGPT2 extends JPanel {

    private double angle = 0; // Ángulo de rotación inicial

    public RotateSquareGPT2() {
        // Repintamos el panel cada 10 milisegundos
        Timer timer = new Timer(10, e -> repaint());
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Creamos una transformación de rotación
        AffineTransform transform = new AffineTransform();
        transform.rotate(angle, 100, 100);

        // Aplicamos la transformación al contexto gráfico
        g2d.setTransform(transform);

        // Dibujamos el cuadrado rotado
        g2d.setColor(Color.BLUE);
        g2d.fillRect(50, 50, 100, 100);

        // Incrementamos el ángulo de rotación
        angle += Math.PI / 50;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new RotateSquareGPT2());
        frame.setVisible(true);
    }

}
