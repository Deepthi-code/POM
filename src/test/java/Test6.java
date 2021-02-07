class Shape
{
    private double height;
    private double width;

    public Shape(double h, double w)
    {
        this.height = h;
        this.width = w;
    }
    public void setHeight(double val)
    {
        this.height = val;
    }
    public void setWidth(double val)
    {
        this.width = val;
    }

    public double getHeight()
    {
        return height;
    }

    public double getWidth()
    {
        return width;
    }
}

class Rectangle extends Shape
{
    Rectangle (double x, double y)
    {
        super(x,y);
    }

    public double getArea()
    {
        return getHeight() * getWidth();
    }
}

class Triangle extends Shape
{
    Triangle (double x, double y)
    {
        super(x,y);
    }
    public double getArea()
    {
        return (getHeight() * getWidth()) / 2;
    }
}

public class Test6
{
    public static void main(String[] args)
    {
        Rectangle rect = new Rectangle(3,5);
        System.out.println("Area of rectangle : " + rect.getArea());

        Triangle tri = new Triangle(3, 5);
        System.out.println("Area of triangle : " + tri.getArea());
    }
}