package cn.yhd.base;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IBaseService <Recode,Example> {
    int countByExample(Example example);

    int deleteByExample(Example example);

    <T> int deleteByPrimaryKey(T id);

    int insert(Recode record);

    int insertSelective(Recode record);

    List<Recode> selectByExample(Example example);

    <T> Recode selectByPrimaryKey(T id);

    int updateByExampleSelective(@Param("record") Recode record, @Param("example") Example example);

    int updateByExample(@Param("record") Recode record, @Param("example") Example example);

    int updateByPrimaryKeySelective(Recode record);

    int updateByPrimaryKey(Recode record);

    PageInfo<Recode> selectByExamplezForPage(Example example, Integer pageNo, Integer pageSize);
}
