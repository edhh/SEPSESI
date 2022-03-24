package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses018Etiquetas;
import mx.sep.sesi.modelo.Tses018EtiquetasExample;
import org.apache.ibatis.annotations.Param;

public interface Tses018EtiquetasMapper {
    int countByExample(Tses018EtiquetasExample example);

    int deleteByExample(Tses018EtiquetasExample example);

    int deleteByPrimaryKey(@Param("idEtiqueta") Long idEtiqueta, @Param("idInmueble") Integer idInmueble);

    int insert(Tses018Etiquetas record);

    int insertSelective(Tses018Etiquetas record);

    List<Tses018Etiquetas> selectByExample(Tses018EtiquetasExample example);

    Tses018Etiquetas selectByPrimaryKey(@Param("idEtiqueta") Long idEtiqueta, @Param("idInmueble") Integer idInmueble);

    int updateByExampleSelective(@Param("record") Tses018Etiquetas record, @Param("example") Tses018EtiquetasExample example);

    int updateByExample(@Param("record") Tses018Etiquetas record, @Param("example") Tses018EtiquetasExample example);

    int updateByPrimaryKeySelective(Tses018Etiquetas record);

    int updateByPrimaryKey(Tses018Etiquetas record);
}