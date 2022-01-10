package RestAssured;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class PushMethor {
//    @BeforeAll
//    static void init() {
//        RestAssured.baseURI = "https://reqres.in/";
//        RestAssured.basePath = "/api/users";
//        RestAssured.port = 8080;
//    }

    @Test
    void postNewStudent() {
        RestAssured.baseURI = "https://reqres.in/";

        ObjectRequest object = new ObjectRequest();
        object.setName("morpheus");
        object.setJob("leader");
        object.setRank("Gold");
//        List<String> courses = new ArrayList<>();
//        courses.add("Math");
//        courses.add("Economics");
//
//        Student student = new Student();
//        student.setId(101);
//        student.setFirstName("Giang");
//        student.setLastName("Nguyen");
//        student.setEmail("giang.nguyen@gc.com");
//        student.setProgramme("Computer Science");
//        student.setCourses(courses);

        Response res = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body(object)
                .request(Method.POST,"/api/users");
        res.prettyPrint();
        //System.out.println(res.getBody().asString());
       // res.then().statusCode(201).body("msg", equalTo("Student added"));

        //System.out.println(res.jsonPath().getString("name"));

        //Test @SerializedName
        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        final String json = gson.toJson(object);
        System.out.println("Json: " + json);

        //chuyen doi tu Json =>> java obj
        final ObjectRequest objectRequest = gson.fromJson(json, ObjectRequest.class);
        System.out.println("Java Object: " + objectRequest);
    }
}
