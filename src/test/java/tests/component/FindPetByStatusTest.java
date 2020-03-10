package tests.component;

import api.requests.pet.get.FindPetsByStatus;
import api.responsemodels.pet.Pet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import io.qameta.allure.Story;

import tests.InitTests;
import utils.constants.PetInfo;

import static org.apache.http.HttpStatus.SC_OK;

@DisplayName("Test Suite: Finds Pets by status")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FindPetByStatusTest extends InitTests {

    @Test
    @Story("Check status code")
    void checkStatusCodeIsOk() {
        new FindPetsByStatus()
                .status(PetInfo.Status.AVAILABLE, PetInfo.Status.SOLD, PetInfo.Status.PENDING)
                .send(SC_OK);
    }

    @Test
    @Story("Get pets by single status")
    @ParameterizedTest(name = "status: {0}")
    @ValueSource(strings = {PetInfo.Status.AVAILABLE, PetInfo.Status.PENDING, PetInfo.Status.SOLD})
    void checkGetPetsBySingleStatus(String status) {
        Pet[] pets = new FindPetsByStatus()
                .status(status)
                .send();
        softAssertions.assertThat(pets.length).isGreaterThan(0);
        softAssertions.assertThat(pets)
                .extracting(PetInfo.Status.KEY)
                .containsOnly(status);
    }
}
