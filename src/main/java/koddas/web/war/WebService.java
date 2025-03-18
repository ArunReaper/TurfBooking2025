package koddas.web.war;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

/**
 * A very simple web service.
 * 
 * @author Johan Holmberg
 */
@Path("service")  // By altering the argument, you'll change the service's URL
public class WebService {
	
	/**
	 * Prints "It's working" when /wwp-1.0.0/webapi/service is accessed.
	 * 
	 * @return A web response.
	 */
	@GET // This endpoint will be available using GET and GET only 
	@Produces(MediaType.TEXT_PLAIN) // The response will be in plain text.
	public Response root() {
		return Response.ok("It's working").build();
	}
	
	/**
	 * Prints "Hello, World!" when /wwp-1.0.0/webapi/service/hello is accessed.
	 * 
	 * @return A web response.
	 */
	@GET
	@Path("/getLandingPageImages")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLandingPageDetails() {
		String img1 = "https://images.unsplash.com/photo-1523275335684-37898b6baf30?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1099&q=80";
		String img2 = "https://images.unsplash.com/photo-1522040806052-b0aa2b039f00?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=764&q=80";
		String img3 = "https://images.unsplash.com/photo-1652819804299-eea887780ca7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1436&q=80";
		Gson gson = new Gson();
		LandingPageDTO landingPageUtil = new LandingPageDTO();

		landingPageUtil.setImageUrl1(img1);
		landingPageUtil.setImageUrl2(img2);
		landingPageUtil.setImageUrl3(img3);

		gson.toJson(landingPageUtil);

		return Response.ok(gson.toJson(landingPageUtil)).build();
	}

	/**
	 *  Prints current time when /wwp-1.0.0/webapi/service/time is accessed.
	 * 
	 * @return A web response.
	 */
	@GET
	@Path("/time")
	@Produces(MediaType.TEXT_PLAIN)
	public Response time() {
		Response response = null;
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		
		response = Response.ok(df.format(dateobj)).build();
		
		return response;
	}

	/**
	 *  Returns a JSON representation of a LandingPageDTO object when
	 *  /wwp-1.0.0/webapi/service/send is accessed.
	 * 
	 * @param name Mr Bean's new name
	 * @param age Mr Bean's new age
	 * @param nationality Mr Bean's new nationality
	 * @param carBrand The brand of Mr Bean's new car
	 * @return A web response.
	 */
//	@POST
//	@Path("/send")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response send(@FormParam("name") String name,
//			@FormParam("age") int age,
//			@FormParam("nationality") String nationality,
//			@FormParam("car_brand") String carBrand) {
//		Gson gson = new Gson();
//		LandingPageDTO bean = new LandingPageDTO();
//
//		bean.setName(name);
//		bean.setAge(age);
//		bean.setNationality(nationality);
//		bean.setCarBrand(carBrand);
//
//		gson.toJson(bean);
//
//		return Response.ok(gson.toJson(bean)).build();
//	}
	
	/**
	 *  Returns a JSON representation of a LandingPageDTO object and a recipient when
	 *  /wwp-1.0.0/webapi/service/send/{to} is accessed.
	 *  
	 *  The {to} part of the URL can be any URL-encoded string.
	 * 
	 * @param to The name of the recipient of the Mr Bean object
	 * @param name Mr Bean's new name
	 * @param age Mr Bean's new age
	 * @param nationality Mr Bean's new nationality
	 * @param carBrand The brand of Mr Bean's new car
	 * @return A web response.
	 */
//	@POST
//	@Path("/send/{to}") // {to} will map to the to parameter.
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response send(@PathParam("to") String to,
//			@FormParam("name") String name,
//			@FormParam("age") int age,
//			@FormParam("nationality") String nationality,
//			@FormParam("car_brand") String carBrand) {
//		Gson gson = new Gson();
//		LandingPageDTO bean = new LandingPageDTO();
//		Map<String, Object> map = new HashMap<String, Object>();
//
//		bean.setName(name);
//		bean.setAge(age);
//		bean.setNationality(nationality);
//		bean.setCarBrand(carBrand);
//
//		map.put("to", to);
//		map.put("mr_bean", bean);
//
//		gson.toJson(map);
//
//		return Response.ok(gson.toJson(map)).build();
//	}
}
