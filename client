import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

	public static void main(String[] args) {
		String selection, result;

		try {
			Socket socket = new Socket("IP", PORT);
			Scanner scan = new Scanner(System.in);
			Scanner scanInput = new Scanner(socket.getInputStream());

			do {
				System.out.println("Stein, Schere oder Papier?\n");
				selection = scan.next().toLowerCase().trim();
			} while (!selection.matches("papier|stein|schere"));

			System.out.println("Du hast " + selection + " gewählt\n");

			PrintStream print = new PrintStream(socket.getOutputStream());
			print.println(selection);
			result = scanInput.nextLine();
			System.out.println(result);

		} catch (Exception e) {
			System.err.println("Es ist ein Fehler aufgetreten: " + e);
		}
	}
}
