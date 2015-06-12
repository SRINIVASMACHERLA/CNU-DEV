package spractice.test;

import java.util.List;

import spractice.dao.SuggestionDAO;
import spractice.model.Suggestion;

public class Test {
	public static void main(String[] args) {
		SuggestionDAO dao = new SuggestionDAO();
		List<Suggestion> suggestions = dao.getAllSuggestions();
		for (Suggestion suggestion : suggestions) {
			System.out.println(suggestion);
		}
	}
}
