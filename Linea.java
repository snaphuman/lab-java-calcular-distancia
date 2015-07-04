import java.util.Scanner;
import java.util.regex.Pattern;

public class Linea {

    public static void main(String[] args) {

	String punto1 = "";
	String punto2 = "";

	Pattern patron = Pattern.compile("[0-9]+[,][0-9]+");

	// Solicita datos de entrada
	Scanner in = new Scanner(System.in);

	boolean cumple = false;
	while (cumple == false) {
	    System.out.print("Punto 1: ");
	    try {
		punto1 = in.next(patron);	
		cumple = true;
	    } catch (Exception e) {
		System.out.println("No coincide");
		in.nextLine();
		cumple = false;
	    }
	}
	cumple = false;
	while (cumple == false) {
	    System.out.print("Ingrese los valores del punto 2. ie: x,y: ");
	    try {
		punto2 = in.next(patron);
		cumple = true;
	    } catch (Exception e) {
		System.out.println("No coindide");
		in.nextLine();
		cumple = false;
	    }
	}

	double d = calcularDistancia(punto1, punto2);
	
        System.out.println("La distancia entre los dos puntos es: " + d);
	
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


