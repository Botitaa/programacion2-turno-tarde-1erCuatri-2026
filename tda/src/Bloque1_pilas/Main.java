package Bloque1_pilas;

import Bloque1_pilas.Implementacion.Estrategia_1;
import Bloque1_pilas.Interfaces.PilaTDA;

public class Main {
    public static void main(String[] args) {

        // === Ejercicio 1: Historial de Navegación ===
        Estrategia_1 historial = new Estrategia_1();
        historial.InicializarPila();

        historial.Apilar("https://fi.uba.ar/");
        historial.Apilar("https://campusvirtual.frsf.utn.edu.ar/");
        historial.Apilar("https://stackoverflow.co/");

        System.out.println("\n=== Ejercicio 1: Historial de Navegación ===");
        System.out.println("Página actual: " + historial.Tope());
        historial.Desapilar();
        System.out.println("Atrás: " + historial.Tope());
        historial.Desapilar();
        System.out.println("Atrás: " + historial.Tope());
        historial.Desapilar();
        System.out.println("¿Pila vacía? " + historial.PilaVacia());


        // === Ejercicio 2: Editor de Código (Undo) ===
        Estrategia_1 undoStack = new Estrategia_1();
        undoStack.InicializarPila();

        undoStack.Apilar("");
        undoStack.Apilar("int x = 5;");
        undoStack.Apilar("int x = 5;\nint y = 10;");

        System.out.println("\n=== Ejercicio 2: Editor de Código (Undo) ===");
        System.out.println("Ctrl+Z restaura: " + undoStack.Tope());
        undoStack.Desapilar();
        System.out.println("Ctrl+Z restaura: " + undoStack.Tope());
        undoStack.Desapilar();
        System.out.println("Ctrl+Z restaura: " + undoStack.Tope());
        undoStack.Desapilar();
        System.out.println("¿Pila vacía? " + undoStack.PilaVacia());


        // === Ejercicio 3: Balanceo de Paréntesis ===
        Estrategia_1 parentesis = new Estrategia_1();
        parentesis.InicializarPila();
        String texto = "(as(ds(sd)ddd))";

        System.out.println("\n=== Ejercicio 3: Balanceo de Paréntesis ===");

        for (char c : texto.toCharArray()) {
            if (c == '(') {
                parentesis.Apilar(String.valueOf(c));
            } else if (c == ')') {
                if (!parentesis.PilaVacia()) {
                    parentesis.Desapilar();
                } else {
                    System.out.println("Error: paréntesis de más");
                }
            }
        }

        // Al final verificás si quedaron paréntesis sin cerrar
        if (parentesis.PilaVacia()) {
            System.out.println("Paréntesis balanceados ✓");
        } else {
            System.out.println("Faltan cerrar paréntesis ✗");
        }

        // === Ejercicio 4: Reversión de Strings ===
        Estrategia_1 reversa = new Estrategia_1();
        reversa.InicializarPila();
        String palabra = "algoritmo";

        System.out.println("\n=== Ejercicio 4: Reversión de Strings ===");
        System.out.println(palabra);

        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < palabra.length(); i++) {
            reversa.Apilar(String.valueOf(palabra.charAt(i)));
        }

        for (int i = 0; i < palabra.length(); i++) {
            resultado.append(reversa.Tope());
            reversa.Desapilar();
        }

        System.out.println(resultado.toString());
        

        // === Ejercicio 5: Call Stack ===
        Estrategia_1 callStack = new Estrategia_1();
        callStack.InicializarPila();

        System.out.println("\n=== Ejercicio 5: Call Stack ===");

        callStack.Apilar("Main()");
        callStack.Apilar("CalcularPromedio()");
        callStack.Apilar("Sumar()");

        System.out.println(callStack.Tope());


        // === Ejercicio 6: Navegación de Directorios ===
        Estrategia_1 directorios = new Estrategia_1();
        directorios.InicializarPila();

        System.out.println("\n=== Ejercicio 6: Directorios ===");

        directorios.Apilar("C:/");
        directorios.Apilar("C:/Usuarios");
        directorios.Apilar("C:/Usuarios/Documentos");

        System.out.println("Estás en: " + directorios.Tope());

        // Usuario apreta "Subir un nivel"
        directorios.Desapilar();
        System.out.println("Subiste un nivel. Ahora estás en: " + directorios.Tope());

    }
}