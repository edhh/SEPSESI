package mx.sep.sesi.dao;

import java.util.List;
import mx.sep.sesi.modelo.Tses002Roles;
import mx.sep.sesi.modelo.Tses002RolesExample;
import org.apache.ibatis.annotations.Param;

public interface Tses002RolesMapper {
    int countByExample(Tses002RolesExample example);

    int deleteByExample(Tses002RolesExample example);

    int deleteByPrimaryKey(Integer idRol);

    int insert(Tses002Roles record);

    int insertSelective(Tses002Roles record);

    List<Tses002Roles> selectByExample(Tses002RolesExample example);

    Tses002Roles selectByPrimaryKey(Integer idRol);

    int updateByExampleSelective(@Param("record") Tses002Roles record, @Param("example") Tses002RolesExample example);

    int updateByExample(@Param("record") Tses002Roles record, @Param("example") Tses002RolesExample example);

    int updateByPrimaryKeySelective(Tses002Roles record);

    int updateByPrimaryKey(Tses002Roles record);
}