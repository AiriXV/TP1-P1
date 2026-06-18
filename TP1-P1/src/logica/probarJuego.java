package logica;
import java.util.Scanner;

public class probarJuego {
    public static void main(String[] args) {
        // Instancia de lógica
        Central juego = new Central();
        Scanner lector = new Scanner(System.in);

        System.out.println("--- Bienvenido a Wordle ---");
        System.out.println("Adiviná la palabra de 5 letras");

        // Bucle principal del juego
        // Mientras el juego no haya terminado, seguimos pidiendo palabras
        while (!juego.isJuegoTerminado()) { 
            System.out.print("\nIntroduce tu palabra: ");
            String intento = lector.nextLine();

            // Validamos que tenga 5 letras antes de enviarla
            if (intento.length() != 5) {
                System.out.println("¡Error! La palabra debe tener exactamente 5 letras.");
                continue;
            }

            // Llamamos al método y mostramos el resultado
            String resultado = juego.recibirIntento(intento);
            System.out.println("Resultado: " + resultado);
        }

        System.out.println("\nGracias por jugar.");
        lector.close();
    }
}