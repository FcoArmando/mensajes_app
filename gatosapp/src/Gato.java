public class Gato {
    String id;
    String url;
    String apiKey = "live_bCQECldoqOBHfmmqXORTWwXJH7yEfte3MAmuGVUOp83dxbQqBGECiSGLbSHGteP0";
    String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = String.valueOf(id);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
