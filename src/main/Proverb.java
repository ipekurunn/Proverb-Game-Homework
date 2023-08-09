package main;

public class Proverb {
	private String fullTxt;
    private String promptTxt;
    private String origin;

    public Proverb(String fullTxt, String promptTxt, String origin) {
        this.fullTxt = fullTxt;
        this.promptTxt = promptTxt;
        this.origin = origin;
    }

    public String getFullTxt() {
        return fullTxt;
    }

    public String getPromptTxt() {
        return promptTxt;
    }

    public String getOrigin() {
        return origin;
    }
}
