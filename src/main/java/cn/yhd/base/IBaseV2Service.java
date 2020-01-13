package cn.yhd.base;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IBaseV2Service<Recode,Condition> {

    /**
     * @param record 记录
     * @return
     */
    int insert(Recode record);


    /**
     * @param condition 条件
     * @return
     */
    List<Recode> selectByCondition(Condition condition);

    /**
     * @param id 主键
     * @return
     */
    <T> Recode selectById(T id);

    /**
     * @param record 根据主键更新
     * @return
     */
    int update(Recode record);

    /**
     * @param id 主键
     * @return
     */
    <T> int delete(T id);


    /**
     * @param condition 调价
     * @param pageNo 页码
     * @param pageSize 单页数
     * @return
     */
    PageInfo<Recode> selectByConditionForPage(Condition condition, Integer pageNo, Integer pageSize);
}
