import java.util.Random;

public class Habilidad {
    private String nombre;
    private String tipoEfecto;
    private int valor;
    private int probabilidad;

    private static final Random generador = new Random();

    public Habilidad(String nombre, String tipoEfecto, int valor, int probabilidad) {
        this.nombre = nombre;
        this.tipoEfecto = tipoEfecto;
        this.valor = valor;
        this.probabilidad = probabilidad;
    }

    public boolean seActiva() {
        int numerorandom = generador.nextInt(100);
        return numerorandom < probabilidad;
    }

    public String getTipoEfecto() {
        return tipoEfecto;
    }

    public int getValor() {
        return valor;
    }
}
