package koddas.web.war;

import java.io.Serial;
import java.io.Serializable;

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
	
	private String imageUrl1;
	private String imageUrl2;
	private String imageUrl3;
	
	/**
	 * Empty constructor.
	 * Gson uses reflection to construct beans. In order to be able to do so, a
	 * bean must expose a constructor that doesn't take any arguments. Its
	 * attributes will be set by Gson upon object creation.
	 */
	public LandingPageDTO() {
	}

	public String getImageUrl1() {
		return imageUrl1;
	}

	public void setImageUrl1(String imageUrl1) {
		this.imageUrl1 = imageUrl1;
	}

	public String getImageUrl2() {
		return imageUrl2;
	}

	public void setImageUrl2(String imageUrl2) {
		this.imageUrl2 = imageUrl2;
	}

	public String getImageUrl3() {
		return imageUrl3;
	}

	public void setImageUrl3(String imageUrl3) {
		this.imageUrl3 = imageUrl3;
	}
}
