package TestCases;

import org.junit.Assert;
import org.junit.Test;

import Resttest.ApiRequest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetAPIRequestTest extends ApiRequest {
	public ApiRequest apiRequest;
	@When("Send GET API Request")
	public void send_get_api_request() {
		apiRequest = new ApiRequest();
		apiRequest.getRequest();
	}

	@When("Check if the response is successfull")
	public void check_if_the_response_is_successfull() {
	apiRequest.validateResponse();
	}

	@Then("Validate using Name {string} and {string} and {string} and {string}")
	public void validate_using_name_and_and_and(String string, String string2, String string3, String string4) {
		int val	=apiRequest.validateData(string, string2,string3,string4);
		Assert.assertEquals(val,1);
	}
}
