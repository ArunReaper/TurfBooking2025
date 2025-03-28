package booktheturf.web.war.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * LandingPageDTO is a simple example of a Java bean; a small class that encapsulates a
 * number of values. It exposes an empty constructor and has a number of
 * members that are accessible through getters and setters.
 * 
 * @author Arun Shinde
 */
public class LandingPageDTO implements Serializable {
	/**
	 * Being a serializable class, the bean needs a unique identification
	 * number in order for the Java system to recreate saved objects.
	 */
	@Serial
	private static final long serialVersionUID = -3168349974480377280L;
	
	private List<ImageDTO> imageList;
	/**
	 * Empty constructor.
	 * Gson uses reflection to construct beans. In order to be able to do so, a
	 * bean must expose a constructor that doesn't take any arguments. Its
	 * attributes will be set by Gson upon object creation.
	 */
	public LandingPageDTO() {
	}

	public void setImageList(List<ImageDTO> imageList) {
		this.imageList = imageList;
	}
}
