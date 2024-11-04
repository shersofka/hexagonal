package co.sofka.hexagonal.domain.models;

public class DinBodyRequest {

    private Integer id;

    public DinBodyRequest(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
