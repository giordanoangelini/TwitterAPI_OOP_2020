package it.SpringBootAPI.ADSProjectOOP.util.filters;

import it.SpringBootAPI.ADSProjectOOP.model.*;

import java.util.Vector;

public class FilterLink extends Filter {
	
	public boolean filter (User friends) {
		int param = friends.getDescriptionProperties();
		if (param == 5 || param == 6 || param == 7 || param == 8) 
		return true;
		else
		return false;
	}
	
	public Vector <FrontUser> filterLink() {
		Filter obj = new Filter();
		Vector <FrontUser> vector = obj.filterVector();
		return vector;
	}
}