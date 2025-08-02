package API.BuilderClasses;

import io.restassured.response.Response;

import java.util.LinkedHashMap;

public class SearchBuilder extends CommonBuilder{

    private final String APIDOMAIN = "https://api.duckduckgo.com/";


    public Response getSearchResponseSearchingBy(String itemToSearch){
        LinkedHashMap<String, String> queryParams = getQueryParamsBySearchingFor(itemToSearch);
        return getResponseFromRequestUsingQueryParams(APIDOMAIN,queryParams);
    }



    private LinkedHashMap<String, String> getQueryParamsBySearchingFor(String itemToSearch){
        LinkedHashMap<String, String> queryParams = new LinkedHashMap<>();
        queryParams.put("q", itemToSearch);
        queryParams.put("format", "json");
        return queryParams;
    }
}
