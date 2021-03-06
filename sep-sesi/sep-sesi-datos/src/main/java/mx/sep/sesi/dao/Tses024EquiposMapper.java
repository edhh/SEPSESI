package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses024Equipos;
import mx.sep.sesi.modelo.Tses024EquiposExample;
import org.apache.ibatis.annotations.Param;

public interface Tses024EquiposMapper {
    int countByExample(Tses024EquiposExample example);

    int deleteByExample(Tses024EquiposExample example);

    int deleteByPrimaryKey(Long idEquipo);

    int insert(Tses024Equipos record);

    int insertSelective(Tses024Equipos record);

    List<Tses024Equipos> selectByExample(Tses024EquiposExample example);

    Tses024Equipos selectByPrimaryKey(Long idEquipo);

    int updateByExampleSelective(@Param("record") Tses024Equipos record, @Param("example") Tses024EquiposExample example);

    int updateByExample(@Param("record") Tses024Equipos record, @Param("example") Tses024EquiposExample example);

    int updateByPrimaryKeySelective(Tses024Equipos record);

    int updateByPrimaryKey(Tses024Equipos record);
}