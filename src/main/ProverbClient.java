package main;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class ProverbClient {
	

    public static void main(String[] args) {
        SimpleProverbManager manager = new SimpleProverbManager();
        manager.readProverbsFromFile();
        manager.shuffleProverbs();

        List<Proverb> proverbs = manager.getProverbs();

        while (true) {
	        Proverb randomProverb = getRandomCountryProverb(proverbs);
	
	        if (randomProverb != null) {
	            String question = generateQuestion(randomProverb);
	            System.out.println(question);
	
	            Scanner scanner = new Scanner(System.in);
	            String userAnswer = scanner.nextLine();
	
	            while (!checkAnswer(randomProverb, userAnswer)) {
	                System.out.println("Incorrect! Please try again.");
	                userAnswer = scanner.nextLine();
	            
	            } 
	            System.out.println("Correct! The proverb is completed correctly.");
	            
	        } 
	        else {
	            System.out.println("No Turkish proverb available.");
	        }
	    }
    }

    public static CountryProverb getRandomCountryProverb(List<Proverb> proverbs) {
        if (proverbs.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(proverbs.size());
        Proverb proverb = proverbs.get(randomIndex);

        if (proverb instanceof CountryProverb) {
            return (CountryProverb) proverb;
        } else {
            return null;
        }
    }

    public static String generateQuestion(Proverb proverb) {
        String fullTxt = proverb.getFullTxt();
        String prompt = proverb.getPromptTxt();
        String origin = proverb.getOrigin();
        
        System.out.println("___________________________________________");

        return "Complete the proverb: \n" + prompt + "..." + " (Origin: " + origin + ")";
    }

    public static boolean checkAnswer(Proverb proverb, String userAnswer) {
        String promptTxt = proverb.getPromptTxt();
        String fullTxt = proverb.getFullTxt();
        String fullTxt_user = promptTxt + " " + userAnswer;
        return fullTxt.equalsIgnoreCase(fullTxt_user);
    }

}
