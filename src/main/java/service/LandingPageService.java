package service;


import com.google.gson.Gson;
import dto.ImageDTO;
import dto.LandingPageDTO;
import koddas.web.war.DatabaseConnection;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LandingPageService
{
	public Response getLandingPageDetails() throws SQLException, IOException {
		Gson gson = new Gson();
		LandingPageDTO landingPageUtil = getDataFromDatabase();

		gson.toJson(landingPageUtil);
		return Response.ok(gson.toJson(landingPageUtil)).build();
	}

	private LandingPageDTO getDataFromDatabase() throws SQLException, IOException {
		System.out.println("getDataFromDatabase");
		LandingPageDTO landingPageUtil = new LandingPageDTO();

		Connection conn = DatabaseConnection.getConnection();
		assert conn != null;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM LANDINGPAGE");

		List<ImageDTO> imageList = new ArrayList<>();

		while (rs.next()) {
			ImageDTO imageDTO = new ImageDTO();
			imageDTO.setImageDescr(rs.getString("IMG_DESCR"));
			imageDTO.setImageUrl(rs.getString("IMG_URL"));
			imageList.add(imageDTO);
		}

		System.out.println(imageList);
		landingPageUtil.setImageList(imageList);
		rs.close();
		stmt.close();
		//conn.close(); // Don't close the connection here when using a connection pool
		return landingPageUtil;
	}
}
