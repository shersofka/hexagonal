package co.sofka.hexagonal.application.usecases;

import co.sofka.hexagonal.domain.models.DinBodyResponse;
import co.sofka.hexagonal.domain.ports.input.CreateUsuarioUseCase;
import co.sofka.hexagonal.domain.ports.output.UsuarioRepositoryPort;

public class CreateUsuarioUseCaseImpl implements CreateUsuarioUseCase {

    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public CreateUsuarioUseCaseImpl(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    public DinBodyResponse createUsuario(DinBodyResponse dinBodyResponse) {
        return usuarioRepositoryPort.save(dinBodyResponse);
    }
}
