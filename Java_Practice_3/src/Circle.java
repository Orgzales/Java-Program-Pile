public class Circle extends Shape
    {
        private static double Qx_cord = 0;
        private static double Qy_cord = 0;
        private static double Qradius = 0;

        public Circle(double x_cord, double y_cord, double radius)
        {

            Qx_cord = x_cord;
            Qy_cord = y_cord;
            Qradius = radius;

        }

        public String toString()
        {
            return "Circle [ X Cord = " + String.valueOf(this.Qx_cord) + " | Y Cord = " + String.valueOf(this.Qy_cord) + " | R: " + String.valueOf(this.Qradius) + "] ";
        }

        public double area()
        {
            double a = Math.PI * (Math.pow(this.Qradius, 2));
            return a;
        }

        public double perimeter()
        {
            double p = 2 * Math.PI * this.Qradius;
            return p;
        }
    }
