package cn.yhd.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.List;

public abstract class BaseServiceImpl<Recode,Example> implements IBaseService<Recode,Example> {

    @Resource
    private JdbcTemplate jdbcTemplate;

    protected JdbcTemplate getJdbcTemplate(){
        return jdbcTemplate;
    }

    public abstract IBaseMapper<Recode,Example> getMapper();

    @Override
    public int countByExample(Example example) {
        return getMapper().countByExample(example);
    }

    @Override
    public int deleteByExample(Example example) {
        return getMapper().deleteByExample(example);
    }

    @Override
    public <T> int deleteByPrimaryKey(T id) {
        return getMapper().deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Recode record) {
        return getMapper().insert(record);
    }

    @Override
    public int insertSelective(Recode record) {
        return getMapper().insertSelective(record);
    }

    @Override
    public List<Recode> selectByExample(Example example) {
        return getMapper().selectByExample(example);
    }

    @Override
    public <T> Recode selectByPrimaryKey(T id) {
        return getMapper().selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Recode record, Example example) {
        return getMapper().updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Recode record, Example example) {
        return getMapper().updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Recode record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Recode record) {
        return getMapper().updateByPrimaryKey(record);
    }
    @Override
    public PageInfo<Recode> selectByExamplezForPage(Example example, Integer pageNo, Integer pageSize){
       return PageHelper.startPage(pageNo,pageSize).doSelectPageInfo(
               ()->getMapper().selectByExample(example)
       );
    }
}
