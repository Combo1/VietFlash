package backend;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlashcardDatabase {
	private static final String DB_URL = "jdbc:sqlite:C:/sqlite/flashcards.db";
	
	public FlashcardDatabase() {
		try(Connection conn = DriverManager.getConnection(DB_URL)) {
			String sql = "CREATE TABLE IF NOT EXISTS flashcards (id INTEGER PRIMARY KEY, vietnamese TEXT, english TEXT, pronounciation TEXT)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addFlashcard(Flashcard fc) {
		try (Connection conn = DriverManager.getConnection(DB_URL)) {
			String sql = "INSERT INTO flashcards (vietnamese, english, pronouciation) VALUES (?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, fc.getVietnamese());
			stmt.setString(2, fc.getVietnamese());
			stmt.setString(3, fc.getPronunciation());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Flashcard> getFlashcards() {
		List<Flashcard> ls = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(DB_URL)) {
			String sql = "SELECT * FROM flashcards";
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				Flashcard fc = new Flashcard(rs.getString("vietnamese"), rs.getString("english"), rs.getString("pronounciation"));
				ls.add(fc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
}