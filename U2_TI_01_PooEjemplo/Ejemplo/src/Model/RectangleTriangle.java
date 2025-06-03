package Model;

public class RectangleTriangle extends FigureAbs {

    private double aside;
    private double bside;
    private double base;
    private double hypotenuse;

    public RectangleTriangle(double aside, double bside, double base, double hypotenuse){
        this.aside = aside;
        this.bside = bside;
        this.base = base;
        this.hypotenuse = hypotenuse;
    }

    public double getAside() {
        return aside;
    }

    public void setAside(double aside) {
        this.aside = aside;
    }

    public double getBside() {
        return bside;
    }

    public void setBside(double bside) {
        this.bside = bside;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    
    public void setHypotenuse(double hypotenuse) {
        this.hypotenuse = hypotenuse;
    }

    @Override
    public double getArea(){
        return (aside * bside) / 2;
    }
    @Override
    public double getPerimeter(){
        return aside + bside + hypotenuse;
    }

    public double getHypotenuse(){
        return aside * aside + bside * bside;
    }

   

}
