package logica;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;


public class Central {
	private String palabraSecreta;
	private int intentosUsados;
	private boolean juegoTerminado;

	// Constructor
	public Central() {
		this.palabraSecreta = seleccionarPalabraAleatoria();
		this.intentosUsados = 0;
		this.juegoTerminado = false;
	}

	// Método para recibir un String del usuario y devolver el status de cada letra
	public Boolean[] recibirIntento(String intento) {
//        if (juegoTerminado) {
//            return "El juego ha terminado. Por favor, reinicie para jugar de nuevo.";
//        }

		intento = intento.toUpperCase();
		String secreta = palabraSecreta.toUpperCase();

		intentosUsados++;

		// Array para marcar qué letras de la secreta ya usamos
		boolean[] usadaEnSecreta = new boolean[5];
		Boolean[] resultadoColores = new Boolean[5];

		// Buscamos correctas primero
		for (int i = 0; i < 5; i++) {
			if (intento.charAt(i) == secreta.charAt(i)) {
//            resultadoColores[i] = "Correcta";
				resultadoColores[i] = true;
				usadaEnSecreta[i] = true;
			} 

		}

		
		// Luego buscamos presentes e incorrectas
		for (int i = 0; i < 5; i++) {
			// Solo evaluamos si no fue correcta en el paso anterior
			if (resultadoColores[i] == null) {
				char letraIntento = intento.charAt(i);
//				boolean encontrada = false;

				for (int j = 0; j < 5; j++) {
					// Si la letra está en la secreta y esa posición no fue usada todavía
					if (!usadaEnSecreta[j] && secreta.charAt(j) == letraIntento) {
						// resultadoColores[i] = "Presente";
						resultadoColores[i] = false;
						usadaEnSecreta[j] = true; // La marcamos como usada
//						encontrada = true;
						break;
					}
				}

			}
		}

		logicaVictoria(intento);

		// Unimos el array de resultados en un solo String para devolver
		return resultadoColores;

	}

	private String logicaVictoria(String intento) {
		// Lógica de victoria o derrota
		if (intento.equalsIgnoreCase(palabraSecreta)) {
			juegoTerminado = true;
				return "¡Felicidades! Has adivinado la palabra secreta.";
		}

		if (intentosUsados >= 6) {
			juegoTerminado = true;
			return "Perdiste. La palabra secreta era: " + palabraSecreta;
		}
		
		return null; // El juego continúa
	}

	// Método para seleccionar una palabra aleatoria de una lista predefinida
	private String seleccionarPalabraAleatoria() {
		//-----Listado de palabras solo por si queremos hacer una revisión sin usar el txt
		//String[] diccionario = { "arbol", "casas", "zorro", "piano", "llave", "libro", "mouse", "tecla", "gatos",
		//		"juego" };
		// Generamos un índice al azar entre 0 y el largo de la lista
		// int indiceAleatorio = (int) (Math.random() * diccionario.length);
		//return diccionario[indiceAleatorio];
		
		//ahora si usando el txt
		try {
	        // Busca el archivo y guarda todas las líneas en una lista
	        List<String> todasLasPalabras = Files.readAllLines(Paths.get("diccionario.txt"));

	        int indiceAleatorio = (int) (Math.random() * todasLasPalabras.size());
	        
	        // retorna la palabra elegida, quitando espacios y pasando a mayúsculas
	        return todasLasPalabras.get(indiceAleatorio).trim().toUpperCase();

	    } catch (IOException e) {
	        // Si el archivo no existe o no se puede leer, muestra el error en consola
	        System.out.println("Error al leer el archivo de palabras: " + e.getMessage());
	        return "JUEGO"; // Palabra de respaldo por defecto para que el programa no se rompa
	    }
		
	}

	// Getter para saber si el juego terminó (informa a probarJuego)
	public boolean isJuegoTerminado() {
		return this.juegoTerminado;
	}
	
	public String getPalabraSecreta() {
		return this.palabraSecreta;
	}

	public String getIntentosUsados() {

		return this.intentosUsados + " de 6";
	}
}