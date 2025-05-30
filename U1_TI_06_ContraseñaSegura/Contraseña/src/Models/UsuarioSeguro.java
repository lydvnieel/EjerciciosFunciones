package Models;

public class UsuarioSeguro {

    private String nombreUsuario;
    private String password;
    
    public boolean setNombreUsuario (String nombreUsuario) {

      if(nombreUsuario != null && nombreUsuario.isEmpty()){
       System.out.println("Vuelve a escribir tu nombre de usuario, no debe estar vacio...");
            return false;
      }
      
      this.nombreUsuario = nombreUsuario;  
        return true;
    }

    public boolean setPassword(String password) {
       
        if (password.length() < 8){

    System.out.println("Tu contrasenia debe tener como minimo 8 o mas caracteres, incluyendo Mayuscula Minuscula y un Digito");
               return false;
        }

        boolean mayuscula = false;
        boolean minuscula = false;
        boolean digito = false;

        for(int i = 0; i < password.length(); i++){
            if(Character.isUpperCase(password.charAt(i))){
                mayuscula = true;
            }

            if(Character.isLowerCase(password.charAt(i))){
                minuscula = true;
            }
            if(Character.isDigit(password.charAt(i))){
                digito = true;
            }
        }

        if(!mayuscula || !minuscula || !digito ){
            System.out.println("Tu contraseña debe tener minimo una mayuscula, una minuscula y un digito");
            return false;

        }else{
             this.password = password;
             return true;
        }
       
    }

    public boolean autenticarUsuario(String intentPassword){
        return this.password != null && this.password.equals(intentPassword);
    }
        

    public String getNombreUsuario() {

        return nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    }

