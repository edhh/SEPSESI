package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses009Inmuebles;
import mx.sep.sesi.modelo.Tses009InmueblesExample;
import org.apache.ibatis.annotations.Param;

public interface Tses009InmueblesMapper {
    int countByExample(Tses009InmueblesExample example);

    int deleteByExample(Tses009InmueblesExample example);

    int deleteByPrimaryKey(Integer idInmueble);

    int insert(Tses009Inmuebles record);

    int insertSelective(Tses009Inmuebles record);

    List<Tses009Inmuebles> selectByExample(Tses009InmueblesExample example);

    Tses009Inmuebles selectByPrimaryKey(Integer idInmueble);

    int updateByExampleSelective(@Param("record") Tses009Inmuebles record, @Param("example") Tses009InmueblesExample example);

    int updateByExample(@Param("record") Tses009Inmuebles record, @Param("example") Tses009InmueblesExample example);

    int updateByPrimaryKeySelective(Tses009Inmuebles record);

    int updateByPrimaryKey(Tses009Inmuebles record);
}