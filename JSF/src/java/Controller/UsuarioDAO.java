
package Controller;

import Model.ConexaoJava;
import Model.Usuario;
import java.sql.Connection;
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
public class UsuarioDAO {
    
   private final Connection con = ConexaoJava.getConection();
   
   private String sql ;
   private PreparedStatement prep;
   private ResultSet res;
   
   public boolean gravar(Usuario usuario){
       if(usuario.getId()==0){
           sql = "INSERT INTO USUARIO(LOGIN,SENHA) VALUES(?,?)";
       }
       
       
       try {
           prep =  con.prepareStatement(sql);
           prep.setString(1, usuario.getLogin());
           prep.setString(2,usuario.getSenha() );
           
           prep.execute();
           prep.close();
           return true;
           
       } catch (SQLException ex) {
           Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("Erro no Insert"+ ex);
           return false;
       }
       
   }
   
   public List<Usuario> getByAll(){
       ArrayList<Usuario> lista = new ArrayList();
       sql = "SELECT * FROM USUARIO";
       
       try {
           prep = con.prepareStatement(sql);
           res = prep.executeQuery();
           
           while(res.next()){
               Usuario usu = new Usuario();
               usu.setId(res.getInt("ID"));
               usu.setLogin(res.getString("LOGIN"));
               usu.setSenha(res.getString("SENHA"));
               lista.add(usu);
           }
           prep.close();
           
       } catch (SQLException ex) {
           Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("Erro no Select "+ex);
       }
       return lista;
       
       
   }
   
   
    
    
    
}
