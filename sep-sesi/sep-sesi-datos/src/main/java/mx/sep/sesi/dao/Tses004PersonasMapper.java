package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses004Personas;
import mx.sep.sesi.modelo.Tses004PersonasExample;
import org.apache.ibatis.annotations.Param;

public interface Tses004PersonasMapper {
    int countByExample(Tses004PersonasExample example);

    int deleteByExample(Tses004PersonasExample example);

    int deleteByPrimaryKey(Integer idPersona);

    int insert(Tses004Personas record);

    int insertSelective(Tses004Personas record);

    List<Tses004Personas> selectByExampleWithBLOBs(Tses004PersonasExample example);

    List<Tses004Personas> selectByExample(Tses004PersonasExample example);

    Tses004Personas selectByPrimaryKey(Integer idPersona);

    int updateByExampleSelective(@Param("record") Tses004Personas record, @Param("example") Tses004PersonasExample example);

    int updateByExampleWithBLOBs(@Param("record") Tses004Personas record, @Param("example") Tses004PersonasExample example);

    int updateByExample(@Param("record") Tses004Personas record, @Param("example") Tses004PersonasExample example);

    int updateByPrimaryKeySelective(Tses004Personas record);

    int updateByPrimaryKeyWithBLOBs(Tses004Personas record);

    int updateByPrimaryKey(Tses004Personas record);
}