package koddas.web.war;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * LandingPageDTO is a simple example of a Java bean; a small class that encapsulates a
 * number of values. It exposes an empty constructor and has a number of
 * members that are accessible through getters and setters.
 * 
 * @author Johan Holmberg
 */
public class LandingPageDTO implements Serializable {
	/**
	 * Being a serializable class, the bean needs a unique identification
	 * number in order for the Java system to recreate saved objects.
	 */
	@Serial
	private static final long serialVersionUID = -3168349974480377280L;
	
	private List<List<String>> imageUrlList;
	/**
	 * Empty constructor.
	 * Gson uses reflection to construct beans. In order to be able to do so, a
	 * bean must expose a constructor that doesn't take any arguments. Its
	 * attributes will be set by Gson upon object creation.
	 */
	public LandingPageDTO() {
	}

	public List<List<String>> getImageUrlList() {
		return imageUrlList;
	}

	public void setImageUrlList(List<List<String>> imageUrlList) {
		this.imageUrlList = imageUrlList;
	}
}
