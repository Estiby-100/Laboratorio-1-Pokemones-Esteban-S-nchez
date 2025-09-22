public class Pokemon {
    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private Habilidad habilidad;
    private boolean habilidadActiva;

    protected Pokemon(String nombre, String tipo, int ataque, int defensa, Habilidad habilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidad = habilidad;
        this.habilidadActiva = false;
    }

    public void activarHabilidad() {
        habilidadActiva = habilidad.seActiva();
    }

    public int calcularAtaqueTotal(Pokemon rival) {
        int efectoTipo = calcularEfectoTipo(rival.getTipo());
        int ataqueTotal = ataque - rival.defensa + efectoTipo;

        if (habilidadActiva) {
            switch (habilidad.getTipoEfecto()) {
                case "ataque":
                    ataqueTotal += habilidad.getValor();
                    break;
                case "dañoEnemigo":
                    ataqueTotal += habilidad.getValor();
                    break;
            }
        }

        return ataqueTotal;
    }

    protected int calcularEfectoTipo(String tipoRival) {
        return 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }
}
