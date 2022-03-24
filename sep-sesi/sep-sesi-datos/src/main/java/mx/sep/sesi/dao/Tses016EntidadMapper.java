package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses016Entidad;
import mx.sep.sesi.modelo.Tses016EntidadExample;
import org.apache.ibatis.annotations.Param;

public interface Tses016EntidadMapper {
    int countByExample(Tses016EntidadExample example);

    int deleteByExample(Tses016EntidadExample example);

    int deleteByPrimaryKey(Integer idEntidad);

    int insert(Tses016Entidad record);

    int insertSelective(Tses016Entidad record);

    List<Tses016Entidad> selectByExample(Tses016EntidadExample example);

    Tses016Entidad selectByPrimaryKey(Integer idEntidad);

    int updateByExampleSelective(@Param("record") Tses016Entidad record, @Param("example") Tses016EntidadExample example);

    int updateByExample(@Param("record") Tses016Entidad record, @Param("example") Tses016EntidadExample example);

    int updateByPrimaryKeySelective(Tses016Entidad record);

    int updateByPrimaryKey(Tses016Entidad record);
}