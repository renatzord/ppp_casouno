package com.api.ppp.back.daos;

import com.api.ppp.back.models.Notificacion;
import com.api.ppp.back.models.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificacionRepository extends BaseRepository<Notificacion, Integer> {

    Optional <List<Notificacion>>  findTop20ByUsuarioTutorOrderByIdDesc(Usuario usuarioTutor);

    Optional<List<Notificacion>> findTop20ByUsuarioEstudianteAndTipoOrderByIdDesc(Usuario usuarioEstudiante,Integer tipo);


}
