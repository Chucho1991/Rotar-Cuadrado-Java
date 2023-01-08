public class Square {

    public static void main(String[] args) {
        int size = 5; // Tamaño del cuadrado
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                    System.out.print("*"); // Dibujamos un borde
                } else {
                    System.out.print(" "); // Dibujamos un espacio en blanco
                }
            }
            System.out.println(); // Saltamos a la siguiente línea
        }
    }

}
