package com.fplumara.dam1.LumaraEsports.repository;


import com.fplumara.dam1.LumaraEsports.model.Torneo;
import com.fplumara.dam1.LumaraEsports.model.TorneoConEquipo;


import java.util.List;

public interface TorneoRepository {

    List<Torneo> obtenerTodos();

    Torneo buscarPorId(Long id);

    void guardar(Torneo torneo);

    void actualizar(Torneo torneo);

    void borrar(Long id);

    boolean existeEquipoCampeon(Long equipoId);

    boolean existePorNombreYCiudad(String nombre, String ciudad);

    boolean existePorNombreYCiudadDistintoId(String nombre, String ciudad, Long id);

    List<TorneoConEquipo> obtenerTorneosConEquipoCampeon();
}
