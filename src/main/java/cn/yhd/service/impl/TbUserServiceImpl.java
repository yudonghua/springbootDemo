package cn.yhd.service.impl;

import cn.yhd.base.BaseServiceImpl;
import cn.yhd.base.IBaseMapper;
import cn.yhd.dao.ITbUserMapper;
import cn.yhd.entity.TbUser;
import cn.yhd.entity.TbUserExample;
import cn.yhd.service.ITbUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class TbUserServiceImpl extends BaseServiceImpl<TbUser, TbUserExample> implements ITbUserService {
    @Resource
    ITbUserMapper tbUserMapper;
    @Override
    public IBaseMapper<TbUser, TbUserExample> getMapper() {
        return tbUserMapper;
    }
}
