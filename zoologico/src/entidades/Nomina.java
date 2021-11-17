/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author luis
 */
public class Nomina {

    int id;
    int idEmpleado;
    int mes;
    int año;
    double cantidad;
    boolean cobrado = false;

    public Nomina() {
    }

    public Nomina(int idNomina, int idEmpleado, int mes, int año, double cantidad) {
        if (idNomina > 0) {
            this.id = idNomina;
        }
        if (idEmpleado > 0) {
            this.idEmpleado = idEmpleado;
        }
        if (mes >= 1 && mes <= 12) {
            this.mes = mes;
        }
        int aa = Date.valueOf(LocalDate.now()).getYear()+1900;
        if (año >= 2000 && año <= aa) {
            this.año = año;
        }
        if (cantidad > 500.00) {
            this.cantidad = cantidad;
        }
        this.cobrado = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int idNomina) {
        if (idNomina > 0) {
            this.id = idNomina;
        }
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        if (idEmpleado > 0) {
            this.idEmpleado = idEmpleado;
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (mes >= 1 && mes <= 12) {
            this.mes = mes;
        }
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        if (año >= 2000 && año <= Date.valueOf(LocalDate.now()).getYear()) {
            this.año = año;
        }
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        if (cantidad > 500.00) {
            this.cantidad = cantidad;
        }
    }

    public boolean isCobrado() {
        return cobrado;
    }

    public void setCobrado(boolean cobrado) {
        this.cobrado = cobrado;
    }

}
