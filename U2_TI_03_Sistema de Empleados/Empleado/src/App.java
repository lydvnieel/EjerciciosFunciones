public class App {

    public static void main(String[] args) throws Exception {

        EmpleadoTiempoCompleto EmpleadoTiempoCompleto = new EmpleadoTiempoCompleto("1_Daniel", "Daniel", 5000,  26);

        EmpleadoPorHoras EmpleadoPorHoras = new EmpleadoPorHoras(16, "1_Daniel", "Daniel ", 5000);
        System.out.println("------------------------------------------------------------------");
        System.out.println("Empleado tiempo completo:" + EmpleadoTiempoCompleto.calcularSalario());
        System.out.println("Empleado por horas:" + EmpleadoPorHoras.calcularSalario());
        System.out.println("------------------------------------------------------------------");
    }
}
