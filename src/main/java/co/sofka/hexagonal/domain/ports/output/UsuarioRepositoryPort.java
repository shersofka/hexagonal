package co.sofka.hexagonal.domain.ports.output;

import co.sofka.hexagonal.domain.models.DinBodyResponse;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepositoryPort {

    DinBodyResponse save(DinBodyResponse dinBodyResponse);

    Optional<DinBodyResponse> findById(Integer id);

    List<DinBodyResponse> findAll();

    Optional<DinBodyResponse> update(DinBodyResponse updateDinBodyResponse);

    boolean deleteById(Integer id);

}
