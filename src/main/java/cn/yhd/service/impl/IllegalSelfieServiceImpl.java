package cn.yhd.service.impl;

import cn.yhd.base.BaseServiceImpl;
import cn.yhd.base.BaseV2ServiceImpl;
import cn.yhd.base.IBaseMapper;
import cn.yhd.base.IBaseV2Mapper;
import cn.yhd.dao.ITbUserMapper;
import cn.yhd.dao.IllegalSelfieMapper;
import cn.yhd.entity.IllegalSelfie;
import cn.yhd.entity.TbUser;
import cn.yhd.entity.TbUserExample;
import cn.yhd.service.ITbUserService;
import cn.yhd.service.IllegalSelfieService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IllegalSelfieServiceImpl extends BaseV2ServiceImpl<IllegalSelfie, IllegalSelfie> implements IllegalSelfieService {
    @Resource
    IllegalSelfieMapper illegalSelfieMapper;
    @Override
    public IBaseV2Mapper<IllegalSelfie, IllegalSelfie> getMapper() {
        return illegalSelfieMapper;
    }
}
