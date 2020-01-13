package cn.yhd.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IBaseV2Mapper<Recode,Condition> {

    int insert(Recode record);

    <T> int delete(T id);

    int update(Recode record);

    <T> Recode selectById(T id);

    List<Recode> selectByCondition(Condition condition);

}
