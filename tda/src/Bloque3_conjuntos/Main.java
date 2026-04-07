package Bloque3_conjuntos;

import Bloque3_conjuntos.Implementacion.ImplementacionConjuntos;

public class Main {
    public static void main(String[] args) {

        // ============================================================
        // EJERCICIO 1: Padrón Electoral
        // Evitar que un alumno vote dos veces usando Pertence()
        // ============================================================
        System.out.println("=== EJERCICIO 1: Padrón Electoral ===");

        ImplementacionConjuntos votacion = new ImplementacionConjuntos();
        votacion.InicializarConjunto();

        int[] legajos = {10001, 10002, 10001, 10003, 10002};

        for (int legajo : legajos) {
            if (!votacion.Pertence(legajo)) {
                votacion.Agregar(legajo);
                System.out.println("Legajo " + legajo + " votó correctamente.");
            } else {
                System.out.println("Legajo " + legajo + " INTENTO VOTAR DOS VECES. Rechazado.");
            }
        }

        // ============================================================
        // EJERCICIO 2: Invitados a la Fiesta de Fin de Cursada
        // Agregar alguien que ya está en la lista no cambia el tamaño
        // ============================================================
        System.out.println("\n=== EJERCICIO 2: Invitados Fiesta Fin de Cursada ===");

        ImplementacionConjuntos fiesta = new ImplementacionConjuntos();
        fiesta.InicializarConjunto();

        fiesta.Agregar(1); // Ana
        fiesta.Agregar(2); // Bruno
        fiesta.Agregar(3); // Carlos

        System.out.println("Invitados agregados: Ana(1), Bruno(2), Carlos(3)");
        System.out.println("Intentando agregar a Bruno(2) de nuevo...");
        fiesta.Agregar(2); // duplicado
        System.out.println("Bruno(2) ya estaba en la lista. El conjunto no cambió.");

        // ============================================================
        // EJERCICIO 3: Filtro de Spam (Blacklist)
        // Verificar si un mail tiene palabras prohibidas
        // ============================================================
        System.out.println("\n=== EJERCICIO 3: Filtro de Spam ===");

        // Usamos un conjunto de códigos enteros que representan palabras
        // 1=Crypto, 2=Ganá, 3=Premio
        ImplementacionConjuntos blacklist = new ImplementacionConjuntos();
        blacklist.InicializarConjunto();
        blacklist.Agregar(1); // "Crypto"
        blacklist.Agregar(2); // "Ganá"
        blacklist.Agregar(3); // "Premio"

        int[] mailActual = {4, 2, 5}; // contiene "Ganá" → spam

        boolean esSpam = false;
        for (int palabra : mailActual) {
            if (blacklist.Pertence(palabra)) {
                esSpam = true;
                break;
            }
        }
        System.out.println("El mail contiene palabras prohibidas (1=Crypto,2=Ganá,3=Premio).");
        System.out.println("¿Es spam? " + (esSpam ? "SÍ, mail bloqueado." : "No, mail permitido."));

        // ============================================================
        // EJERCICIO 4: Tags de un Blog de Ingeniería
        // Un post tiene etiquetas #Programacion, #Java, #OOP
        // Un Conjunto garantiza que no hay etiquetas repetidas
        // ============================================================
        System.out.println("\n=== EJERCICIO 4: Tags de Blog ===");

        // 1=#Programacion, 2=#Java, 3=#OOP
        ImplementacionConjuntos tags = new ImplementacionConjuntos();
        tags.InicializarConjunto();
        tags.Agregar(1);
        tags.Agregar(2);
        tags.Agregar(3);
        tags.Agregar(2); // intento de duplicar #Java

        System.out.println("Tags agregados: #Programacion(1), #Java(2), #OOP(3)");
        System.out.println("Intento de agregar #Java(2) de nuevo → ignorado por el Conjunto.");
        System.out.println("Usamos Conjunto y no Pila porque los tags no tienen orden ni duplicados.");

        // ============================================================
        // EJERCICIO 5: Gestión de Legajos
        // Un alumno con dos carreras no debe duplicar su ID
        // ============================================================
        System.out.println("\n=== EJERCICIO 5: Gestión de Legajos ===");

        ImplementacionConjuntos legajosDB = new ImplementacionConjuntos();
        legajosDB.InicializarConjunto();

        int alumno = 55555;
        legajosDB.Agregar(alumno); // se anota en carrera 1
        System.out.println("Alumno " + alumno + " anotado en carrera 1.");
        legajosDB.Agregar(alumno); // intenta anotarse en carrera 2 con mismo ID
        System.out.println("Intento de duplicar legajo " + alumno + " (carrera 2) → el Conjunto lo rechaza automáticamente.");

        // ============================================================
        // EJERCICIO 6: Operación Elegir vs Sacar
        // Llamar Elegir dos veces sin Sacar → mismo elemento (es arbitrario)
        // ============================================================
        System.out.println("\n=== EJERCICIO 6: Elegir vs Sacar ===");

        ImplementacionConjuntos c = new ImplementacionConjuntos();
        c.InicializarConjunto();
        c.Agregar(10);
        c.Agregar(20);
        c.Agregar(30);

        int e1 = c.Elegir();
        int e2 = c.Elegir();
        System.out.println("Elegir() sin Sacar → primera vez: " + e1 + ", segunda vez: " + e2);
        System.out.println("Son iguales: " + (e1 == e2) + " (arbitrario pero determinístico en esta implementación)");

        c.Sacar(e1);
        int e3 = c.Elegir();
        System.out.println("Después de Sacar(" + e1 + "), Elegir() devuelve: " + e3 + " (distinto elemento)");
    }
}