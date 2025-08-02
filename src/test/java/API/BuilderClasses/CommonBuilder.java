package API.BuilderClasses;

import io.restassured.response.Response;

import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;

public class CommonBuilder {
        protected final String HEADER_CONTENT_TYPE_KEY = "Content-Type";
        protected final String GET_METHOD = "GET";


        protected Response getResponseFromRequestUsingQueryParams(String APIDOMAIN,LinkedHashMap<String, String> queryParams){
            Response response = given().
                    log().all().
                    contentType("application/json").
                    queryParams(queryParams).
                    when().request(GET_METHOD, APIDOMAIN).
                    then().
                    log().all().
                    extract().
                    response();
            return response;
        }

    protected Response getResponseFromRequest(String APIDOMAIN){
        Response response = given().
                log().all().
                header(HEADER_CONTENT_TYPE_KEY, "application/json").
                when().request(GET_METHOD, APIDOMAIN).
                then().
                log().all().
                extract().
                response();
        return response;
    }


}
