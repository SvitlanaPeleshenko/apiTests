package api.responsemodels.pet;

import api.responsemodels.common.SimpleEntity;

import java.util.Arrays;

public class Pet {

    public Long id;
    public SimpleEntity category;
    public String name;
    public String[] photoUrls;
    public SimpleEntity[] tags;
    public String status;

    public String toString() {
        return String.format("{id: %s, category: %s, name: %s, photoUrls: %s, tags: %s, status: %s}",
                id, category, name, Arrays.toString(photoUrls), Arrays.toString(tags), status);
    }
}
