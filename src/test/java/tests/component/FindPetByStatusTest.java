package tests.component;

import api.requests.pet.get.FindPetsByStatus;
import api.responsemodels.pet.Pet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tests.InitTests;
import utils.constants.PetInfo;

import static org.apache.http.HttpStatus.SC_OK;

@DisplayName("Test Suite: Finds Pets by status")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FindPetByStatusTest extends InitTests {

    @Tag("fast")
    @Test
    @DisplayName("\"200 OK\" HTTP status is returned")
    void checkStatusCodeIsOk() {
        new FindPetsByStatus()
                .status(PetInfo.Status.AVAILABLE, PetInfo.Status.SOLD, PetInfo.Status.PENDING)
                .send(SC_OK);
    }

    @DisplayName("Pets with requested status are returned")
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
