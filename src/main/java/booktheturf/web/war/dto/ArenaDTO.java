package booktheturf.web.war.dto;

import java.math.BigDecimal;
import java.util.List;

public class ArenaDTO {

    private int id;

    private String name;

    private String description;

    private String location;

    private BigDecimal bookingPrice;

    private List<String> sportsAvailable;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getBookingPrice() {
        return bookingPrice;
    }

    public void setBookingPrice(BigDecimal bookingPrice) {
        this.bookingPrice = bookingPrice;
    }

    public List<String> getSportsAvailable() {
        return sportsAvailable;
    }

    public void setSportsAvailable(List<String> sportsAvailable) {
        this.sportsAvailable = sportsAvailable;
    }
}
