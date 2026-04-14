package logica;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;

public class Central {
	private String palabraSecreta;
	private int intentosUsados;
	private boolean juegoTerminado;
	private int cantIntentos, cantLetras;

	public Central() {
		this.cantIntentos = 6;
		this.cantLetras = 5;
		this.palabraSecreta = seleccionarPalabraAleatoria();
		this.intentosUsados = 0;
		this.juegoTerminado = false;
	}

	public Boolean[] recibirIntento(String intento) {
		intento = intento.trim().toUpperCase();

		if (!validarPalabra(intento)) {
			return null;
		}

		String secreta = palabraSecreta.toUpperCase();
		intentosUsados++;

		Boolean[] resultadoColores = new Boolean[cantLetras];
		boolean[] usadaEnSecreta = new boolean[cantLetras];

		// 1) verdes
		for (int i = 0; i < cantLetras; i++) {
			if (intento.charAt(i) == secreta.charAt(i)) {
				resultadoColores[i] = true;
				usadaEnSecreta[i] = true;
			}
		}

		// 2) amarillos
		for (int i = 0; i < cantLetras; i++) {
			if (resultadoColores[i] == null) {
				char letraIntento = intento.charAt(i);

				for (int j = 0; j < cantLetras; j++) {
					if (!usadaEnSecreta[j] && secreta.charAt(j) == letraIntento) {
						resultadoColores[i] = false;
						usadaEnSecreta[j] = true;
						break;
					}
				}
			}
		}

		logicaVictoria(intento);
		return resultadoColores;
	}

	private boolean validarPalabra(String intento) {
		try {
			List<String> todasLasPalabras = Files.readAllLines(Paths.get("diccionario.txt"));

			for (String palabra : todasLasPalabras) {
				if (palabra.trim().equalsIgnoreCase(intento)) {
					return true;
				}
			}

			return false;
		} catch (IOException e) {
			System.out.println("Error al leer el archivo de palabras: " + e.getMessage());
			return false;
		}
	}

	private void logicaVictoria(String intento) {
		if (intento.equalsIgnoreCase(palabraSecreta)) {
			juegoTerminado = true;
			return;
		}

		if (intentosUsados >= cantIntentos) {
			juegoTerminado = true;
		}
	}

	private String seleccionarPalabraAleatoria() {
		try {
			List<String> todasLasPalabras = Files.readAllLines(Paths.get("diccionario.txt"));

			if (todasLasPalabras.isEmpty()) {
				return "JUEGO";
			}

			int indiceAleatorio = (int) (Math.random() * todasLasPalabras.size());
			return todasLasPalabras.get(indiceAleatorio).trim().toUpperCase();

		} catch (IOException e) {
			System.out.println("Error al leer el archivo de palabras: " + e.getMessage());
			return "JUEGO";
		}
	}

	public boolean termino() {
		return this.juegoTerminado;
	}

	public String obtenerPalabraSecreta() {
		return this.palabraSecreta;
	}

	public String obtenerIntentosUsados() {
		return this.intentosUsados + " de " + this.cantIntentos;
	}

	public int obteterCantIntentos() {
		return cantIntentos;
	}

	public int obtenerCantLetras() {
		return cantLetras;
	}
}