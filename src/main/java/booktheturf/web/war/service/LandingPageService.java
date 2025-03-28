package booktheturf.web.war.service;


import com.google.gson.Gson;
import booktheturf.web.war.dto.ImageDTO;
import booktheturf.web.war.dto.LandingPageDTO;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LandingPageService
{

	private static final String THIS_COMPONENT_NAME = LandingPageService.class.getName();

	public Response getLandingPageDetails() throws SQLException, IOException {
		Gson gson = new Gson();
		LandingPageDTO landingPageUtil = getDataFromDatabase();

		gson.toJson(landingPageUtil);
		return Response.ok(gson.toJson(landingPageUtil)).build();
	}

	private LandingPageDTO getDataFromDatabase() throws SQLException, IOException {
		System.out.println("getDataFromDatabase");
		List<ImageDTO> imageList = new ArrayList<>();
		LandingPageDTO landingPageUtil = new LandingPageDTO();
		ResultSet rs = utility.DatabaseUtility.executeSelectQuery("SELECT * FROM LANDINGPAGE");

		while (rs.next()) {
			ImageDTO imageDTO = new ImageDTO();
			imageDTO.setImageDescr(rs.getString("IMG_DESCR"));
			imageDTO.setImageUrl(rs.getString("IMG_URL"));
			imageList.add(imageDTO);
		}

		System.out.println(imageList);
		landingPageUtil.setImageList(imageList);
		return landingPageUtil;
	}
}
