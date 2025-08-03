public class Entrenador {
    private String nombre;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon pokemon3;
    private Pokemon pokemon4;
    private int rondasGanadas;

    public Entrenador(String nombre, Pokemon p1, Pokemon p2, Pokemon p3, Pokemon p4) {
        this.nombre = nombre;
        this.pokemon1 = p1;
        this.pokemon2 = p2;
        this.pokemon3 = p3;
        this.pokemon4 = p4;
        this.rondasGanadas = 0;
    }

    public Pokemon getPokemon(int numero) {
        switch (numero) {
            case 1: return pokemon1;
            case 2: return pokemon2;
            case 3: return pokemon3;
            case 4: return pokemon4;
            default: return null;
        }
    }

    public void incrementarRondasGanadas() {
        rondasGanadas++;
    }

    public int getRondasGanadas() {
        return rondasGanadas;
    }

    public String getNombre() {
        return nombre;
    }
}

