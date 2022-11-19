package com.spartacus.house.mapper;

import com.spartacus.house.model.House;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author spartacus
* @description 针对表【house】的数据库操作Mapper
* @createDate 2022-11-19 13:46:53
* @Entity com.spartacus.house.model.House
*/

@Mapper
public interface HouseMapper extends BaseMapper<House> {

}




