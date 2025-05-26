import Circle.Circle;

public class FuncionCirculo {
    public static void main(String[] args) {
        Circle cir = new Circle (); // Objeto circulo

       cir.setPii(3.1416);
       cir.setRadio(20);
       System.out.println("Area:" + cir.getArea());
       System.out.println("Perimetro:" + cir.getPerimeter());
    }
}
