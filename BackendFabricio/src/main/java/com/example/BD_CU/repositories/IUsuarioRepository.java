package com.example.BD_CU.repositories;

import com.example.BD_CU.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {

    @Query(value = " SELECT r.Rol_Id, r.Nombre_Rol, count(u.Usuario_Id)\n" +
            " FROM Rol r\n" +
            " INNER JOIN Usuario u\n" +
            " ON r.Rol_Id=u.Rol_Id\n" +
            " GROUP BY r.Rol_Id",nativeQuery = true)
    List<Object[]> quantityUsuariosxRolNative();

    @Query(value = " SELECT u.Usuario_Id, r.Nombre_Rol, u.Nombre, Sum(r.Sueldo+u.Extras)\n" +
            "FROM Usuario u\n" +
            "INNER JOIN Rol r\n" +
            "ON r.Rol_Id=u.Rol_Id\n" +
            "GROUP BY r.Rol_Id,u.Usuario_Id",nativeQuery = true)
    List<Object[]> buscarPagoUsuariosNative();
}