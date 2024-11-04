package co.sofka.hexagonal.domain.ports.input;

import co.sofka.hexagonal.domain.models.DinBodyResponse;

import java.util.Optional;

public interface UpdateUsuarioUseCase {

Optional<DinBodyResponse> updateUsuario(DinBodyResponse updateDinBodyResponse);

}
