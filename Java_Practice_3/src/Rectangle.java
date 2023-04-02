public class Rectangle extends Shape
{
    private double Qtopcord_x = 0;
    private double Qtopcord_y = 0;
    private double Qheight = 1;
    private double Qwidth = 1;

    public Rectangle(double x_cord, double y_cord, double height, double width)
    {
        Qtopcord_x = x_cord;
        Qtopcord_y = y_cord;
        Qheight = height;
        Qwidth = width;

    }

    public String toString()
    {
        return "Rectangle [ X Cord = " + String.valueOf(this.Qtopcord_x) + " | Y Cord = " + String.valueOf(this.Qtopcord_y) + " | H: " + String.valueOf(this.Qheight) + " | W: " + String.valueOf(this.Qwidth) + "]" ;
    }

    public double area() {
        return this.Qheight * this.Qwidth;
    }

    public double perimeter() {
        return (this.Qheight * 2) + (this.Qwidth * 2);
    }
}
