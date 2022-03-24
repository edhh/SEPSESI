package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses014Colonia;
import mx.sep.sesi.modelo.Tses014ColoniaExample;
import org.apache.ibatis.annotations.Param;

public interface Tses014ColoniaMapper {
    int countByExample(Tses014ColoniaExample example);

    int deleteByExample(Tses014ColoniaExample example);

    int deleteByPrimaryKey(@Param("idColonia") Long idColonia, @Param("idEntidad") Integer idEntidad, @Param("idAlcaldiaMun") Integer idAlcaldiaMun);

    int insert(Tses014Colonia record);

    int insertSelective(Tses014Colonia record);

    List<Tses014Colonia> selectByExample(Tses014ColoniaExample example);

    Tses014Colonia selectByPrimaryKey(@Param("idColonia") Long idColonia, @Param("idEntidad") Integer idEntidad, @Param("idAlcaldiaMun") Integer idAlcaldiaMun);

    int updateByExampleSelective(@Param("record") Tses014Colonia record, @Param("example") Tses014ColoniaExample example);

    int updateByExample(@Param("record") Tses014Colonia record, @Param("example") Tses014ColoniaExample example);

    int updateByPrimaryKeySelective(Tses014Colonia record);

    int updateByPrimaryKey(Tses014Colonia record);
}