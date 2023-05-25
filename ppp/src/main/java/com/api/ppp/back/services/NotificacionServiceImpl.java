package com.api.ppp.back.services;

import com.api.ppp.back.daos.BaseRepository;
import com.api.ppp.back.daos.NotificacionRepository;
import com.api.ppp.back.models.Notificacion;
import com.api.ppp.back.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionServiceImpl extends BaseServiceImpl<Notificacion, Integer> implements NotificacionService{


    @Autowired
    private NotificacionRepository repository;

    public NotificacionServiceImpl(BaseRepository<Notificacion, Integer> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Notificacion> notificacionxtipo(Usuario usuario, Integer tipo) {
        if(tipo==3){
            return repository.findTop20ByUsuarioEstudianteOrderByIdDesc(usuario).orElse(null);
        }else{
            return repository.findTop20ByUsuarioTutorOrderByIdDesc(usuario).orElse(null);
        }
    }
}
