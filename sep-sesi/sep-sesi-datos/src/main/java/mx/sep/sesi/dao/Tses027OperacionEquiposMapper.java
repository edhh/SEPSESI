package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses027OperacionEquipos;
import mx.sep.sesi.modelo.Tses027OperacionEquiposExample;
import org.apache.ibatis.annotations.Param;

public interface Tses027OperacionEquiposMapper {
    int countByExample(Tses027OperacionEquiposExample example);

    int deleteByExample(Tses027OperacionEquiposExample example);

    int deleteByPrimaryKey(Long idOperacionEquipos);

    int insert(Tses027OperacionEquipos record);

    int insertSelective(Tses027OperacionEquipos record);

    List<Tses027OperacionEquipos> selectByExample(Tses027OperacionEquiposExample example);

    Tses027OperacionEquipos selectByPrimaryKey(Long idOperacionEquipos);

    int updateByExampleSelective(@Param("record") Tses027OperacionEquipos record, @Param("example") Tses027OperacionEquiposExample example);

    int updateByExample(@Param("record") Tses027OperacionEquipos record, @Param("example") Tses027OperacionEquiposExample example);

    int updateByPrimaryKeySelective(Tses027OperacionEquipos record);

    int updateByPrimaryKey(Tses027OperacionEquipos record);
}