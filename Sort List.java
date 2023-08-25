package cop2805;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Hw04 {

	public static List<Double> ReadFile(String file) {
	List<Double> numbers = new ArrayList<>();
 	Scanner data = null;
	try {
	data = new Scanner(new File(file));
	while (data.hasNextLine())
	numbers.add(Double.parseDouble(data.next()));
	
	}
	catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
	}
	return numbers;
	}
	
	public static void WriteFile(List<Double> data, String file) {
	try {
	PrintWriter writer = new PrintWriter(new File(file));
	for (Double d: data) {
	System.out.println(d);
	writer.write(String.valueOf(d) + "\n");
	}
	writer.flush();
	writer.close();
	System.out.println("Data has been written to file.");
	}
	catch (FileNotFoundException e) {
	e.printStackTrace();
	}
	}
	
	public static void main(String[] args) {
	List<Double> numbers;
	numbers = ReadFile("data.txt");
	Collections.sort(numbers);
	WriteFile(numbers,"data-sorted.txt");
	}
	}