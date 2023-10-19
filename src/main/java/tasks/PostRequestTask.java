package tasks;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.IRequest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostRequestTask implements Task {
    private final IRequest request;

    public PostRequestTask(IRequest request) {
        this.request = request;
    }

    public static Performable con(IRequest request) {
        return instrumented(PostRequestTask.class, request);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Response response = (Response) RestAssured.given()
                    .baseUri("https://card-payments-c3-gateway-ar-desa.apps.osen02.claro.amx/")
                    .contentType("application/json")
                    .body(this.request)
                    .when()
                    .post("consult-payment");
            String responseBody = response.getBody().asString();
            System.out.println((responseBody));
        } catch (Exception e) {
            System.out.println("se produjo una excepcion durante la solicitud POST: " + e.getMessage());
        }
    }

}
