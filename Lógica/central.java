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
    
}