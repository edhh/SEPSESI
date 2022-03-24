package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses003RolUsuario;
import mx.sep.sesi.modelo.Tses003RolUsuarioExample;
import org.apache.ibatis.annotations.Param;

public interface Tses003RolUsuarioMapper {
    int countByExample(Tses003RolUsuarioExample example);

    int deleteByExample(Tses003RolUsuarioExample example);

    int deleteByPrimaryKey(Integer idRolUsuario);

    int insert(Tses003RolUsuario record);

    int insertSelective(Tses003RolUsuario record);

    List<Tses003RolUsuario> selectByExample(Tses003RolUsuarioExample example);

    Tses003RolUsuario selectByPrimaryKey(Integer idRolUsuario);

    int updateByExampleSelective(@Param("record") Tses003RolUsuario record, @Param("example") Tses003RolUsuarioExample example);

    int updateByExample(@Param("record") Tses003RolUsuario record, @Param("example") Tses003RolUsuarioExample example);

    int updateByPrimaryKeySelective(Tses003RolUsuario record);

    int updateByPrimaryKey(Tses003RolUsuario record);
}