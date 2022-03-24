package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses022TraduccionServicio;
import mx.sep.sesi.modelo.Tses022TraduccionServicioExample;
import org.apache.ibatis.annotations.Param;

public interface Tses022TraduccionServicioMapper {
    int countByExample(Tses022TraduccionServicioExample example);

    int deleteByExample(Tses022TraduccionServicioExample example);

    int deleteByPrimaryKey(Integer idTradServicio);

    int insert(Tses022TraduccionServicio record);

    int insertSelective(Tses022TraduccionServicio record);

    List<Tses022TraduccionServicio> selectByExample(Tses022TraduccionServicioExample example);

    Tses022TraduccionServicio selectByPrimaryKey(Integer idTradServicio);

    int updateByExampleSelective(@Param("record") Tses022TraduccionServicio record, @Param("example") Tses022TraduccionServicioExample example);

    int updateByExample(@Param("record") Tses022TraduccionServicio record, @Param("example") Tses022TraduccionServicioExample example);

    int updateByPrimaryKeySelective(Tses022TraduccionServicio record);

    int updateByPrimaryKey(Tses022TraduccionServicio record);
}