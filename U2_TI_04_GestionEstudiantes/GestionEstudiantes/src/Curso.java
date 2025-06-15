public class Curso {

     private String codigo;
     private String nombre;
     private Estudiante [] inscritos;

     public Curso(int capacidad) {
        this.codigo = codigo;
        this.nombre = nombre;

        this.inscritos = new Estudiante[capacidad];

     }

     public Estudiante[] getInscritos(){
        return inscritos;
     }

     public Boolean inscribir(Estudiante e) {

        for (int i = 0; i < inscritos.length; i++){
            if(inscritos[i] == null){
                inscritos [i] = e;
                
                return true;
                  
              }
         
           }
        
           return false;
    
     }

     public double calcularPromedioGrupo(){
    
         double sumaPromedio = 0;
         int contarEstudiantes = 0;

        for (int i = 0; i < inscritos.length; i++){
            if(!(inscritos[i] == null)){
                sumaPromedio += inscritos[i].getPromedio();
                 contarEstudiantes++;
    
            }
          
        }

        double promedioFinal = sumaPromedio / contarEstudiantes;
         return promedioFinal;   

      }

       



    }
