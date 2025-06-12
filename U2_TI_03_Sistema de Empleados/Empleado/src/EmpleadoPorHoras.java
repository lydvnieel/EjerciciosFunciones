public class EmpleadoPorHoras extends Empleado {
    
     private int horasTrabajadas;

    public EmpleadoPorHoras(int horasTrabajadas, String id, String nombre, double salarioBase) {
        super(id, nombre, salarioBase);
        this.horasTrabajadas = horasTrabajadas;
    }

     public int getHorasTrabajadas() {
         return horasTrabajadas;
     }

     public void setHorasTrabajadas(int horasTrabajadas) {
         this.horasTrabajadas = horasTrabajadas;
     }

     @Override
     public double calcularSalario(){
        return getSalarioBase() * horasTrabajadas;
     }

}
