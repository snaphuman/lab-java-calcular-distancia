import java.util.Scanner;
import java.util.regex.Pattern;

public class Linea {

    static Pattern patron = Pattern.compile("[0-9]+[,][0-9]+");

    public static void main(String[] args) {

	// Solicita datos de entrada
	Scanner in = new Scanner(System.in);

	int contador = 1;

	String punto1 = verificarEntrada(in, contador);
	contador ++;
	String punto2 = verificarEntrada(in, contador);
	
	double d = calcularDistancia(punto1, punto2);
	
        System.out.println("La distancia entre los dos puntos es: " + d);
	
    }

    private static String verificarEntrada(Scanner in, int contador) {
	String punto = "";

	boolean cumple = false;
	while (cumple == false) {
	    System.out.print("Punto " + contador + ": ");
	    try {
		punto = in.next(patron);	
		cumple = true;

	    } catch (Exception e) {
		System.out.println("Por favor verifique el formato del punto. ej: x,y");
		in.nextLine();
		cumple = false;
	    }
	}

	return punto;
    }

    public static double calcularDistancia(String punto1, String punto2) {
	// Obtener coordenadas manipulando el string

	double p1x = getX(punto1);
	double p1y = getY(punto1);

	double p2x = getX(punto2);
	double p2y = getX(punto2);

	double d = Math.sqrt(Math.pow((p2x - p1x),2) + Math.pow((p2y - p1y),2));

	return d;
	
    }

    private static int getX (String punto) {
	String[] partes = punto.split(",");
	return Integer.parseInt(partes[0]);
    }

    private static int getY (String punto) {
	String[] partes = punto.split(",");
	return Integer.parseInt(partes[partes.length-1]);
    }
    
}


