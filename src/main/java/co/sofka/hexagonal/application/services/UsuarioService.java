package co.sofka.hexagonal.application.services;

import co.sofka.hexagonal.domain.models.DinBodyResponse;
import co.sofka.hexagonal.domain.ports.input.CreateUsuarioUseCase;
import co.sofka.hexagonal.domain.ports.input.DeleteUsuarioUseCase;
import co.sofka.hexagonal.domain.ports.input.GetUsuarioUseCase;
import co.sofka.hexagonal.domain.ports.input.UpdateUsuarioUseCase;

import java.util.List;
import java.util.Optional;

public class UsuarioService implements CreateUsuarioUseCase, GetUsuarioUseCase, UpdateUsuarioUseCase, DeleteUsuarioUseCase {

    private final CreateUsuarioUseCase createUsuarioUseCase;
    private final GetUsuarioUseCase getUsuarioUseCase;
    private final UpdateUsuarioUseCase updateUsuarioUseCase;
    private final DeleteUsuarioUseCase deleteUsuarioUseCase;

    public UsuarioService(CreateUsuarioUseCase createUsuarioUseCase,
                          GetUsuarioUseCase getUsuarioUseCase,
                          UpdateUsuarioUseCase updateUsuarioUseCase,
                          DeleteUsuarioUseCase deleteUsuarioUseCase) {
        this.createUsuarioUseCase = createUsuarioUseCase;
        this.getUsuarioUseCase = getUsuarioUseCase;
        this.updateUsuarioUseCase = updateUsuarioUseCase;
        this.deleteUsuarioUseCase = deleteUsuarioUseCase;
    }

    @Override
    public DinBodyResponse createUsuario(DinBodyResponse dinBodyResponse) {
        return createUsuarioUseCase.createUsuario(dinBodyResponse);
    }

    @Override
    public boolean deleteUsuario(Integer id) {
        return deleteUsuarioUseCase.deleteUsuario(id);
    }

    @Override
    public Optional<DinBodyResponse> getUsuario(Integer id) {
        return getUsuarioUseCase.getUsuario(id);
    }

    @Override
    public List<DinBodyResponse> getAllUsuarios() {
        return getUsuarioUseCase.getAllUsuarios();
    }

    @Override
    public Optional<DinBodyResponse> updateUsuario(DinBodyResponse updateDinBodyResponse) {
        return updateUsuarioUseCase.updateUsuario(updateDinBodyResponse);
    }
}
