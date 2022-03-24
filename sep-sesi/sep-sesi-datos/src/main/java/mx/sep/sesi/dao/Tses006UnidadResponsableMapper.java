package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses006UnidadResponsable;
import mx.sep.sesi.modelo.Tses006UnidadResponsableExample;
import org.apache.ibatis.annotations.Param;

public interface Tses006UnidadResponsableMapper {
    int countByExample(Tses006UnidadResponsableExample example);

    int deleteByExample(Tses006UnidadResponsableExample example);

    int deleteByPrimaryKey(Integer idUr);

    int insert(Tses006UnidadResponsable record);

    int insertSelective(Tses006UnidadResponsable record);

    List<Tses006UnidadResponsable> selectByExample(Tses006UnidadResponsableExample example);

    Tses006UnidadResponsable selectByPrimaryKey(Integer idUr);

    int updateByExampleSelective(@Param("record") Tses006UnidadResponsable record, @Param("example") Tses006UnidadResponsableExample example);

    int updateByExample(@Param("record") Tses006UnidadResponsable record, @Param("example") Tses006UnidadResponsableExample example);

    int updateByPrimaryKeySelective(Tses006UnidadResponsable record);

    int updateByPrimaryKey(Tses006UnidadResponsable record);
}