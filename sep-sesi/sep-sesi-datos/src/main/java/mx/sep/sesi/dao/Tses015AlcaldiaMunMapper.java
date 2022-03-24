package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses015AlcaldiaMun;
import mx.sep.sesi.modelo.Tses015AlcaldiaMunExample;
import org.apache.ibatis.annotations.Param;

public interface Tses015AlcaldiaMunMapper {
    int countByExample(Tses015AlcaldiaMunExample example);

    int deleteByExample(Tses015AlcaldiaMunExample example);

    int deleteByPrimaryKey(@Param("idAlcaldiaMun") Integer idAlcaldiaMun, @Param("idEntidad") Integer idEntidad);

    int insert(Tses015AlcaldiaMun record);

    int insertSelective(Tses015AlcaldiaMun record);

    List<Tses015AlcaldiaMun> selectByExample(Tses015AlcaldiaMunExample example);

    Tses015AlcaldiaMun selectByPrimaryKey(@Param("idAlcaldiaMun") Integer idAlcaldiaMun, @Param("idEntidad") Integer idEntidad);

    int updateByExampleSelective(@Param("record") Tses015AlcaldiaMun record, @Param("example") Tses015AlcaldiaMunExample example);

    int updateByExample(@Param("record") Tses015AlcaldiaMun record, @Param("example") Tses015AlcaldiaMunExample example);

    int updateByPrimaryKeySelective(Tses015AlcaldiaMun record);

    int updateByPrimaryKey(Tses015AlcaldiaMun record);
}