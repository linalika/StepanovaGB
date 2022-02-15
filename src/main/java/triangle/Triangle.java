package triangle;

public class Triangle {

    public static double areaOfTriangle(int a, int b, int c) throws MyException{
        if ((a < b + c) && (b < c + a) && (c < a + b)) {
            float p = (float) ((a+b+c)/2.0);
            float s = (float) Math.sqrt(p*(p-a)*(p-b)*(p-c));
            double scale = Math.pow(10, 3);
            double resultS = Math.ceil(s * scale) / scale;
            return resultS;
        }else throw  new MyException("Это не стороны треугольника");

    }

}
