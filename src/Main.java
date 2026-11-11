public class Main {
    public static void main(String[] args) {
        SistemaBiblioteca biblioteca = new SistemaBiblioteca();

        // 1. HashMap — Catálogo. 2 libros y 2 revistas
        Libro libro1 = new Libro("BK-2026-001", "Cien años de soledad", 1967, true, "Gabriel García Márquez", "978-0132350884");
        Libro libro2 = new Libro("BK-2026-002", "Don Quijote de la Mancha", 1605, false, "Miguel de Cervantes", "978-0134685991"); //prestado (false)
        Revista revista1 = new Revista("RV-2026-001", "National Geographic", 1888, true, 150, "Naturaleza");
        Revista revista2 = new Revista("RV-2026-002", "Time", 1923, true, 88, "Actualidad");

        biblioteca.registrarMaterial(libro1);
        biblioteca.registrarMaterial(libro2);
        biblioteca.registrarMaterial(revista1);
        biblioteca.registrarMaterial(revista2);

        System.out.println("--- BÚSQUEDA EN CATÁLOGO ---");
        Material encontrado = biblioteca.buscarMaterial("BK-2026-001");
        if (encontrado != null) {
            encontrado.mostrarInfo();
        }

        // Buscar un código inexistente
        Material inexistente = biblioteca.buscarMaterial("BK-001");
        if (inexistente != null) {
            inexistente.mostrarInfo();
        } else {
            System.out.println("Este código no existe en el catálogo");
        }

        // 2. ArrayList — Lista de espera
        System.out.println("\n--- LISTA DE ESPERA ---");
        biblioteca.agregarEspera("BK-2026-002", "Marcela");
        biblioteca.agregarEspera("BK-2026-002", "José");
        biblioteca.agregarEspera("BK-2026-002", "Melissa");

        System.out.println("Primero atendido: " + biblioteca.siguienteEnEspera("BK-2026-002"));
        System.out.println("Segundo atendido: " + biblioteca.siguienteEnEspera("BK-2026-002"));

        // 3. HashSet — Membresías
        System.out.println("\n--- MEMBRESÍAS ---");
        System.out.println("Registro 1 (Marcela): " + biblioteca.registrarMiembro("Marcela"));
        System.out.println("Registro 2 (José): " + biblioteca.registrarMiembro("José"));
        System.out.println("Registro 3 (Melissa): " + biblioteca.registrarMiembro("Melissa"));

        // mismo usuario dos veces
        System.out.println("Registro 4 (Marcela): " + biblioteca.registrarMiembro("Marcela"));

        // Verificar membresía
        System.out.println("¿Melissa tiene membresía?: " + biblioteca.tieneMembresia("Melissa"));
        System.out.println("¿Alejo tiene membresía?: " + biblioteca.tieneMembresia("Alejo"));

        // 4. Polimorfismo. Mostrar catálogo
        System.out.println("\n--- CATÁLOGO ---");
        biblioteca.mostrarCatalogo();
    }
}
