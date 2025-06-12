public class EmpleadoTiempoCompleto extends Empleado {

    private int horasTrabajadas;

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public EmpleadoTiempoCompleto(String id, String nombre, double salarioBase, int horasTrabajadas) {
        super(id, nombre, salarioBase);
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSalario(){
        
        return salarioBase;
    
    }

}
