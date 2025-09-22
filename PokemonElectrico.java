public class PokemonElectrico extends Pokemon {
    public PokemonElectrico(String nombre, int ataque, int defensa, Habilidad habilidad) {
        super(nombre, "Eléctrico", ataque, defensa, habilidad);
    }

    @Override
    protected int calcularEfectoTipo(String tipoRival) {
        switch (tipoRival) {
            case "Agua":
                return 20;
            default:
                return 0;
        }
    }
}
