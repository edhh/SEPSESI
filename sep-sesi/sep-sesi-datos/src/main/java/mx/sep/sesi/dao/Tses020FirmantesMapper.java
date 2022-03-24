package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses020Firmantes;
import mx.sep.sesi.modelo.Tses020FirmantesExample;
import org.apache.ibatis.annotations.Param;

public interface Tses020FirmantesMapper {
    int countByExample(Tses020FirmantesExample example);

    int deleteByExample(Tses020FirmantesExample example);

    int deleteByPrimaryKey(Integer idFirmante);

    int insert(Tses020Firmantes record);

    int insertSelective(Tses020Firmantes record);

    List<Tses020Firmantes> selectByExampleWithBLOBs(Tses020FirmantesExample example);

    List<Tses020Firmantes> selectByExample(Tses020FirmantesExample example);

    Tses020Firmantes selectByPrimaryKey(Integer idFirmante);

    int updateByExampleSelective(@Param("record") Tses020Firmantes record, @Param("example") Tses020FirmantesExample example);

    int updateByExampleWithBLOBs(@Param("record") Tses020Firmantes record, @Param("example") Tses020FirmantesExample example);

    int updateByExample(@Param("record") Tses020Firmantes record, @Param("example") Tses020FirmantesExample example);

    int updateByPrimaryKeySelective(Tses020Firmantes record);

    int updateByPrimaryKeyWithBLOBs(Tses020Firmantes record);

    int updateByPrimaryKey(Tses020Firmantes record);
}