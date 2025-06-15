public class App {

    
    public static void main(String[] args) throws Exception {

      Curso curso = new Curso (3);

      Estudiante estudiante1 = new Estudiante("Federico", "federico123.utez.edu.mx@gmail.com", 8.8);
      Estudiante estudiante2 = new Estudiante("Juan", "juan123.utez.edu.mx@gmail.com", 9.5);
      Estudiante estudiante3 = new Estudiante("Gabriela", "gabriela.utez.edu.mx@gmail.com", 7.5);
      Estudiante estudiante4 = new Estudiante("Daniel", "daniel.utez.edu.mx@gmail.com", 7.5);
      Estudiante estudiante5 = new Estudiante("Leonardo", "Leonardo.utez.edu.mx@gmail.com", 7.5);


      
      curso.inscribir(estudiante1);
      curso.inscribir(estudiante2);
      curso.inscribir(estudiante3);
      curso.inscribir(estudiante4);
      curso.inscribir(estudiante5);

      for(Estudiante e : curso.getInscritos()){
            System.out.println(">--------------------------------------------<");
            System.out.println("Estudiante:" + e.getNombre());
            System.out.println("Email:" + e.getEmail());
            System.out.println("Promedio:" + e.getPromedio());
            System.out.println(">--------------------------------------------<");
            System.out.println("\n");
        
      }
      
      


      System.out.println("\n >--- Resultados ---<");
      double promedio = curso.calcularPromedioGrupo();
      System.out.println("El promedio general del curso es de:" + promedio);
    }
}