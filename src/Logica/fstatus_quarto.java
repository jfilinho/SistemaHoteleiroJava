/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dados.vquartos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author filin
 */
public class fstatus_quarto {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    ArrayList<vquartos> lista = new ArrayList<>();

    public ArrayList<vquartos> PesquisarQuartos() {
        String sql = "select * from tb_quartos";
        con = new conexao().conectar();

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                vquartos quartos = new vquartos();
                quartos.setIdquartos(rs.getInt("id_quartos"));
                quartos.setNumero(rs.getString("numero"));
                quartos.setAndar(rs.getString("andar"));
                quartos.setDescricao(rs.getString("descricao"));
                quartos.setCaracteristicas(rs.getString("caracteristicas"));
                quartos.setValordiaria(rs.getDouble("preco_diaria"));
                quartos.setEstado(rs.getString("estado"));
                quartos.setTipoquarto(rs.getString("tipo_quarto"));

                lista.add(quartos);
                
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "fquartos Pesquisar Quarto: " + erro);
        }
        return lista;
    }

}
