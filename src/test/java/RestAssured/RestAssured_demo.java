package RestAssured;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RestAssured_demo {

    @Test
    void GetMethorDemo_1() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getContentType());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));

        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test
    void GetMethorDemo_2() {
        //Specify base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response object
        Response response = httpRequest.request(Method.GET, "/albums");
        //Response response=RestAssured.get("https://jsonplaceholder.typicode.com/albums");

        //print response in console window
        String responseBody = response.getBody().asString();
        //System.out.println("Response Body is:" + responseBody);

        //status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode, 200);

        //status line verification
        String statusLine = response.getStatusLine();
        System.out.println("Status line is:" + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");


        System.out.println(response.jsonPath().getInt("id[2]"));

        //Assert.assertEquals(parse(responseBody, 1), "sunt qui excepturi placeat culpa");


    }

    @Test
    void GetMethorDemo_3() throws ParseException {
        //Specify base URI
        RestAssured.baseURI = "https://reqres.in/";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response object
        Response response = httpRequest.request(Method.GET, "/api/users?page=2");


        //print response in console window
        String responseBody = response.getBody().asString();
        //System.out.println("Response Body is:" + responseBody);

        System.out.println(response.jsonPath().getString("support.url"));

    }

    @Test
    void PostMethorDemo() {
        //Specify base URI
        RestAssured.baseURI = "https://reqres.in/";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request paylaod sending along with post request
        JSONObject requestParams = new JSONObject();

        requestParams.put("name", "morpheus");
        requestParams.put("job", "leader");
        requestParams.put("rank", "gold");

        //httpRequest.header("Content-Type", "application/json");
        httpRequest.contentType(ContentType.JSON);

        httpRequest.body(requestParams); // attach above data to the request


        //Response object
        Response response = httpRequest.request(Method.POST, "/api/users");

        //print response in console window

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" + responseBody);
        response.prettyPrint(); // in ra dung form Json

        //status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode, 201);

        //success code validation
        String successCode = response.jsonPath().get("id");
        //Assert.assertEquals(successCode, "27");

    }

    @Test
    void PostMethor_object(){
        //Specify base URI
        RestAssured.baseURI = "https://reqres.in/";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();
        ObjectRequest object = new ObjectRequest();
        object.setName("morpheus");
        object.setJob("leader");
        object.setRank("Gold");
        System.out.println(object);

        httpRequest.contentType(ContentType.JSON);
        httpRequest.body(object);

        //Response object
        Response response = httpRequest.request(Method.POST, "/api/users");

        response.prettyPrint();

        //print response in console window
//        String responseBody = response.getBody().asString();
//        System.out.println("Response Body ob is:" + responseBody);

        //Test @SerializedName
        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        final String json = gson.toJson(object);  //chuyen doi tu object java =>> json
        System.out.println("Json: " + json);

        //chuyen doi tu Json =>> java obj
        final ObjectRequest objectRequest = gson.fromJson(json, ObjectRequest.class);
        System.out.println("Java Object: " + objectRequest);
        System.out.println(objectRequest.getName());
    }

    @Test
    void getHeader() {
        //Specify base URI
        RestAssured.baseURI = "https://maps.googleapis.com";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response object
        Response response = httpRequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

        //print response in console window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" + responseBody);

        System.out.println("Hieu:" + response.getHeader("Content-Type"));

        //validating headers
        String contentType = response.header("Content-Type");// capture details of Content-Type header
        System.out.println("Content Type is:" + contentType);
        Assert.assertEquals(contentType, "application/xml; charset=UTF-8");

        String contentEncoding = response.header("Content-Encoding");// capture details of Content-Encoding  header
        System.out.println("Content Encoding is:" + contentEncoding);
        Assert.assertEquals(contentEncoding, "gzip");

    }

    @Test
    public void getListHeader() {
        //Specify base URI
        RestAssured.baseURI = "https://maps.googleapis.com";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response object
        Response response = httpRequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

        //print response in console window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" + responseBody);

        Headers allHeader = response.headers();

        for (Header header : allHeader) {
            System.out.println(header.getName() + "" + header.getValue());
        }

    }


    public static String parse(String responseBody) {
        JSONArray album = new JSONArray(responseBody);
        for (int i = 0; i < album.length(); i++) {
            org.json.JSONObject jsonObject = album.getJSONObject(i);
            int id = jsonObject.getInt("id");
            //String title = jsonObject.getString("title");
            //System.out.println(id + " " + title);
            System.out.println(id);
        }

        return null;
    }

    public static String parse(String responseBody, int index) {
        JSONArray album = new JSONArray(responseBody);
        org.json.JSONObject jsonObject = album.getJSONObject(index);
        int id = jsonObject.getInt("id");
        String title = jsonObject.getString("title");
        System.out.println(id + " " + title);

        return title;
    }

    private static void parseObject(JSONObject employee) {
        // Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("employee");

        System.out.println(employee);
        // Get employee id
        String id = (String) employeeObject.get("id");
        System.out.println(id);


    }

}

