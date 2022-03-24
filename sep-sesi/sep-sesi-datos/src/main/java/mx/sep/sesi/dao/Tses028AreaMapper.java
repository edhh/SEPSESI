package mx.sep.sesi.dao;

import java.math.BigDecimal;
import java.util.List;
import mx.sep.sesi.modelo.Tses028Area;
import mx.sep.sesi.modelo.Tses028AreaExample;
import org.apache.ibatis.annotations.Param;

public interface Tses028AreaMapper {
    int countByExample(Tses028AreaExample example);

    int deleteByExample(Tses028AreaExample example);

    int deleteByPrimaryKey(BigDecimal idArea);

    int insert(Tses028Area record);

    int insertSelective(Tses028Area record);

    List<Tses028Area> selectByExample(Tses028AreaExample example);

    Tses028Area selectByPrimaryKey(BigDecimal idArea);

    int updateByExampleSelective(@Param("record") Tses028Area record, @Param("example") Tses028AreaExample example);

    int updateByExample(@Param("record") Tses028Area record, @Param("example") Tses028AreaExample example);

    int updateByPrimaryKeySelective(Tses028Area record);

    int updateByPrimaryKey(Tses028Area record);
}