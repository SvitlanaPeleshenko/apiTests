package api.requests.pet.get;

import api.EndPoints;
import api.responsemodels.pet.Pet;

import static io.restassured.RestAssured.given;

/**
 * Adds user with empId to node with nodeId. Employee stays in old devisions.
 */
public class FindPetsByStatus {

    private String path;

    public FindPetsByStatus status(String status) {
        this.path = EndPoints.findPetsByStatus + "?status=" + status;
        return this;
    }

    public FindPetsByStatus status(String... statuses) {
        // TODO: append params without & at the end of the request string
        this.path = EndPoints.findPetsByStatus + "?";
        for (String status : statuses) {
            this.path = String.format("%sstatus=%s&", this.path, status);
        }
        return this;
    }

    public Pet[] send() {
        return given().when().get(this.path).then().extract().body().as(Pet[].class);
    }

    public Pet[] send(int expectedStatusCode) {
        return given().when().get(this.path).then()
                .statusCode(expectedStatusCode)
                .extract().body().as(Pet[].class);
    }
}