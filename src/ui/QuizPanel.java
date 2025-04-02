package ui;

import backend.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Random;

public class QuizPanel extends JPanel {
	private JLabel questionLabel;
	private JTextField answerField;
	private JButton checkButton;
	private Flashcard currentFlashcard;
	private List<Flashcard> flashcards;
	private FlashcardDatabase db;
	private Random random = new Random();
	
	public QuizPanel() {
		db = new FlashcardDatabase();
		flashcards = db.getFlashcards();
		
		setLayout(new GridLayout(3, 1));
		
		questionLabel = new JLabel("", JLabel.CENTER);
		answerField = new JTextField();
		answerField.setText("Write your answer here!");
		checkButton = new JButton("Check");
		
		checkButton.addActionListener(this::checkAnswer);
		
		add(questionLabel);
		add(answerField);
		add(checkButton);
		
		loadNewQuestion();
	}
	
	private void loadNewQuestion() {
		if(flashcards.isEmpty()) {
			questionLabel.setText("No flashcards available.");
			return;
		}
		currentFlashcard = flashcards.get(random.nextInt(flashcards.size()));
		questionLabel.setText("Translate: " + currentFlashcard.getVietnamese());
	}
	
	private void checkAnswer(ActionEvent e) {
		String userAnswer = answerField.getText().trim();
		if(userAnswer.equalsIgnoreCase(currentFlashcard.getEnglish())) {
			JOptionPane.showMessageDialog(this, "Correct!");
		} else {
			JOptionPane.showMessageDialog(this, "Wrong! Correct answer: " + currentFlashcard.getEnglish());
		}
	}
}