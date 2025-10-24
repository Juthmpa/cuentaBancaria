package com.judith.cuentaBancaria;
/*
 * Autor: Judith Piedra
 * Fecha: 22/10/2025
 * Descripción: Esta clase denominada CuentaAhorros, modela una CuentaAhorros
 * es una clase hija de Cuenta
 * con el siguiente atributo propio: activa
 * y los atributos heredados de Cuenta: saldo, tasa
 * Así mismo métodos propios: imprimir
 * y métodos heredados de Cuenta: retirar, consignar, extractoMensual
 */

public class CuentaAhorros extends Cuenta {
    /* atributo activa que identifica si una cuenta está activa,
     * con la condición de si su saldo es superior a 10usd
     */
    private boolean activa;

    /*Constructor de la clase cuentaAhorros
     * @param saldo Parámetro que define el saldo de la cuenta de ahorros
     * @param tasa Parámetro que define la tasa anual de interés de la cuenta de ahorros
     * @param activa Parámetro que define si la cuenta está activa o inactiva
     */
    public CuentaAhorros(float saldo, float tasa) {
        //Heredamos los atributos de la clase padre
        super(saldo, tasa);
        //Condicional para saber si está activa o inactiva
        if (saldo < 10)
            activa = false;
        else
            activa = true;
        }

    /* Métodos retirar
     * Se llama al métodos padre y sirve para entregar al cliente una cantidad de dinero
     * a retirar y actualiza el saldo de la cuenta de ahorros
     */
    public void retirar (float cantidad) {
        //Condición para verificar si la cuenta está activa
        if (activa)
            super.retirar(cantidad);
    }

    /* Metodo depositar
     * Se llama al métodos padre y sirve para recibir del cliente una cantidad de dinero
     * a depositar y actualiza el saldo de la cuenta de ahorros
     */
    public void depositar (float cantidad) {
        //condicional
        if(activa)
            super.consignar(cantidad);
    }

    /* Métodos Extracto mensual
     * Se llama al métodos padre y sirve para generar el extracto mensual de la cuenta de ahorros
     */
    public void extractoMensual() {
        /*Condicional de retiros*/
        if(numeroRetiro>4){
            comisionMensual = comisionMensual + (numeroRetiro - 4) * 1;
        }
        //llamamos al métodos padre;
        super.extractoMensual();
        //Condicional para saber si la cuenta está activa o no
        if(saldo< 10)
            activa = false;
    }

    /* Métodos imprimir
     * Muestra en la pantalla los datos de una cuenta de ahorros
     */

    public void imprimir() {
        // Se imprime el saldo de la cuenta de ahorros
        System.out.println("Saldo: " + saldo);
        // Se imprime la comisión mensual de la cuenta de ahorros
        System.out.println("Comisión mensual : $ " + comisionMensual);
        // Se muestra el número de transacciones tanto depósitos como retiros
        System.out.println("Número transacciones: " + (numeroConsignacion + numeroRetiro));
        // Se da un espacio
        System.out.println();

    }
}