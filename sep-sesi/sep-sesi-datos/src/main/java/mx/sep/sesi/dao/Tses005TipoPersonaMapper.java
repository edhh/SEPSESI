package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses005TipoPersona;
import mx.sep.sesi.modelo.Tses005TipoPersonaExample;
import org.apache.ibatis.annotations.Param;

public interface Tses005TipoPersonaMapper {
    int countByExample(Tses005TipoPersonaExample example);

    int deleteByExample(Tses005TipoPersonaExample example);

    int deleteByPrimaryKey(Integer idTipoPersona);

    int insert(Tses005TipoPersona record);

    int insertSelective(Tses005TipoPersona record);

    List<Tses005TipoPersona> selectByExample(Tses005TipoPersonaExample example);

    Tses005TipoPersona selectByPrimaryKey(Integer idTipoPersona);

    int updateByExampleSelective(@Param("record") Tses005TipoPersona record, @Param("example") Tses005TipoPersonaExample example);

    int updateByExample(@Param("record") Tses005TipoPersona record, @Param("example") Tses005TipoPersonaExample example);

    int updateByPrimaryKeySelective(Tses005TipoPersona record);

    int updateByPrimaryKey(Tses005TipoPersona record);
}