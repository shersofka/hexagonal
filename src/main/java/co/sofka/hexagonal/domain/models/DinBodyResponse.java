package co.sofka.hexagonal.domain.models;

public class DinBodyResponse {

    private Integer id;

    private String numeroTarjeta;

    private Direccion direccion;

    private Integer numeroProductos;


    public DinBodyResponse(Integer id, String numeroTarjeta, Direccion direccion, Integer numeroProductos) {
        this.id = id;
        this.numeroTarjeta = numeroTarjeta;
        this.direccion = direccion;
        this.numeroProductos = numeroProductos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Integer getNumeroProductos() {
        return numeroProductos;
    }

    public void setNumeroProductos(Integer numeroProductos) {
        this.numeroProductos = numeroProductos;
    }
}
