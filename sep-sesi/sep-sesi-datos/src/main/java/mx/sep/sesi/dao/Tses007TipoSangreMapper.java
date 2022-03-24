package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses007TipoSangre;
import mx.sep.sesi.modelo.Tses007TipoSangreExample;
import org.apache.ibatis.annotations.Param;

public interface Tses007TipoSangreMapper {
    int countByExample(Tses007TipoSangreExample example);

    int deleteByExample(Tses007TipoSangreExample example);

    int deleteByPrimaryKey(Integer idTipo);

    int insert(Tses007TipoSangre record);

    int insertSelective(Tses007TipoSangre record);

    List<Tses007TipoSangre> selectByExample(Tses007TipoSangreExample example);

    Tses007TipoSangre selectByPrimaryKey(Integer idTipo);

    int updateByExampleSelective(@Param("record") Tses007TipoSangre record, @Param("example") Tses007TipoSangreExample example);

    int updateByExample(@Param("record") Tses007TipoSangre record, @Param("example") Tses007TipoSangreExample example);

    int updateByPrimaryKeySelective(Tses007TipoSangre record);

    int updateByPrimaryKey(Tses007TipoSangre record);
}