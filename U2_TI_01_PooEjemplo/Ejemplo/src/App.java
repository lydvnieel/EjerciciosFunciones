import Model.Circle;
import Model.EquilateralTriangle;
import Model.FigureAbs;
import Model.RectangleTriangle;
import Model.Square;
import Model.Triangle;

public class App {
    public static void main(String[] args) throws Exception {

        FigureAbs sq = new Square(10);
        FigureAbs cir = new Circle(10);
        FigureAbs triangle = new Triangle(20, 25, 20);
        FigureAbs rectriangle = new RectangleTriangle(5, 5, 10, 0);
        FigureAbs equitriangle = new EquilateralTriangle(10);

        FigureAbs[] figures = { sq, cir, triangle, rectriangle,  equitriangle };

        for (FigureAbs figureAbs : figures) {
            System.out.println("La clase es: " + figureAbs.getClass().getSimpleName());
            System.out.println("El area es: " + figureAbs.getArea());
            System.out.println("El perimetro es: " + figureAbs.getPerimeter());
            System.out.println("----------------------------------------------------");
        }

    }
}
