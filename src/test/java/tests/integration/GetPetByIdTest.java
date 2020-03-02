package tests.integration;

import api.requests.pet.get.GetPetById;
import api.responsemodels.pet.Pet;
import io.restassured.RestAssured;
import org.assertj.core.api.SoftAssertions;
import org.json.JSONException;
import org.junit.jupiter.api.*;
import tests.InitTests;
import utils.constants.AppInfo;
import utils.helpers.api.PetAPI;

@DisplayName("Test Suite: Find pet by ID")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GetPetByIdTest extends InitTests {

    @Tag("integration")
    @RepeatedTest(2)
    @DisplayName("Requested pet info is returned")
    void checkPetById() {
        Pet randomPet = new PetAPI().getRandomPet();
        Pet foundPet = new GetPetById()
                .send(randomPet.id);
        softAssertions.assertThat(foundPet).isEqualToComparingFieldByFieldRecursively(randomPet);
    }
}
