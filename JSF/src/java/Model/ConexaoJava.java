
package Model;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miromar
 */
public class ConexaoJava {
    
    public static Connection getConection(){
        Connection con = null;
        ConstantesConexao consta =  new ConstantesConexao();
        
        try {
            Class.forName(consta.getDriver());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoJava.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro no Driver"+ ex);
        }
        
        try {
            con = (Connection) DriverManager.getConnection(consta.getUrl(),consta.getUsuario(), consta.getSenha());
            System.out.println("Conectado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoJava.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro na Conexao" + ex);
        }
        
        return con;
    }
    
    public static void main(String[] args) {
        getConection();
    }
    
}
