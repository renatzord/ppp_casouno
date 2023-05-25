package com.api.ppp.back.services;

import com.api.ppp.back.models.Notificacion;
import com.api.ppp.back.models.Usuario;

import java.util.List;

public interface NotificacionService extends BaseService<Notificacion,Integer>{

    public List<Notificacion> notificacionxtipo(Usuario usuario,Integer tipo);

}
