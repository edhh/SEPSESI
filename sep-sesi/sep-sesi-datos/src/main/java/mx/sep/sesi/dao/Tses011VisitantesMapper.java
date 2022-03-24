package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses011Visitantes;
import mx.sep.sesi.modelo.Tses011VisitantesExample;
import org.apache.ibatis.annotations.Param;

public interface Tses011VisitantesMapper {
    int countByExample(Tses011VisitantesExample example);

    int deleteByExample(Tses011VisitantesExample example);

    int deleteByPrimaryKey(Long idVisitante);

    int insert(Tses011Visitantes record);

    int insertSelective(Tses011Visitantes record);

    List<Tses011Visitantes> selectByExampleWithBLOBs(Tses011VisitantesExample example);

    List<Tses011Visitantes> selectByExample(Tses011VisitantesExample example);

    Tses011Visitantes selectByPrimaryKey(Long idVisitante);

    int updateByExampleSelective(@Param("record") Tses011Visitantes record, @Param("example") Tses011VisitantesExample example);

    int updateByExampleWithBLOBs(@Param("record") Tses011Visitantes record, @Param("example") Tses011VisitantesExample example);

    int updateByExample(@Param("record") Tses011Visitantes record, @Param("example") Tses011VisitantesExample example);

    int updateByPrimaryKeySelective(Tses011Visitantes record);

    int updateByPrimaryKeyWithBLOBs(Tses011Visitantes record);

    int updateByPrimaryKey(Tses011Visitantes record);
}