package co.sofka.hexagonal.infrastructure.entities;


import co.sofka.hexagonal.domain.models.DinBodyResponse;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String numeroTarjeta;
    @Embedded
    private DireccionEntity direccion;

    private Integer numeroProductos;

    public UsuarioEntity() {
    }

    public UsuarioEntity(Integer id, String numeroTarjeta,
                         DireccionEntity direccion, Integer numeroProductos) {
        this.id = id;
        this.numeroTarjeta = numeroTarjeta;
        this.direccion = direccion;
        this.numeroProductos = numeroProductos;
    }

    public static UsuarioEntity fromDomainModel(DinBodyResponse dinBodyResponse){
        var direccionFromModel = DireccionEntity.fromDomainModel(dinBodyResponse.getDireccion());
        return  new UsuarioEntity(dinBodyResponse.getId(), dinBodyResponse.getNumeroTarjeta(),direccionFromModel, dinBodyResponse.getNumeroProductos());
    }

    public DinBodyResponse toDomainModel(){
        var direccionFromEntity = DireccionEntity.toDomainModel(direccion);
        return new DinBodyResponse(id, numeroTarjeta, direccionFromEntity, numeroProductos);
    }

}
