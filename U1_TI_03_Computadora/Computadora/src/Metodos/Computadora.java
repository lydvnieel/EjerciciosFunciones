package Metodos;
public class Computadora {

     private String marca;
     private String modelo;
     private boolean encendida;
     
     public String getMarca() {
         return marca;
     }
     public String getModelo() {
         return modelo;
     }
     public Boolean getEncendida() {
         return encendida;
     }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean encender(){

        if(!encendida){
            encendida = true;
            System.out.println("Encendiendo...");
            return true;
        }
        else{
            System.out.println("Ya lo encendiste");
            return false;
        }
    }
    
    public boolean apagar(){
        if(encendida){
            encendida = false;
            System.out.println("Apagando...");  
            return true;  
        }
        else{
            System.out.println("Ya lo apagaste");
            return false;
        }
    }
}
