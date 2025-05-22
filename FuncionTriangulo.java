import Triangle.Triangle;

public class FuncionTriangulo {
    public static void main(String[] args) {
        Triangle tri = new Triangle(); // Objeto triángulo

        tri.setBase(20);
        tri.setAltura(15);
        tri.setLado(10);

        System.out.println(tri.getArea());
        System.out.println(tri.getPerimeter());
    }
}
