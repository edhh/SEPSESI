package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses001Usuarios;
import mx.sep.sesi.modelo.Tses001UsuariosExample;
import org.apache.ibatis.annotations.Param;

public interface Tses001UsuariosMapper {
    int countByExample(Tses001UsuariosExample example);

    int deleteByExample(Tses001UsuariosExample example);

    int deleteByPrimaryKey(Integer idUsuario);

    int insert(Tses001Usuarios record);

    int insertSelective(Tses001Usuarios record);

    List<Tses001Usuarios> selectByExample(Tses001UsuariosExample example);

    Tses001Usuarios selectByPrimaryKey(Integer idUsuario);

    int updateByExampleSelective(@Param("record") Tses001Usuarios record, @Param("example") Tses001UsuariosExample example);

    int updateByExample(@Param("record") Tses001Usuarios record, @Param("example") Tses001UsuariosExample example);

    int updateByPrimaryKeySelective(Tses001Usuarios record);

    int updateByPrimaryKey(Tses001Usuarios record);
}