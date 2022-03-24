package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses017Incidencias;
import mx.sep.sesi.modelo.Tses017IncidenciasExample;
import org.apache.ibatis.annotations.Param;

public interface Tses017IncidenciasMapper {
    int countByExample(Tses017IncidenciasExample example);

    int deleteByExample(Tses017IncidenciasExample example);

    int deleteByPrimaryKey(Long idIncidencia);

    int insert(Tses017Incidencias record);

    int insertSelective(Tses017Incidencias record);

    List<Tses017Incidencias> selectByExample(Tses017IncidenciasExample example);

    Tses017Incidencias selectByPrimaryKey(Long idIncidencia);

    int updateByExampleSelective(@Param("record") Tses017Incidencias record, @Param("example") Tses017IncidenciasExample example);

    int updateByExample(@Param("record") Tses017Incidencias record, @Param("example") Tses017IncidenciasExample example);

    int updateByPrimaryKeySelective(Tses017Incidencias record);

    int updateByPrimaryKey(Tses017Incidencias record);
}