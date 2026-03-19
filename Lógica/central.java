public class central {
    private String palabraSecreta;
    private int intentosUsados;
    private boolean juegoTerminado;

    //Constructor
    public central(String palabraSecreta, int intentos) {
        this.palabraSecreta = seleccionarPalabraAleatoria();
        this.intentosUsados = 0;
        this.juegoTerminado = false;
    }

    //Método para recibir un String del usuario y devolver el status de cada letra
    public String recibirIntento(String intento) {
        if (juegoTerminado) {
            return "El juego ha terminado. Por favor, reinicie para jugar de nuevo.";
        }

        intentosUsados++;

        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < palabraSecreta.length(); i++) {
            char letraIntento = intento.charAt(i);
            char letraSecreta = palabraSecreta.charAt(i);

            if (letraIntento == letraSecreta) {
                resultado.append("Correcta ");
            } else if (palabraSecreta.contains(String.valueOf(letraIntento))) {
                resultado.append("Presente ");
            } else {
                resultado.append("Incorrecta ");
            }
        }

        if (intento.equals(palabraSecreta)) {
            juegoTerminado = true;
            return "¡Felicidades! Has adivinado la palabra secreta.";
        }

        if (intentosUsados >= 6) {
            juegoTerminado = true;
            return "Has agotado tus intentos. La palabra secreta era: " + palabraSecreta;
        }

        return resultado.toString().trim();
    }
}