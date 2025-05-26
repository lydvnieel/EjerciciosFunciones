import Triangle.Triangle;

public class FuncionTriangulo {
    public static void main(String[] args) {
        Triangle tri = new Triangle(); // Objeto triángulo

        tri.setBase(20);
        tri.setAltura(15);
        tri.setLado(10);

        System.out.println("Area:" + tri.getArea());
        System.out.println("Perimetro:" + tri.getPerimeter());
    }
}
