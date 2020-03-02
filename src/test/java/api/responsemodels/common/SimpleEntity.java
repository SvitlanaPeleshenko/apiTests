package api.responsemodels.common;

public class SimpleEntity {
    public Long id;
    public String name;

    public String toString() {
        return String.format("{id: %s, name: %s}", id, name);
    }
}
