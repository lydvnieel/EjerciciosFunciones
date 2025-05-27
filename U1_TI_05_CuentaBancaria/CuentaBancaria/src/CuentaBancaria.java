



public class CuentaBancaria {

     private String titular;
     private double saldo;


     public String getTitular() {
          return titular;
     }
     public void setTitular(String titular) {
          this.titular = titular;
     }
     public double getSaldo() {
          return saldo;
     }
       public void setSaldo(double saldo) {
          this.saldo = saldo;
     }
     
     
     public void depositar(double monto){
          if(monto > 0){
          saldo = monto - saldo;
             System.out.println("Operacion realizada con exito. tu nuevo saldo es" + saldo );
          }
     }

     public boolean retirar (double monto){
               if (saldo > 0 && saldo >= monto){
                    saldo -= monto;
                    System.out.println("Operacion realizada con exito. tu nuevo saldo es" + saldo );
                    return true;
               }else{
                    System.out.println("Error no tienes saldo suficiente tienes un saldo de:" + saldo);
                    return false;
               }
     }
    

     




}
