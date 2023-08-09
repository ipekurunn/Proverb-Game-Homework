package main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SimpleProverbManager {
	private List <Proverb> proverbs;
	
	public SimpleProverbManager() {
		proverbs = new ArrayList<>();
	}
	
	public void readProverbsFromFile() {
	    String CountryProverbs = "CountryProverbs.txt";
	    try (BufferedReader reader = new BufferedReader(new FileReader("CountryProverbs.txt"))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] parts = line.split("\t");
	            if (parts.length == 3) {
	                String fullTxt = parts[0].trim();
	                String promptTxt = parts[1].trim();
	                String origin = parts[2].trim();
	                CountryProverb proverb = new CountryProverb(fullTxt, promptTxt, origin);
	                proverbs.add(proverb);
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public void shuffleProverbs() {
		Collections.shuffle(proverbs);
	}
	
	public List<Proverb> getProverbs() {
		return proverbs;
	}

}
