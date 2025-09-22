public class PokemonPlanta extends Pokemon {
    public PokemonPlanta(String nombre, int ataque, int defensa, Habilidad habilidad) {
        super(nombre, "Planta", ataque, defensa, habilidad);
    }

    @Override
    protected int calcularEfectoTipo(String tipoRival) {
        switch (tipoRival) {
            case "Agua":
                return 20;
            case "Fuego":
                return -10;
            default:
                return 0;
        }
    }
}
