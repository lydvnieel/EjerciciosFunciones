import Models.UsuarioSeguro;
import javax.swing.JOptionPane;


public class App {
    public static void main(String[] args) throws Exception {

    UsuarioSeguro usuario = new UsuarioSeguro();

    usuario.setNombreUsuario("Daniel");
    usuario.setPassword("Daniel7360");

    String user = JOptionPane.showInputDialog("Ingresa tu usuario:");
    String password = JOptionPane.showInputDialog("Ingresa tu contraseña");

    if(usuario.getNombreUsuario().equals(user) && usuario.getPassword().equals(password)){
        JOptionPane.showMessageDialog(null ,"Acceso concedido");
    }else{
        JOptionPane.showMessageDialog(null, "Acceso denegado");
     }

    }
}
