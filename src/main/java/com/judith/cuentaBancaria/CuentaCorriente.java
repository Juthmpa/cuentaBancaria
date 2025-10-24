package com.judith.cuentaBancaria;
/*
 * Autor: Judith Piedra
 * Fecha: 22/10/2025
 * Descripción: Esta clase denominada CuentaCorriente, modela una Cuenta corriente bancaria
 * es una clase hija
 * con el siguiente atributo propio: sobregiro
 * y los atributos heredados de Cuenta: saldo, tasa
 * Así mismo métodos propios: imprimir
 * y métodos heredados de Cuenta: retira, consignar
 */
public class CuentaCorriente extends Cuenta {
    /* atributo sobregiro que identifica si una cuenta
     * no cuenta con el saldo necesario para las transacciones
     * con la condición de si su saldo no es suficiente se pueda
     * aplicar un sobregiro
     */
    private float sobregiro;

    /*Constructor de la clase cuentaCorriente
     * @param saldo Parámetro que define el saldo de la cuenta corriente
     * @param tasa Parámetro que define la tasa anual de interés de la cuenta corriente
     * @param sobregiro Parámetro que define si la cuenta necesita un sobregiro
     */
    public CuentaCorriente(float saldo, float tasa) {
        // Heredamos los atributos de la clase padre
        super(saldo, tasa);
        // Se inicializa el atributo sobregiro en 0
        sobregiro = 0;
    }

    /* Métodos retirar
     * Se llama al métodos padre y sirve para entregar al cliente una cantidad de dinero
     * a retirar y actualiza el saldo de la cuenta corriente y aplica el
     * sobregiro si es necesario
     */
    public void retirar (float cantidad) {
        // Se determina un resultado para saber si necesita el sobregiro
        float resultado = saldo - cantidad;
        // Condición para verificar si la cuenta necesita el sobregiro
        if (resultado <= 0) {
            sobregiro = sobregiro - resultado;
            saldo = 0;
        } else{
            super.retirar(cantidad);
        }
    }

    /* Metodo depositar
     * Se llama al métodos padre y sirve para recibir del cliente una cantidad de dinero
     * a depositar y actualizar el saldo de la cuenta corriente
     */
    public void depositar (float cantidad) {

        float residuo = sobregiro - cantidad;
        //condicional
        if(sobregiro > 0 ) {
            if( residuo > 0) {
                sobregiro = 0;
                saldo = residuo;
        } else {
                sobregiro -= residuo;
                saldo = 0;
            }
        } else {
            super.consignar(cantidad);
        }
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
