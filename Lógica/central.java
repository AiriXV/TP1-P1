public class Central {
    private String palabraSecreta;
    private int intentosUsados;
    private boolean juegoTerminado;

    //Constructor
    public Central(String palabraSecreta, int intentos) {
        this.palabraSecreta = seleccionarPalabraAleatoria();
        this.intentosUsados = 0;
        this.juegoTerminado = false;
    }

    //Método para recibir un String del usuario y devolver el status de cada letra
    public String recibirIntento(String intento) {
        if (juegoTerminado) {
            return "El juego ha terminado. Por favor, reinicie para jugar de nuevo.";
        }
        
        intento = intento.toUpperCase();
        String secreta = palabraSecreta.toUpperCase();
        
        intentosUsados++;

        // Array para marcar qué letras de la secreta ya usamos
        boolean[] usadaEnSecreta = new boolean[5];
        String[] resultadoColores = new String[5];

        //Buscamos correctas primero
        for (int i = 0; i < 5; i++) {
            if (intento.charAt(i) == secreta.charAt(i)) {
            resultadoColores[i] = "Correcta";
            usadaEnSecreta[i] = true;
            }
        }

        // Luego buscamos presentes e incorrectas
        for (int i = 0; i < 5; i++) {
            // Solo evaluamos si no fue correcta en el paso anterior
            if (resultadoColores[i] == null) {
                char letraIntento = intento.charAt(i);
                boolean encontrada = false;

                for (int j = 0; j < 5; j++) {
                    // Si la letra está en la secreta y esa posición no fue usada todavía
                    if (!usadaEnSecreta[j] && secreta.charAt(j) == letraIntento) {
                        resultadoColores[i] = "Presente";
                        usadaEnSecreta[j] = true; // La marcamos como usada
                        encontrada = true;
                        break;
                    }
                }
                
                if (!encontrada) {
                    resultadoColores[i] = "Incorrecta";
                }
            }
    }
    
    // Lógica de victoria o derrota
        if (intento.equals(palabraSecreta)) {
            juegoTerminado = true;
            return "¡Felicidades! Has adivinado la palabra secreta.";
        }

        if (intentosUsados >= 6) {
            juegoTerminado = true;
            return "Perdiste. La palabra secreta era: " + palabraSecreta;
        }

        // Unimos el array de resultados en un solo String para devolver
        return String.join(" ", resultadoColores);
    }
}