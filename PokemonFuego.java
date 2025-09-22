public class PokemonFuego extends Pokemon {
    public PokemonFuego(String nombre, int ataque, int defensa, Habilidad habilidad) {
        super(nombre, "Fuego", ataque, defensa, habilidad);
    }

    @Override
    protected int calcularEfectoTipo(String tipoRival) {
        switch (tipoRival) {
            case "Planta":
                return 20;
            case "Agua":
                return -10;
            default:
                return 0;
        }
    }
}
