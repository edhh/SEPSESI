package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses010CuadranteArea;
import mx.sep.sesi.modelo.Tses010CuadranteAreaExample;
import org.apache.ibatis.annotations.Param;

public interface Tses010CuadranteAreaMapper {
    int countByExample(Tses010CuadranteAreaExample example);

    int deleteByExample(Tses010CuadranteAreaExample example);

    int deleteByPrimaryKey(Integer idCuadranteArea);

    int insert(Tses010CuadranteArea record);

    int insertSelective(Tses010CuadranteArea record);

    List<Tses010CuadranteArea> selectByExample(Tses010CuadranteAreaExample example);

    Tses010CuadranteArea selectByPrimaryKey(Integer idCuadranteArea);

    int updateByExampleSelective(@Param("record") Tses010CuadranteArea record, @Param("example") Tses010CuadranteAreaExample example);

    int updateByExample(@Param("record") Tses010CuadranteArea record, @Param("example") Tses010CuadranteAreaExample example);

    int updateByPrimaryKeySelective(Tses010CuadranteArea record);

    int updateByPrimaryKey(Tses010CuadranteArea record);
}