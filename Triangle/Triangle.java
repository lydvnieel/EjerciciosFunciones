package Triangle;

public class Triangle {
    private double Base;
    private double Altura;
    private double Lado;

    public double getArea() {
        return (Base * Altura) / 2;
    }

    public double getPerimeter() {
        return Lado + Lado + Lado; // Perímetro de triángulo isósceles
    }

    public void setBase(double base) {
        this.Base = base;
    }

    public void setAltura(double altura) {
        this.Altura = altura;
    }

    public void setLado(double lado) {
        this.Lado = lado;
    }
}
