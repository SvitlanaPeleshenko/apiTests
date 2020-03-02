package api.requests.pet.get;

import api.EndPoints;
import api.responsemodels.pet.Pet;

import static io.restassured.RestAssured.given;

/**
 * Adds user with empId to node with nodeId. Employee stays in old devisions.
 */
public class GetPetById {

    public Pet send(Long petId) {

        return given().get(EndPoints.getPetById, petId).then().extract().body().as(Pet.class);
    }

    public Pet send(Long petId, int expectedStatusCode) {
        return given().get(EndPoints.getPetById, petId).then()
                .statusCode(expectedStatusCode)
                .extract().body().as(Pet.class);
    }
}