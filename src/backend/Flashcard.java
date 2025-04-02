package backend;

public class Flashcard {
    private String vietnameseWord;
    private String englishWord;
    private String pronunciation;
    
    
    public Flashcard(String vietnameseWord, String englishWord, String pronunciation) {
    	this.vietnameseWord = vietnameseWord;
    	this.englishWord = englishWord;
    	this.pronunciation = pronunciation;
    }
    
    public String getVietnamese() {
    	return vietnameseWord;
    }
    
    public String getEnglish() {
    	return englishWord;
    }
    
    public String getPronunciation() {
    	return pronunciation;
    }
    
}