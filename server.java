
import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

	public static void main(String[] args) {

		String[] values = { "papier", "stein", "schere" };
		String radomValue = values[(int) (Math.random() * values.length)];
		String message = null, input;

		try {
			ServerSocket socket = new ServerSocket(PORT);
			Socket ss = socket.accept();
			Scanner scan = new Scanner(ss.getInputStream());
			input = scan.next();

			if (radomValue.matches(input)) {
				message = "Unentschieden";

			} else if (radomValue.matches("stein") && input.matches("schere|papier")
					|| radomValue.matches("schere") && input.matches("papier")) {
				message = radomValue + " schälgt " + input + " ! Du hast verloren.";

			} else if (radomValue.matches("papier") && input.matches("stein|schere")
					|| radomValue.matches("schere") && input.matches("stein")) {
				message = input + " schälgt " + radomValue + "! Du hast gewonnen.";
			}

			PrintStream print = new PrintStream(ss.getOutputStream());
			print.println(message);

		} catch (Exception e) {
			System.err.println("Es ist ein Fehler aufgetreten: " + e);
		}
	}
}
