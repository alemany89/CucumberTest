package API.BuilderClasses;

import io.restassured.response.Response;

public class ExternalUrlBuilder extends CommonBuilder {

    public int getStatusCodeFromExternalUrl(String externalUrl){
        Response externalUrlResponse = getResponseFromRequest(externalUrl);
        return externalUrlResponse.getStatusCode();
    }
}
