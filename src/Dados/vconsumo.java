/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

/**
 *
 * @author filin
 */
public class vconsumo {
    private int id_consumo;
    private int id_reserva;
    private int id_produto;
    private Double quantidade;
    private Double preco_venda;
    private String estado;

    public vconsumo() {
    }

    public vconsumo(int id_consumo, int id_reserva, int id_produto, Double quantidade, Double preco_venda, String estado) {
        this.id_consumo = id_consumo;
        this.id_reserva = id_reserva;
        this.id_produto = id_produto;
        this.quantidade = quantidade;
        this.preco_venda = preco_venda;
        this.estado = estado;
    }

    public int getId_consumo() {
        return id_consumo;
    }

    public void setId_consumo(int id_consumo) {
        this.id_consumo = id_consumo;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(Double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
