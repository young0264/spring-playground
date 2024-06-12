package spring.playground.cloud.openFeign.dynamicUrl;


public class FeignConfigEnv {

    private String baseUrl;

    public FeignConfigEnv(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

}
