public class extraMath {
    
    public static void main(String[] args) {
        
        double x = 3.0;
        double y = 4.0;
        double z = -5.0;
        double A, B, C;
        int a = 25;

        A = Math.sqrt(x);
        B = Math.sqrt(y);
        C = Math.sqrt(a);
        System.out.println("A raiz quadrada de " + x + " é: " + A);
        System.out.println("A raiz quadrada de " + y + " é: " + B);
        System.out.println("A raiz quadrada de " + a + " é: " + C);

        A = Math.pow(x, y);
        B = Math.pow(y, 2.0);
        C = Math.pow(5.0, 2.0);
        System.out.println(x + " elevado a " + y + " = " + A);
        System.out.println(x + " elevado ao quadrado = " + B);
        System.out.println("5 elevado ao quadrado = " + C);

        A = Math.abs(y);
        B = Math.abs(z);
        System.out.println("O valor absoluto de " + y + " = " + A);
        System.out.println("O valor absoluto de " + z + " = " + B);

        double b = 10.0;
        double c = 5.0;
        double delta;
        delta = Math.pow(b, 2.0) - 4.0 * a * c;
        System.out.println("O valor de delta é: " + delta);

    }
}