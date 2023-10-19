package starter.stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import models.CardPaymentRequest;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import tasks.PostRequestTask;

public class CardPaymentSteps {
    private Actor actor;


    @Given("el servicio CardPayment")
    public void el_servicio_Cardpayment(){
        actor = new Actor("Fredson");
    }

    @Given("una card para consulta")
    public void una_card_para_consulta(){
        this.actor.whoCan(CallAnApi.at("https://card-payments-c3-gateway-ar-desa.apps.osen02.claro.amx/consult-payment"));

        CardPaymentRequest request = new CardPaymentRequest();
        request.setHierLabelIdReference("STLPagoFact");
        request.setOrderId("lu2360");
        request.setRefTransactionId("TC22122217284400358");

        actor.attemptsTo(PostRequestTask.con(request));


    }

    @Then("the status code should be")
    public void the_status_code_should_be(){
        Question<Integer> elCodigoDeEstado = actor -> SerenityRest.then().extract().statusCode();

        this.actor.should(GivenWhenThen.seeThat("El código de estado debe ser 200", elCodigoDeEstado, IsEqual.equalTo(200)));
    }
}