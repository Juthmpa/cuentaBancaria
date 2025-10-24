package com.judith.cuentaBancaria;
/*
 * Autor: Judith Piedra
 * Fecha: 22/10/2025
 * Descripción: Esta clase denominada Cuenta, modela una Cuenta bancaria
 * con los siguiente atributos: saldo, número de consignación, número de retiros
 * tasa anual de interés y la comisión mensual
 */
public class Cuenta {
    //Atributo que define el saldo de la cuenta bancaria
    protected float saldo;
    /*Atributo de número de consignaciones*/
    protected int numeroConsignacion = 0;
    /*Atributo de número de retiros*/
    protected int numeroRetiro = 0;
    /*Atributo tasa anual*/
    protected float tasaAnual;
    /*Atributo comisión mensual*/
    protected float comisionMensual = 0;

    /*Constructor de la clase cuenta
     * @param saldo Parámetro que define el saldo de la cuenta
     * @param tasaAnual Parámetro que define el interés anual de la cuenta
     */

    public Cuenta(float saldo, float tasaAnual) {
        // Se llama al atributo saldo
        this.saldo = saldo;
        // Se llama al atributo tasa anual
        this.tasaAnual = tasaAnual;
    }

    /*
     * Métodos que recibe una cantidad de dinero
     * @param saldo
     */

    public void consignar(float cantidad) {
        //Se actualiza el saldo con la cantidad que se depositó
        saldo += cantidad;
        //Se actualiza el número de depósitos
        numeroConsignacion += 1;
    }
    /* Métodos para retirar una cantidad de dinero
     * y actualizar el saldo de la cuenta
     * @param cantidad Parámetro que define la cantidad a retirar*/

    public void retirar(float cantidad) {
        float nuevoSaldo = saldo - cantidad;
        // Condicional
        if (nuevoSaldo >= 0) {
            saldo -= cantidad;
            //Incrementamos el número de retiros
            numeroRetiro += 1;
        } else {
            System.out.println("saldo insuficiente");
        }
    }

    /* Métodos para calcular el Valor interes mensual
     *  y el saldo actualizado
     *  */
    public void calcularInteres() {
        //Calculamos el interés mensual
        float tasaMensual = tasaAnual / 12;
        //Valor interes mensual
        float interesMensual = saldo * tasaMensual;
        //Actualizar el saldo
        saldo = saldo + interesMensual;
    }

    /* Métodos para actualizar el saldo restando la comisión mensual
     */
    public void extractoMensual() {
        //actualizamos el saldo restando la comisión mensual
        saldo = saldo - comisionMensual;
        //llamamos el métodos anterior para el cálculo final
        calcularInteres();
    }

}
