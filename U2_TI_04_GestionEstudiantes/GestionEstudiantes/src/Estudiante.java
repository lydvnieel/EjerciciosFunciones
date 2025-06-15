public class Estudiante extends Persona {
     
    private double promedio;


    
    public Estudiante(String nombre, String email, double promedio) {
        super(nombre, email);
        this.promedio = promedio;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    
}


