package ui;

import backend.Flashcard;
import javax.swing.*;
import java.awt.*;

public class FlashcardPanel extends JPanel {
	private JLabel vietnameseLabel;
	private JLabel englishLabel;
	
	public FlashcardPanel() {
		setLayout(new GridLayout(3, 1));
		
		vietnameseLabel = new JLabel("", JLabel.CENTER);
		englishLabel = new JLabel("", JLabel.CENTER);
		
		add(vietnameseLabel);
		add(englishLabel);
	}
	
	public void showFlashcard(Flashcard flashcard) {
		vietnameseLabel.setText("Vietnamese: " + flashcard.getVietnamese());
		englishLabel.setText("English: " + flashcard.getEnglish());
	}
	
	
}