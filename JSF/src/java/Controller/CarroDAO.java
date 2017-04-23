
package Controller;

import Bean.Carro;
import Model.ConexaoJava;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miromar
 */
public class CarroDAO {
    
    private String sql;
    private PreparedStatement prep;
    private ResultSet res;
    private final Connection con = ConexaoJava.getConection();
    
    public boolean insert(Carro carro){
        sql = "INSERT INTO CARRO(MODELO,FABRICANTE,COR,ANO) VALUES(?,?,?,?)";
        try {
            prep = con.prepareStatement(sql);
            prep.setString(1, carro.getModelo());
            prep.setString(2,carro.getFabricante());
            prep.setString(3, carro.getCor());
            prep.setDate(4, new Date (carro.getAno().getTime()));
            prep.execute();
            prep.close();
           
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro no Insert "+ex);
            return false;
        }
        
        
    }
    
    public List<Carro> select(){
        List<Carro> lista = new ArrayList<>();
        
        sql = "SELECT*FROM CARRO";
        
        try {
            prep = con.prepareStatement(sql);
            res = prep.executeQuery();
            while(res.next()){
                Carro carro = new Carro();
                carro.setModelo(res.getString("MODELO"));
                carro.setFabricante(res.getString("FABRICANTE"));
                carro.setCor(res.getString("COR"));
                carro.setAno(res.getDate("ANO"));
                lista.add(carro);
            }
            prep.close();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Err no Select "+ex);
        }
        return lista;
    }
    public static void main(String[] args) {
        new CarroDAO().select();
        
      
    }

    
    
}
