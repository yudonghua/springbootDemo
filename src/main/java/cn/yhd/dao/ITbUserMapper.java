package cn.yhd.dao;

import cn.yhd.base.IBaseMapper;
import cn.yhd.bean.User;
import cn.yhd.entity.TbUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by PC on 2018/8/26.
 */
@Mapper
public interface ITbUserMapper extends IBaseMapper {
    TbUser getAllUser();
}