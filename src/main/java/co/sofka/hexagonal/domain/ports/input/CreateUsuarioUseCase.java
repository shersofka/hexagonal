package co.sofka.hexagonal.domain.ports.input;

import co.sofka.hexagonal.domain.models.DinBodyResponse;

public interface CreateUsuarioUseCase {

    DinBodyResponse createUsuario(DinBodyResponse dinBodyResponse);
}
