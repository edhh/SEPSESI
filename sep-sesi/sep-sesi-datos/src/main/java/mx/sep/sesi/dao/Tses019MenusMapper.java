package mx.sep.sesi.dao;

import java.math.BigDecimal;
import java.util.List;
import mx.sep.sesi.modelo.Tses019Menus;
import mx.sep.sesi.modelo.Tses019MenusExample;
import org.apache.ibatis.annotations.Param;

public interface Tses019MenusMapper {
    int countByExample(Tses019MenusExample example);

    int deleteByExample(Tses019MenusExample example);

    int deleteByPrimaryKey(BigDecimal idOpcion);

    int insert(Tses019Menus record);

    int insertSelective(Tses019Menus record);

    List<Tses019Menus> selectByExample(Tses019MenusExample example);

    Tses019Menus selectByPrimaryKey(BigDecimal idOpcion);

    int updateByExampleSelective(@Param("record") Tses019Menus record, @Param("example") Tses019MenusExample example);

    int updateByExample(@Param("record") Tses019Menus record, @Param("example") Tses019MenusExample example);

    int updateByPrimaryKeySelective(Tses019Menus record);

    int updateByPrimaryKey(Tses019Menus record);
}