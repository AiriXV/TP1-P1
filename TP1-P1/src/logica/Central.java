package logica;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.io.IOException;
import java.text.Normalizer;
import java.util.regex.Pattern;

public class Central {
	private String palabraSecreta;
	private int intentosUsados;
	private boolean juegoTerminado;
	private int cantIntentos, cantLetras;
	private List<String> todasLasPalabras;
	

	public Central(String nivel, String idioma) {
		try {
		this.todasLasPalabras=Files.readAllLines(Paths.get(idioma+".txt"));
		} catch (IOException e) {
			System.out.println("Error al leer el archivo de palabras: " + e.getMessage());
			
		}
		setearNivel( nivel);
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


		for (int i = 0; i < cantLetras; i++) {
			if (intento.charAt(i) == secreta.charAt(i)) {
				resultadoColores[i] = true;
				usadaEnSecreta[i] = true;
			}
		}


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
		

			for (String palabra : todasLasPalabras) {
				if (palabra.trim().equalsIgnoreCase(intento)) {
					return true;
				} 
			} return false;
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
		List<String> candidatas = todasLasPalabras.stream().filter(p->p.length()==cantLetras).collect(Collectors.toList());
		int indiceAleatorio = (int) (Math.random() * candidatas.size());
		return limpiarAcentos( candidatas.get(indiceAleatorio).trim().toUpperCase());

		
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
	
	public void setearNivel( String nivel){
		if(nivel.equals("ALTA")){
		this.cantLetras=6;
		this.cantIntentos=5;
		 
		}else{
		this.cantLetras=5;
		this.cantIntentos=6;
		}}
	
	public String limpiarAcentos(String texto) {
		String normalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
		Pattern patron = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return patron.matcher(normalizado).replaceAll("");
		}
}