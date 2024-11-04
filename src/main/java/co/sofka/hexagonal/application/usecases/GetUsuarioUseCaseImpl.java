package co.sofka.hexagonal.application.usecases;

import co.sofka.hexagonal.domain.models.DinBodyResponse;
import co.sofka.hexagonal.domain.ports.input.GetUsuarioUseCase;
import co.sofka.hexagonal.domain.ports.output.UsuarioRepositoryPort;

import java.util.List;
import java.util.Optional;

public class GetUsuarioUseCaseImpl implements GetUsuarioUseCase {

    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public GetUsuarioUseCaseImpl(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    public Optional<DinBodyResponse> getUsuario(Integer id) {
        return usuarioRepositoryPort.findById(id);
    }

    @Override
    public List<DinBodyResponse> getAllUsuarios() {
        return usuarioRepositoryPort.findAll();
    }
}
