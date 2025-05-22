import Circle.Circle;

public class FuncionCirculo {
    public static void main(String[] args) {
        Circle cir = new Circle (); // Objeto circulo

       cir.setPii(3.1416);
       cir.setRadio(20);
       System.out.println(cir.getArea());
       System.out.println(cir.getPerimeter());
    }
}
