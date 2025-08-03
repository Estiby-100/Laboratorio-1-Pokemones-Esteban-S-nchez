public class SistemaDeBatalla {
    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private int rondaActual;

    public SistemaDeBatalla(Entrenador entrenadorA, Entrenador entrenadorB) {
        this.entrenador1 = entrenadorA;
        this.entrenador2 = entrenadorB;
        this.rondaActual = 1;
    }

    public Entrenador getEntrenador1() {
        return entrenador1;
    }

    public Entrenador getEntrenador2() {
        return entrenador2;
    }

    public int getRondaActual() {
        return rondaActual;
    }

    public void siguienteRonda() {
        rondaActual++;
    }
    public int combatir(Pokemon p1, Pokemon p2) {
        p1.activarHabilidad();
        p2.activarHabilidad();

        int atk1 = p1.calcularAtaqueTotal(p2);
        int atk2 = p2.calcularAtaqueTotal(p1);

        if (atk1 > atk2) {
            entrenador1.incrementarRondasGanadas();
            return 1;
        } else if (atk2 > atk1) {
            entrenador2.incrementarRondasGanadas();
            return 2;
        } else {
            return 0;
        }
    }
public int getRondasGanadasEntrenador1() {
    return entrenador1.getRondasGanadas();
}

public int getRondasGanadasEntrenador2() {
    return entrenador2.getRondasGanadas();
}
}
