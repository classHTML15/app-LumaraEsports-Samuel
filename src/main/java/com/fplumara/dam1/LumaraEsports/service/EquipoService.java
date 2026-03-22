package com.fplumara.dam1.LumaraEsports.service;

import com.fplumara.dam1.LumaraEsports.model.Equipos;

import java.util.List;

public interface EquipoService {

    List<Equipos> obtenerTodos();

    Equipos buscarPorId(Long id);

    void guardar(Equipos equipo);

    void actualizar(Equipos equipo);

    void borrar(Long id);
}
