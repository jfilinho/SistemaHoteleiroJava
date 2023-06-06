/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dados.vconsumo;
import Dados.vprodutos;
import Dados.vquartos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author filin
 */
public class fconsumo {
    private conexao mysql=new conexao();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    public Double totalconsumo;
    
    
    
    public DefaultTableModel mostrar(String buscar){
        
    DefaultTableModel modelo;
    String[] titulos = {"Id Pedido", "Id Reserva", "Id Produto", "Produto", "Quantidade", "Preço Venda", "Estado"};
    String[] registro = new String[7];
    totalregistros = 0;
    totalconsumo = 0.0;
   
    
    
    modelo = new DefaultTableModel(null, titulos);
     sSQL="select c.id_consumo,c.id_reserva,c.id_produto,p.nome,c.quantidade,c.preco_venda "
               + ",c.estado from tb_consumo c inner join tb_produtos p on c.id_produto=p.id_produto"
               + " where c.id_reserva ="+ buscar + " order by c.id_consumo desc";
    
    try{
        Statement st = cn.createStatement();
        ResultSet rs=st.executeQuery(sSQL);
        while(rs.next()){
               registro [0]=rs.getString("id_consumo");
               registro [1]=rs.getString("id_reserva");
               registro [2]=rs.getString("id_produto");
               registro [3]=rs.getString("nome");
               registro [4]=rs.getString("quantidade");
               registro [5]=rs.getString("preco_venda");
               registro [6]=rs.getString("estado");
                
               
               totalregistros = totalregistros +1;
               totalconsumo = totalconsumo + (rs.getDouble("quantidade")* rs.getDouble("preco_venda"));
               
               
               modelo.addRow(registro);
        }
        return modelo;
    }catch (Exception e){
        JOptionPane.showConfirmDialog(null, e);
        return null;
    }
    
    }
    
    public boolean inserir (vconsumo dts){
        sSQL = "insert into tb_consumo (id_reserva, id_produto, quantidade, preco_venda, estado)" +
                "values(?,?,?,?,?)";
        
        try {
            
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getId_reserva());
            pst.setInt(2, dts.getId_produto());
            pst.setDouble(3, dts.getQuantidade());
            pst.setDouble(4, dts.getPreco_venda());
            pst.setString(5, dts.getEstado());
           
            
            int n=pst.executeUpdate();
            if (n!=0){
                return true;
            }else{
                return false;
            }
            
        }catch (Exception e){
             JOptionPane.showConfirmDialog(null, e);
             return false;
        }
    }
    
    public boolean editar (vconsumo dts){
        
        sSQL="update tb_consumo set id_reserva=?, id_produto=?, quantidade=?, preco_venda=?, estado=?" +
                "where id_consumo=?";
        
               
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getId_reserva());
            pst.setInt(2, dts.getId_produto());
            pst.setDouble(3, dts.getQuantidade());
            pst.setDouble(4, dts.getPreco_venda());
            pst.setString(5, dts.getEstado());
          
            pst.setInt(6, dts.getId_consumo());
            
             int n=pst.executeUpdate();
            if (n!=0){
                return true;
            }else{
                return false;
            }
            
        }catch (Exception e){
             JOptionPane.showConfirmDialog(null, e);
         return false;
        }
    }
    
    public boolean deletar (vconsumo dts){
        sSQL="delete from tb_consumo where id_consumo=?";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getId_consumo());
             int n=pst.executeUpdate();
            if (n!=0){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
             JOptionPane.showConfirmDialog(null, e);
             return false;
        }
    }
    

}
