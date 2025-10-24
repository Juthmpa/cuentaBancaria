package com.judith.cuentaBancaria;
/*
 * Autor: Judith Piedra
 * Fecha: 22/10/2025
 * Descripción: Esta clase ejecuta los métodos necesarios para el sistema de cuentas bancarias.
 * Muestra menús interactivos para las operaciones del banco.
 */

// Se importan las librerías necesarias
// Importa la clase BufferedReader para leer texto de la entrada de caracteres
import java.io.BufferedReader;
// Importa la clase IOException para manejar errores de entrada/salida
import java.io.IOException;
// Importa la clase InputStreamReader para convertir bytes en caracteres
import java.io.InputStreamReader;

// Declaración de la clase pública Main
public class Main {

    // Métodos principal del programa
    // Declaración del métodoa main, punto de entrada del programa, que puede lanzar IOException
    public static void main(String[] args) throws IOException {

        // Declaración de variables necesarias
        // Declaración de variables de tipo float para datos monetarios y de tasa
        float saldo, tasaAnual, cantidad;
        // Declaración de variables de tipo int para almacenar las opciones de menú
        int opcionCuenta, opcionOperacion;

        // Se utiliza BufferedReader para leer datos desde consola
        // Inicialización del objeto BufferedReader para leer desde la consola
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Menú principal: elegir tipo de cuenta
        // Imprime el encabezado de bienvenida
        System.out.println("===== BIENVENIDO AL SISTEMA BANCARIO =====");
        // Imprime la instrucción para la selección
        System.out.println("Seleccione el tipo de cuenta que desea crear:");
        // Imprime las opciones
        System.out.println("1. Cuenta de Ahorros");
        System.out.println("2. Cuenta Corriente");
        // Pide al usuario que ingrese una opción
        System.out.print("Opción: ");
        // Lee la línea ingresada por el usuario, la convierte a entero y la guarda en opcionCuenta
        opcionCuenta = Integer.parseInt(br.readLine());

        // Se solicita el saldo
        System.out.print("Ingrese el saldo inicial: ");
        // Lee la línea, la convierte a float y la guarda en saldo
        saldo = Float.parseFloat(br.readLine());
        // Se solicita la tasa anual de interés
        System.out.print("Ingrese la tasa de interés anual (ejemplo 0.05 para 5%): ");
        // Lee la línea, la convierte a float y la guarda en tasaAnual
        tasaAnual = Float.parseFloat(br.readLine());

        // Se crean las instancias según la opción elegida
        // Declaración de la variable, inicializada a null.
        Cuenta cuenta = null;
        //Condicional
        // Inicia el bloque condicional: si la opción es 1 - Cuenta de Ahorros
        if (opcionCuenta == 1) {
            // Crea una nueva instancia de CuentaAhorros y la asigna a 'cuenta'
            cuenta = new CuentaAhorros(saldo, tasaAnual);
            // Confirma la creación de la cuenta de ahorros
            System.out.println("Datos correctos para la Cuenta de Ahorros.\n");
            // Si la opción no es 1, verifica si es 2 - Cuenta Corriente
        } else if (opcionCuenta == 2) {
            // Crea una nueva instancia de CuentaCorriente y la asigna a 'cuenta'
            cuenta = new CuentaCorriente(saldo, tasaAnual);
            // Confirma la creación de la cuenta corriente
            System.out.println("Datos correctos para la Cuenta Corriente.\n");
            // Si la opción no es 1 ni 2
        } else {
            // Informa que la opción es inválida
            System.out.println("Opción inválida. Saliendo del sistema...");
            // Termina la ejecución del métodos main y, por lo tanto, del programa
            return;
        }

        // Bucle de operaciones mientras el usuario no salga
        // Comienza el bucle 'do-while' para el menú de operaciones
        do {
            // Menú de operaciones bancarias
            // Imprime el encabezado del menú
            System.out.println("===== OPERACIONES DISPONIBLES =====");
            // Imprime la opción 1
            System.out.println("1. Depositar dinero");
            // Imprime la opción 2
            System.out.println("2. Retirar dinero");
            // Imprime la opción 3
            System.out.println("3. Generar extracto mensual");
            // Imprime la opción 4
            System.out.println("4. Imprimir estado de cuenta");
            // Imprime la opción 5
            System.out.println("5. Salir");
            // Pide al usuario el número de opción
            System.out.print("Seleccione una opción: ");
            // Lee la opción ingresada, la convierte a entero y la guarda
            opcionOperacion = Integer.parseInt(br.readLine());

            // Inicia la estructura 'switch' basada en la opciones de operación
            switch (opcionOperacion) {
                // Caso 1: Depositar dinero.
                case 1:
                    // Pide la cantidad a depositar
                    System.out.print("Ingrese la cantidad a depositar: ");
                    // Lee la cantidad, la convierte a float y la guarda
                    cantidad = Float.parseFloat(br.readLine());
                    // Comprueba si el objeto 'cuenta' es una instancia de CuentaAhorros
                    if (cuenta instanceof CuentaAhorros)
                        // Si es CuentaAhorros llama al métodos depositar
                        ((CuentaAhorros) cuenta).depositar(cantidad);
                    else
                        // Si es CuentaCorriente llama al métodos depositar
                        ((CuentaCorriente) cuenta).depositar(cantidad);
                    // Confirma el depósito.
                    System.out.println("Depósito realizado.\n");
                    // Sale del switch
                    break;
                // Caso 2: Retirar dinero
                case 2:
                    // Pide la cantidad a retirar
                    System.out.print("Ingrese la cantidad a retirar: ");
                    // Lee la cantidad, la convierte a float y la guarda
                    cantidad = Float.parseFloat(br.readLine());
                    // Comprueba si el objeto 'cuenta' es una instancia de CuentaAhorros
                    if (cuenta instanceof CuentaAhorros)
                        // Si es CuentaAhorros llama al métodos retirar
                        ((CuentaAhorros) cuenta).retirar(cantidad);
                    else
                        // Si es CuentaCorriente llama al métodos retirar
                        ((CuentaCorriente) cuenta).retirar(cantidad);
                    // Confirma el retiro
                    System.out.println("Retiro realizado.\n");
                    // Sale del switch
                    break;
                // Caso 3: Generar extracto mensual
                case 3:
                    // Llama al métodos extractoMensual del objeto 'cuenta'
                    cuenta.extractoMensual();
                    // Confirma la generación del extracto
                    System.out.println("Extracto mensual generado.\n");
                    // Sale del switch
                    break;
                // Caso 4: Imprimir estado de cuenta
                case 4:
                    // Comprueba si el objeto 'cuenta' es una instancia de CuentaAhorros
                    if (cuenta instanceof CuentaAhorros)
                        // Si es CuentaAhorros llama al métodos imprimir
                        ((CuentaAhorros) cuenta).imprimir();
                    // Si no es CuentaAhorros (se asume que es CuentaCorriente).
                    else
                        // Si es CuentaCorriente llama al métodos imprimir
                        ((CuentaCorriente) cuenta).imprimir();
                    // Sale del switch
                    break;
                // Caso 5: Salir
                case 5:
                    // Mensaje de despedida
                    System.out.println("Gracias por usar el sistema bancario.");
                    // Sale del switch
                    break;
                // Caso por defecto para opción inválida
                default:
                    // Informa de la opción inválida
                    System.out.println("Opción inválida, intente nuevamente.\n");
                    // Sale del switch
                    break;
            }
        // Condición del bucle para que se repita mientras la opción de operación no sea 5 - Salir
        } while (opcionOperacion != 5);
    }
}

