package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses023Parametros;
import mx.sep.sesi.modelo.Tses023ParametrosExample;
import org.apache.ibatis.annotations.Param;

public interface Tses023ParametrosMapper {
    int countByExample(Tses023ParametrosExample example);

    int deleteByExample(Tses023ParametrosExample example);

    int deleteByPrimaryKey(Integer idParam);

    int insert(Tses023Parametros record);

    int insertSelective(Tses023Parametros record);

    List<Tses023Parametros> selectByExample(Tses023ParametrosExample example);

    Tses023Parametros selectByPrimaryKey(Integer idParam);

    int updateByExampleSelective(@Param("record") Tses023Parametros record, @Param("example") Tses023ParametrosExample example);

    int updateByExample(@Param("record") Tses023Parametros record, @Param("example") Tses023ParametrosExample example);

    int updateByPrimaryKeySelective(Tses023Parametros record);

    int updateByPrimaryKey(Tses023Parametros record);
}