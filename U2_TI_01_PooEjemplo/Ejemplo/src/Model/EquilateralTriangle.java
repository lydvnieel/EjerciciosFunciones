package Model;

public class EquilateralTriangle extends FigureAbs {

      private double side;
      private double height;

      public EquilateralTriangle(double side){
        this.side = side;
        this.height = (Math.sqrt(3)/2) * side;
      }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea(){
        return (Math.sqrt(3) /4 ) * Math.pow(side, 2);
    }
      
    @Override
    public double getPerimeter(){
        return 3 * side;
    }
      

}
