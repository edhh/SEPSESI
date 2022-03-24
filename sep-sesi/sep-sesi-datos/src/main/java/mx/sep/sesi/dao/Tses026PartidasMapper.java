package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses026Partidas;
import mx.sep.sesi.modelo.Tses026PartidasExample;
import org.apache.ibatis.annotations.Param;

public interface Tses026PartidasMapper {
    int countByExample(Tses026PartidasExample example);

    int deleteByExample(Tses026PartidasExample example);

    int deleteByPrimaryKey(Long idPartida);

    int insert(Tses026Partidas record);

    int insertSelective(Tses026Partidas record);

    List<Tses026Partidas> selectByExample(Tses026PartidasExample example);

    Tses026Partidas selectByPrimaryKey(Long idPartida);

    int updateByExampleSelective(@Param("record") Tses026Partidas record, @Param("example") Tses026PartidasExample example);

    int updateByExample(@Param("record") Tses026Partidas record, @Param("example") Tses026PartidasExample example);

    int updateByPrimaryKeySelective(Tses026Partidas record);

    int updateByPrimaryKey(Tses026Partidas record);
}