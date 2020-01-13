package cn.yhd.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.List;

public abstract class BaseV2ServiceImpl<Recode,Condition> implements IBaseV2Service<Recode,Condition> {

    public abstract IBaseV2Mapper<Recode,Condition> getMapper();


    @Override
    public <T> int delete(T id) {
        return getMapper().delete(id);
    }

    @Override
    public int insert(Recode record) {
        return getMapper().insert(record);
    }

    @Override
    public List<Recode> selectByCondition(Condition condition) {
        return getMapper().selectByCondition(condition);
    }

    @Override
    public <T> Recode selectById(T id) {
        return getMapper().selectById(id);
    }


    @Override
    public int update(Recode record) {
        return getMapper().update(record);
    }

    @Override
    public PageInfo<Recode> selectByConditionForPage(Condition condition, Integer pageNo, Integer pageSize){
       return PageHelper.startPage(pageNo,pageSize).doSelectPageInfo(
               ()->getMapper().selectByCondition(condition)
       );
    }
}
