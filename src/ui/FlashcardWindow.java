package ui;

import javax.swing.*;
import backend.Flashcard;

public class FlashcardWindow extends JFrame {
    public FlashcardWindow() {
        setTitle("Flashcard Study");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Closes only this window, not the entire app

        FlashcardPanel flashcardPanel = new FlashcardPanel();
        Flashcard sampleFlashcard = new Flashcard("Vang", "Ja", "dsaöl");
        flashcardPanel.showFlashcard(sampleFlashcard);

        add(flashcardPanel);
    }
}