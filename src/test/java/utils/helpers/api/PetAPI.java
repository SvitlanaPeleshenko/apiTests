package utils.helpers.api;

import api.requests.pet.get.FindPetsByStatus;
import api.responsemodels.pet.Pet;
import utils.constants.PetInfo;

import java.util.Random;

import static org.apache.http.HttpStatus.SC_OK;

public class PetAPI {

    public static void main(String[] args) {
    }

    public Pet getRandomPet() {
        Pet[] pets = new FindPetsByStatus()
                .status(PetInfo.Status.AVAILABLE, PetInfo.Status.SOLD, PetInfo.Status.PENDING)
                .send(SC_OK);
        int randomIndex = new Random().nextInt(pets.length);
        return pets[randomIndex];
    }

}
