package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses021Bitacora;
import mx.sep.sesi.modelo.Tses021BitacoraExample;
import org.apache.ibatis.annotations.Param;

public interface Tses021BitacoraMapper {
    int countByExample(Tses021BitacoraExample example);

    int deleteByExample(Tses021BitacoraExample example);

    int deleteByPrimaryKey(Long idBitacora);

    int insert(Tses021Bitacora record);

    int insertSelective(Tses021Bitacora record);

    List<Tses021Bitacora> selectByExample(Tses021BitacoraExample example);

    Tses021Bitacora selectByPrimaryKey(Long idBitacora);

    int updateByExampleSelective(@Param("record") Tses021Bitacora record, @Param("example") Tses021BitacoraExample example);

    int updateByExample(@Param("record") Tses021Bitacora record, @Param("example") Tses021BitacoraExample example);

    int updateByPrimaryKeySelective(Tses021Bitacora record);

    int updateByPrimaryKey(Tses021Bitacora record);
}