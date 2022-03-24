package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses013Accesos;
import mx.sep.sesi.modelo.Tses013AccesosExample;
import org.apache.ibatis.annotations.Param;

public interface Tses013AccesosMapper {
    int countByExample(Tses013AccesosExample example);

    int deleteByExample(Tses013AccesosExample example);

    int deleteByPrimaryKey(Integer idAcceso);

    int insert(Tses013Accesos record);

    int insertSelective(Tses013Accesos record);

    List<Tses013Accesos> selectByExample(Tses013AccesosExample example);

    Tses013Accesos selectByPrimaryKey(Integer idAcceso);

    int updateByExampleSelective(@Param("record") Tses013Accesos record, @Param("example") Tses013AccesosExample example);

    int updateByExample(@Param("record") Tses013Accesos record, @Param("example") Tses013AccesosExample example);

    int updateByPrimaryKeySelective(Tses013Accesos record);

    int updateByPrimaryKey(Tses013Accesos record);
}