/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import java.sql.Date;

/**
 *
 * @author filin
 */
public class vreservas {
    private int id_reserva;
    private int id_quartos;
    private int id_cliente;
    private int id_funcionario;
    private String tipo_reserva;
    private Date data_reserva;
    private Date data_entrada;
    private Date data_saida;
    private Double valor_quarto;
    private String estado;

    public vreservas() {
    }

    public vreservas(int id_reserva, int id_quartos, int id_cliente, int id_funcionario, String tipo_reserva, Date data_reserva, Date data_entrada, Date data_saida, Double valor_quarto, String estado) {
        this.id_reserva = id_reserva;
        this.id_quartos = id_quartos;
        this.id_cliente = id_cliente;
        this.id_funcionario = id_funcionario;
        this.tipo_reserva = tipo_reserva;
        this.data_reserva = data_reserva;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
        this.valor_quarto = valor_quarto;
        this.estado = estado;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getId_quartos() {
        return id_quartos;
    }

    public void setId_quartos(int id_quartos) {
        this.id_quartos = id_quartos;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getTipo_reserva() {
        return tipo_reserva;
    }

    public void setTipo_reserva(String tipo_reserva) {
        this.tipo_reserva = tipo_reserva;
    }

    public Date getData_reserva() {
        return data_reserva;
    }

    public void setData_reserva(Date data_reserva) {
        this.data_reserva = data_reserva;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Date getData_saida() {
        return data_saida;
    }

    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }

    public Double getValor_quarto() {
        return valor_quarto;
    }

    public void setValor_quarto(Double valor_quarto) {
        this.valor_quarto = valor_quarto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
