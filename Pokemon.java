public class Pokemon {
    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private Habilidad habilidad;
    private boolean habilidadActiva;

    public Pokemon(String nombre, String tipo, int ataque, int defensa, Habilidad habilidad) {
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
    int efectoTipo = calcularEfectoTipo(rival.tipo);
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

    
    private int calcularEfectoTipo(String tipoRival) {
        switch (this.tipo) {
            case "Fuego":
                switch (tipoRival) {
                    case "Planta": return 20;
                    case "Agua": return -10;
                }
                break;
            case "Planta":
                switch (tipoRival) {
                    case "Agua": return 20;
                    case "Fuego": return -10;
                }
                break;
            case "Agua":
                switch (tipoRival) {
                    case "Fuego": return 20;
                    case "Planta":
                    case "Eléctrico": return -10;
                }
                break;
            case "Eléctrico":
                switch (tipoRival) {
                    case "Agua": return 20;
                }
                break;
        }
        return 0;
    }

    public String getNombre() {
        return nombre;
    }
}
