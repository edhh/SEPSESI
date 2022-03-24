package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses025EquiposVisitante;
import mx.sep.sesi.modelo.Tses025EquiposVisitanteExample;
import org.apache.ibatis.annotations.Param;

public interface Tses025EquiposVisitanteMapper {
    int countByExample(Tses025EquiposVisitanteExample example);

    int deleteByExample(Tses025EquiposVisitanteExample example);

    int deleteByPrimaryKey(Long idEquipoVis);

    int insert(Tses025EquiposVisitante record);

    int insertSelective(Tses025EquiposVisitante record);

    List<Tses025EquiposVisitante> selectByExample(Tses025EquiposVisitanteExample example);

    Tses025EquiposVisitante selectByPrimaryKey(Long idEquipoVis);

    int updateByExampleSelective(@Param("record") Tses025EquiposVisitante record, @Param("example") Tses025EquiposVisitanteExample example);

    int updateByExample(@Param("record") Tses025EquiposVisitante record, @Param("example") Tses025EquiposVisitanteExample example);

    int updateByPrimaryKeySelective(Tses025EquiposVisitante record);

    int updateByPrimaryKey(Tses025EquiposVisitante record);
}