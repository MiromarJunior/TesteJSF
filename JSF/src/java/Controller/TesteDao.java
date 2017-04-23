/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Usuario;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author miromar
 */
public class TesteDao {
    public static void main(String[] args) {
         UsuarioDAO dao  = new UsuarioDAO();
         List<Usuario> lista = dao.getByAll();
    Usuario usu = new Usuario();
//    usu.setLogin(JOptionPane.showInputDialog("Informe o Login"));
//    usu.setSenha(JOptionPane.showInputDialog("Informe a Senha"));
//        
//    dao.gravar(usu);
    
        for (Usuario mj : lista) {
            
            JOptionPane.showMessageDialog(null, "ID : "+mj.getId()+"\n Login : "+mj.getLogin()
            +"\n Senha : "+mj.getSenha());
            System.out.println("\n "+mj.getId());
            System.out.println("\n "+mj.getLogin());
            System.out.println("\n "+mj.getSenha());
        }
    
    
   //JOptionPane.showMessageDialog(null, usu.getLogin()+" "+usu.getSenha());
    
    }
   
    
    
}
