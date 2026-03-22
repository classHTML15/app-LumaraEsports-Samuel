package com.fplumara.dam1.LumaraEsports.service;

import com.fplumara.dam1.LumaraEsports.model.Torneo;
import com.fplumara.dam1.LumaraEsports.model.TorneoConEquipo;

import java.util.List;

public interface TorneoService {

    List<TorneoConEquipo> obtenerTorneosConEquipoCampeon();

    Torneo buscarPorId(Long id);

    void guardar(Torneo torneo);

    void actualizar(Torneo torneo);

    void borrar(Long id);
}
