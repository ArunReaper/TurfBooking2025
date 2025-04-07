package booktheturf.web.war;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.sql.SQLException;
import java.io.IOException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import booktheturf.web.war.dto.ArenaDTO;
import booktheturf.web.war.dto.LoginRequestDTO;
import booktheturf.web.war.dto.UserRegistrationRequestDTO;
import booktheturf.web.war.service.*;

/**
 * A very simple web booktheturf.web.war.service.
 * 
 * @author Arun Shinde
 */
@Path("service")  // By altering the argument, you'll change the booktheturf.web.war.service's URL
public class WebService {

	/**
	 * Prints "It's working" when /wwp-1.0.0/webapi/booktheturf.web.war.service is accessed.
	 *
	 * @return A web response.
	 */
	@GET // This endpoint will be available using GET and GET only
	@Produces(MediaType.TEXT_PLAIN) // The response will be in plain text.
	public Response root() {
		return Response.ok("It's working").build();
	}

	@GET
	@Path("/getLandingPageImages")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLandingPageDetails() throws SQLException, IOException {
		LandingPageService landingPageService = new LandingPageService();
		return landingPageService.getLandingPageDetails();
	}

	@GET
	@Path("/time")
	@Produces(MediaType.TEXT_PLAIN)
	public Response time() {
		Response response;
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();

		response = Response.ok(df.format(dateobj)).build();

		return response;
	}

	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(LoginRequestDTO loginRequestDTO) throws SQLException, IOException {
		LoginService loginService = new LoginService();
		return loginService.login(loginRequestDTO);
	}

	@GET
	@Path("/checkIfUserExists/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean checkIfUserExists(@PathParam("username") String username) throws SQLException, IOException {
		UserService userService = new UserService();
		return userService.checkIfUserExists(username);
	}

	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerUser(UserRegistrationRequestDTO requestDTO) throws SQLException, IOException {
		UserRegistration userRegistration = new UserRegistration();
		return userRegistration.registerUser(requestDTO);
	}

	@GET
	@Path("/getArenas")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getArenas(@PathParam("noOfTurfs") int noOfTurfs) throws SQLException, IOException {
		ArenaService arenaService = new ArenaService();
		ArenaDTO arenaDTO = new ArenaDTO();
		arenaDTO.setNoOfTurfs(noOfTurfs);
		return arenaService.getArenas(arenaDTO);
	}
}
