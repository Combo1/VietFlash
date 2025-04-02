package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import ui.FlashcardWindow;

public class MainApp extends JFrame {
	public MainApp() {
		setTitle("VietFlash");
		setSize(1200, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JLabel titleLabel = new JLabel("Vietnamese Flashcards", JLabel.CENTER);
		add(titleLabel, BorderLayout.NORTH);
		
		JButton reviewButton = new JButton("Review Flashcards");
		reviewButton.addActionListener(new MyReviewListener());
		JButton quizButton = new JButton("Start Quiz");
		quizButton.addActionListener(new MyQuizListener());
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(reviewButton);
		buttonPanel.add(quizButton);
		add(buttonPanel, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new MainApp().setVisible(true));
	}
	
	public class MyReviewListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Build the Flashcard Window
			setVisible(false);
			
			//Open new Flashcard window
			SwingUtilities.invokeLater(() -> new FlashcardWindow().setVisible(true));
		}
	}
	
	public class MyQuizListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			
			SwingUtilities.invokeLater(() -> {
				JFrame frame = new JFrame("Quiz Window");
				
				QuizPanel qp = new QuizPanel();
				frame.add(qp);
				
				frame.setSize(600, 400);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			});
		}
	}
}