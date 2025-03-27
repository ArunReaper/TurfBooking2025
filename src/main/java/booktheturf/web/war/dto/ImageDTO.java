package booktheturf.web.war.dto;

public class ImageDTO {

    private String imageDescr;
    private String imageUrl;

    public String getImageDescr() {
        return imageDescr;
    }

    public void setImageDescr(String imageDescr) {
        this.imageDescr = imageDescr;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "ImageDTO{" +
                "imageDescr='" + imageDescr + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
