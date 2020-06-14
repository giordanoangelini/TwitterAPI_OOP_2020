package it.SpringBootAPI.ADSProjectOOP.model;

import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import it.SpringBootAPI.ADSProjectOOP.exceptions.TooManyRequestException;
import it.SpringBootAPI.ADSProjectOOP.fetch.FetchClass;

public class User extends FrontUser {
	
	private long ID;
	private String screenName;
	private int characterNumber;
	private int descriptionProperties;
	
	public Vector <User> fillUp() {
		try {
			FetchClass fetchObject = new FetchClass();
			JSONObject jObject = fetchObject.parsing();
			
			JSONArray jArray = (JSONArray) (jObject.get("users"));
			
			Vector <User> userVector = new Vector <User>();
			
			for(Object object : jArray) {
	
				if (object instanceof JSONObject) {
			    	JSONObject object1 = (JSONObject)object; 
			    	
			    	User temp = new User();
			    	temp.ID = (long) object1.get("id");
			    	temp.name = (String) object1.get("name");
			    	temp.screenName = (String) object1.get("screen_name");
			    	temp.description = (String) object1.get("description");
			    	temp.characterNumber = temp.description.length();
			    	temp.descriptionProperties = properties(temp.description);
			    	
			    	userVector.add(temp);
		        }
			}
			return userVector;
		} catch (NullPointerException e) {
			throw new TooManyRequestException("TOO MANY REQUESTS");
		}
	}
	
	private int properties(String text) {
		int p = 0;
		if (isThereDescription(text)) {
			p = 1;
			boolean link = isThereLink(text);
			boolean hashtag = isThereHashtag(text);
			boolean tag = isThereTag(text);
			if (!link && !hashtag &&  tag)  p = 2;
			if (!link &&  hashtag && !tag)  p = 3;
			if (!link &&  hashtag &&  tag)  p = 4;
			if ( link && !hashtag && !tag)  p = 5;
			if ( link && !hashtag &&  tag)  p = 6;
			if ( link &&  hashtag && !tag)  p = 7;
			if ( link &&  hashtag &&  tag)  p = 8;
		}
		return p;
	}
	
	private boolean isThereDescription(String text) {
		if (text.length() == 0) return false;
		else return true;
	}
	
	private boolean isThereLink(String text) {
		if (text.contains(" " + "https://") ||
			text.contains(" " + "www.")) return true;
		return false;
	}
	
	private boolean isThereHashtag(String text) {
		if (text.contains(" " + "#")) return true;
		return false;
	}
	
	private boolean isThereTag(String text) {
		if (text.contains(" " + "@")) return true;
		return false;
	}
	
	public long getID() {
		return ID;
	}

	public String getScreenName() {
		return screenName;
	}

	public int getCharacterNumber() {
		return characterNumber;
	}

	public int getDescriptionProperties() {
		return descriptionProperties;
	}
}
