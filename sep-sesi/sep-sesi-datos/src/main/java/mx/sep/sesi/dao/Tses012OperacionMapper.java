package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses012Operacion;
import mx.sep.sesi.modelo.Tses012OperacionExample;
import org.apache.ibatis.annotations.Param;

public interface Tses012OperacionMapper {
    int countByExample(Tses012OperacionExample example);

    int deleteByExample(Tses012OperacionExample example);

    int deleteByPrimaryKey(Long idRegistro);

    int insert(Tses012Operacion record);

    int insertSelective(Tses012Operacion record);

    List<Tses012Operacion> selectByExample(Tses012OperacionExample example);

    Tses012Operacion selectByPrimaryKey(Long idRegistro);

    int updateByExampleSelective(@Param("record") Tses012Operacion record, @Param("example") Tses012OperacionExample example);

    int updateByExample(@Param("record") Tses012Operacion record, @Param("example") Tses012OperacionExample example);

    int updateByPrimaryKeySelective(Tses012Operacion record);

    int updateByPrimaryKey(Tses012Operacion record);
}