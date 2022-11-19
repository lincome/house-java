package com.spartacus.house.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spartacus.house.model.House;
import com.spartacus.house.service.HouseService;
import com.spartacus.house.mapper.HouseMapper;
import org.springframework.stereotype.Service;

/**
* @author spartacus
* @description 针对表【house】的数据库操作Service实现
* @createDate 2022-11-19 13:46:53
*/
@Service
public class HouseServiceImpl extends ServiceImpl<HouseMapper, House>
    implements HouseService{

}




