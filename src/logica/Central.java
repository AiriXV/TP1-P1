package logica;

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
		String[] diccionario = { "arbol", "casas", "zorro", "piano", "llave", "libro", "mouse", "tecla", "gatos",
				"juego" };

		// Generamos un índice al azar entre 0 y el largo de la lista
		int indiceAleatorio = (int) (Math.random() * diccionario.length);

		return diccionario[indiceAleatorio];
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
	
	//Metodo que verifica si la palabra esta dentro del diccionario
	public boolean esPalabraValida(String intento) {
	    String[] diccionario = { "arbol", "casas", "zorro", "piano", "llave", 
	                             "libro", "mouse", "tecla", "gatos", "juego" };
	    for (String palabra : diccionario) {
	        if (palabra.equalsIgnoreCase(intento)) {
	            return true;
	        }
	    }
	    return false;
	}
}