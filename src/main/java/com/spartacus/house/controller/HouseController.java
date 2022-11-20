package com.spartacus.house.controller;

import com.spartacus.house.exception.ServiceException;
import com.spartacus.house.model.House;
import com.spartacus.house.result.GlobalResult;
import com.spartacus.house.result.GlobalResultGenerator;
import com.spartacus.house.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author spartacus
 */
@RestController
public class HouseController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private HouseService houseService;

    @RequestMapping(value="/hello/{id}",method = RequestMethod.GET)
    public GlobalResult<House> index(@PathVariable("id") Integer id) throws ServiceException {
        House house = houseService.getById(id);
        stringRedisTemplate.opsForValue().set("strKey", "zwqh");
        System.out.println(stringRedisTemplate.opsForValue().get("strKey"));
        return GlobalResultGenerator.genSuccessResult(house);
    }
}
