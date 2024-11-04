package co.sofka.hexagonal.infrastructure.adapter;

import co.sofka.hexagonal.domain.models.DinBodyResponse;
import co.sofka.hexagonal.domain.ports.output.UsuarioRepositoryPort;
import co.sofka.hexagonal.infrastructure.cryptography.Encryption;
import co.sofka.hexagonal.infrastructure.entities.UsuarioEntity;
import co.sofka.hexagonal.infrastructure.repositories.JpaUsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class JpaUsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final JpaUsuarioRepository jpaUsuarioRepository;

    private final Encryption encryption;

    public JpaUsuarioRepositoryAdapter(JpaUsuarioRepository jpaUsuarioRepository, Encryption encryption) {
        this.jpaUsuarioRepository = jpaUsuarioRepository;
        this.encryption = encryption;
    }

    @Override
    public DinBodyResponse save(DinBodyResponse dinBodyResponse) {
        UsuarioEntity usuarioEntity = UsuarioEntity.fromDomainModel(dinBodyResponse);
        UsuarioEntity savedUsuarioEntity = jpaUsuarioRepository.save(usuarioEntity);
        return savedUsuarioEntity.toDomainModel();
    }

    @Override
    public Optional<DinBodyResponse> findById(Integer id) {
        var usuario = jpaUsuarioRepository.findById(id)
                .map(UsuarioEntity::toDomainModel)//convertir a dominio
                .map(usuario1 -> {
                    usuario1.setNumeroTarjeta(encryption.encriptAes(usuario1.getNumeroTarjeta()));
                    return usuario1;
                });

        return usuario;
    }

    @Override
    public List<DinBodyResponse> findAll() {
        return jpaUsuarioRepository.findAll().stream()
                .map(UsuarioEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DinBodyResponse> update(DinBodyResponse updateDinBodyResponse) {

        if (jpaUsuarioRepository.existsById(updateDinBodyResponse.getId())){
            UsuarioEntity usuarioEntity = UsuarioEntity.fromDomainModel(updateDinBodyResponse);
            UsuarioEntity updatedUsuarioEntity = jpaUsuarioRepository.save(usuarioEntity);
            return Optional.of(updatedUsuarioEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Integer id) {

        if(jpaUsuarioRepository.existsById(id)){
            jpaUsuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
