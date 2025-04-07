package booktheturf.web.war.service;

import booktheturf.web.war.dto.ArenaDTO;
import com.google.gson.Gson;
import utility.DatabaseUtility;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArenaService {

    private static final String THIS_COMPONENT_NAME = ArenaService.class.getName();

    private static final String SEL_ALL_ARENAS = "Select * from turfs LIMIT ?";

    public Response getArenas(ArenaDTO requestDTO) throws SQLException, IOException {

        ResultSet rs = DatabaseUtility.executeSelectQuery(SEL_ALL_ARENAS, requestDTO.getNoOfTurfs());
        Gson gson = new Gson();
        System.out.println(THIS_COMPONENT_NAME+ "::rs::" + rs.getRow());
        List<ArenaDTO> listOfArenas = new ArrayList<>();

        while (rs.next()) {
            ArenaDTO arenaDTO = new ArenaDTO();
            arenaDTO.setId(rs.getInt("ID"));
            arenaDTO.setName(rs.getString("NAME"));
            arenaDTO.setDescription(rs.getString("DESCRIPTION"));
            arenaDTO.setLocation(rs.getString("LOCATION"));
            arenaDTO.setSportsAvailable(Arrays.asList(rs.getString("AVAILABLE_SPORTS").split("~")));
            System.out.println(arenaDTO);
            listOfArenas.add(arenaDTO);
        }
        return Response.ok(gson.toJson(listOfArenas)).build();
    }
}
