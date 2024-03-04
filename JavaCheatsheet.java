import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class JavaCheatsheet {

	public void readFileWordByWord(String fileName) {
		try {
			Scanner s = new Scanner(new BufferedReader(new FileReader(fileName)));
			while (s.hasNext()) {
				String word = s.next();
				System.out.println(word);
			}

			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readFileLineByLine(String fileName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeToFile(String fileName) {
		try {
			PrintWriter writer = new PrintWriter(new FileWriter(fileName));
			writer.println("hello    world  world");
			writer.println(" world  \t good by");

			System.out.println("finish");
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JavaCheatsheet javaCheatsheet = new JavaCheatsheet();
		String fileName = "Downloads/file1.txt";

		javaCheatsheet.readFileWordByWord(fileName);
		// javaCheatsheet.readFileLineByLine(fileName);
		// javaCheatsheet.writeToFile(fileName);
	}
}
