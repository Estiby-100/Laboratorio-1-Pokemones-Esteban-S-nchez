import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Habilidad h1 = new Habilidad("Llama Final", "ataque", 15, 30);
        Habilidad h2 = new Habilidad("Escudo Natural", "defensa", 20, 25);
        Habilidad h3 = new Habilidad("Impacto Relámpago", "dañoEnemigo", 10, 50);
        Habilidad h4 = new Habilidad("Agua de poseidón", "ataque", 12, 40);

        Pokemon p1 = new Pokemon("Charmander", "Fuego", 50, 30, h1);
        Pokemon p2 = new Pokemon("Bulbasaur", "Planta", 45, 35, h2);
        Pokemon p3 = new Pokemon("Squirtle", "Agua", 40, 40, h3);
        Pokemon p4 = new Pokemon("Pikachu", "Eléctrico", 55, 25, h4);

        Pokemon q1 = new Pokemon("Charizard", "Fuego", 52, 33, h3);
        Pokemon q2 = new Pokemon("Turtwig", "Planta", 43, 37, h1);
        Pokemon q3 = new Pokemon("Totodile", "Agua", 42, 38, h2);
        Pokemon q4 = new Pokemon("Raichu", "Eléctrico", 50, 28, h4);

        Entrenador ash = new Entrenador("Ash", p1, p2, p3, p4);
        Entrenador goku = new Entrenador("Goku", q1, q2, q3, q4);

        SistemaDeBatalla sistema = new SistemaDeBatalla(ash, goku);

        boolean usado1Ash = false, usado2Ash = false, usado3Ash = false, usado4Ash = false;
        boolean usado1Goku = false, usado2Goku = false, usado3Goku = false, usado4Goku = false;

        for (int ronda = 1; ronda <= 4; ronda++) {
            System.out.println("RONDA " + ronda);

            Pokemon pokeAsh = elegirPokemon(sc, ash, usado1Ash, usado2Ash, usado3Ash, usado4Ash);
            if (pokeAsh == ash.getPokemon(1)) usado1Ash = true;
            else if (pokeAsh == ash.getPokemon(2)) usado2Ash = true;
            else if (pokeAsh == ash.getPokemon(3)) usado3Ash = true;
            else usado4Ash = true;

            Pokemon pokeGoku = elegirPokemon(sc, goku, usado1Goku, usado2Goku, usado3Goku, usado4Goku);
            if (pokeGoku == goku.getPokemon(1)) usado1Goku = true;
            else if (pokeGoku == goku.getPokemon(2)) usado2Goku = true;
            else if (pokeGoku == goku.getPokemon(3)) usado3Goku = true;
            else usado4Goku = true;

            System.out.println(ash.getNombre() + " eligió a " + pokeAsh.getNombre());
            System.out.println(goku.getNombre() + " eligió a " + pokeGoku.getNombre());

            System.out.print(ash.getNombre() + ": ¿Usar habilidad especial? (si/no): ");
            boolean usarHabilidadAsh = sc.next().equalsIgnoreCase("s");

            System.out.print(goku.getNombre() + ": ¿Usar habilidad especial? (si/no): ");
            boolean usarHabilidadGoku = sc.next().equalsIgnoreCase("s");

            if (usarHabilidadAsh) pokeAsh.activarHabilidad();
            if (usarHabilidadGoku) pokeGoku.activarHabilidad();

            int resultado = sistema.combatir(pokeAsh, pokeGoku);

            if (resultado == 1) {
                System.out.println("Gana la ronda: " + ash.getNombre());
            } else if (resultado == 2) {
                System.out.println("Gana la ronda: " + goku.getNombre());
            } else {
                System.out.println("Empate en esta ronda.");
            }

            sistema.siguienteRonda();
        }

        int r1 = sistema.getRondasGanadasEntrenador1();
        int r2 = sistema.getRondasGanadasEntrenador2();

        System.out.println("RESULTADO FINAL:");
        System.out.println(ash.getNombre() + " ganó " + r1 + " ronda(s).");
        System.out.println(goku.getNombre() + " ganó " + r2 + " ronda(s).");

        if (r1 > r2) {
            System.out.println("Ganador final: " + ash.getNombre());
        } else if (r2 > r1) {
            System.out.println("Ganador final: " + goku.getNombre());
        } else {
            System.out.println("Empate final");
        }

        sc.close();
    }

    public static Pokemon elegirPokemon(Scanner sc, Entrenador entrenador,
        boolean u1, boolean u2, boolean u3, boolean u4) {

        while (true) {
            System.out.println(entrenador.getNombre() + ", elige tu Pokémon:");
            if (!u1) System.out.println("1. " + entrenador.getPokemon(1).getNombre());
            if (!u2) System.out.println("2. " + entrenador.getPokemon(2).getNombre());
            if (!u3) System.out.println("3. " + entrenador.getPokemon(3).getNombre());
            if (!u4) System.out.println("4. " + entrenador.getPokemon(4).getNombre());

            System.out.print("Ingresa el número del Pokémon: ");
            int opcion = sc.nextInt();

            if (opcion == 1 && !u1) return entrenador.getPokemon(1);
            if (opcion == 2 && !u2) return entrenador.getPokemon(2);
            if (opcion == 3 && !u3) return entrenador.getPokemon(3);
            if (opcion == 4 && !u4) return entrenador.getPokemon(4);

            System.out.println("Opción inválida o Pokémon ya usado.");
        }
    }
}
