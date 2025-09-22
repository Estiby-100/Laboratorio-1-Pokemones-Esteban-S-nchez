public class PokemonAgua extends Pokemon {
    public PokemonAgua(String nombre, int ataque, int defensa, Habilidad habilidad) {
        super(nombre, "Agua", ataque, defensa, habilidad);
    }

    @Override
    protected int calcularEfectoTipo(String tipoRival) {
        switch (tipoRival) {
            case "Fuego":
                return 20;
            case "Planta":
            case "Eléctrico":
                return -10;
            default:
                return 0;
        }
    }
}
