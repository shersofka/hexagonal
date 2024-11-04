package co.sofka.hexagonal.domain.ports.input;

import co.sofka.hexagonal.domain.models.DinBodyResponse;

import java.util.List;
import java.util.Optional;

public interface GetUsuarioUseCase {

    Optional<DinBodyResponse> getUsuario(Integer id);

    List<DinBodyResponse> getAllUsuarios();
}
