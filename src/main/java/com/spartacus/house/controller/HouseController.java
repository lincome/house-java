package com.spartacus.house.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.spartacus.house.dto.HouseDto;
import com.spartacus.house.exception.ServiceException;
import com.spartacus.house.mapper.HouseMapper;
import com.spartacus.house.model.House;
import com.spartacus.house.result.GlobalResult;
import com.spartacus.house.result.GlobalResultGenerator;
import com.spartacus.house.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author spartacus
 */
@RestController
@CrossOrigin
public class HouseController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private HouseService houseService;

    @Autowired
    private HouseMapper houseMapper;

    @RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
    public GlobalResult<House> index(@Validated @PathVariable("id") Integer id) throws ServiceException {
        House house = houseService.getById(id);
        stringRedisTemplate.opsForValue().set("strKey", "zwqh");
        System.out.println(stringRedisTemplate.opsForValue().get("strKey"));
        return GlobalResultGenerator.genSuccessResult(house);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public GlobalResult<Boolean> add(@RequestBody JSONObject jsonObject) throws ServiceException {
        House user = JSON.parseObject(jsonObject.toJSONString(), House.class);
        user.setCreatedTime(new Date());// 设置创建时间
        user.setDate(new Date());// 设置创建时间
        user.setUpdatedTime(new Date());// 设置创建时间
        user.setArea("ddd");
        // result.success("添加成功！");
        // String salt = oConvertUtils.randomGen(8);
        // user.setSalt(salt);
        // String passwordEncode = PasswordUtil.encrypt(user.getUsername(),
        // user.getPassword(), salt);
        // user.setPassword(passwordEncode);
        // user.setStatus(1);
        // user.setDelFlag(CommonConstant.DEL_FLAG_0);
        // 用户表字段org_code不能在这里设置他的值
        // user.setOrgCode(null);
        // 保存用户走一个service 保证事务
        boolean flag = houseService.save(user);

        return GlobalResultGenerator.genSuccessResult(flag);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public GlobalResult<Boolean> edit(@RequestBody JSONObject jsonObject) throws ServiceException {
        House user = JSON.parseObject(jsonObject.toJSONString(), House.class);
        user.setCreatedTime(new Date());// 设置创建时间
        user.setDate(new Date());// 设置创建时间
        user.setUpdatedTime(new Date());// 设置创建时间
        user.setArea("ddd");
        boolean flag = houseService.updateById(user);

        return GlobalResultGenerator.genSuccessResult(flag);
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public GlobalResult<Boolean> del(@RequestBody JSONObject jsonObject) throws ServiceException {
        House user = JSON.parseObject(jsonObject.toJSONString(), House.class);
        user.setCreatedTime(new Date());// 设置创建时间
        user.setDate(new Date());// 设置创建时间
        user.setUpdatedTime(new Date());// 设置创建时间
        user.setArea("ddd");
        boolean flag = houseService.removeById(user);

        String[] myArray = {"Apple", "Banana", "Orange"};
        List<String> myList = Arrays.asList(myArray);

        return GlobalResultGenerator.genSuccessResult(flag);
    }

    @GetMapping("/get")
    public GlobalResult<HouseDto> get(@RequestParam(defaultValue = "0") Integer page,
                                      @RequestParam(name = "limit") String limit,
                                      @RequestParam(name = "group") String group) {
        HouseDto houseDto = new HouseDto();

        List<String> areaRangeData = Arrays.asList("闽侯", "连江", "罗源", "闽清", "永泰", "长乐", "福清", "鼓楼区", "台江区", "晋安区", "马尾区", "仓山区");
        houseDto.setAreaRangeData(areaRangeData);

        List<HouseDto.AreaRangeBean> areaRangeList = new ArrayList<>();
        for (String areaRange : areaRangeData) {
            HouseDto.AreaRangeBean areaRangeBean = new HouseDto.AreaRangeBean();
            areaRangeBean.setLabel(areaRange);
            areaRangeBean.setValue(areaRange);
            areaRangeList.add(areaRangeBean);
        }
        houseDto.setAreaRange(areaRangeList);

        List<String> groupRange = Arrays.asList("day", "month", "year");
        List<HouseDto.GroupDataBean> groupData = new ArrayList<>();
        for (String group1 : groupRange) {
            HouseDto.GroupDataBean groupDataBean = new HouseDto.GroupDataBean();
            groupDataBean.setLabel(group1);
            groupDataBean.setValue(group1);
            groupData.add(groupDataBean);
        }
        houseDto.setGroupData(groupData);

        List<HouseDto.LimitRangeBean> limitRange = new ArrayList<>();
        List<Integer> limitRangeData = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 365);
        for (int day : limitRangeData) {
            HouseDto.LimitRangeBean limitRangeBean = new HouseDto.LimitRangeBean();
            limitRangeBean.setLabel(day);
            limitRangeBean.setValue(day);
            limitRange.add(limitRangeBean);
        }
        houseDto.setLimitRange(limitRange);

       // LambdaQueryWrapper<House> query = new LambdaQueryWrapper<>();
       // query.orderByAsc(House::getDate);
       // query.gt(House::getDate,"2022-10-01");
       // query.groupBy(House::getDate);
       // query.groupBy(House::getArea);

        // 2. 查询消息数据
        String date = "2022-10-01";
        List<House> list = houseMapper.queryList(date, group);

       // List<House> list = houseService.list(query);
        List<HouseDto.SeriesDataBean> seriesData = new ArrayList<>();
        List<String> xData = new ArrayList<>();
       // Set<String> xData = new HashSet<>();
        if (list.size() > 0) {
            //x轴
            //组合区域map
            Map<String, List<Integer>> areaMap = new HashMap<>();
            for (House house : list) {
                if (areaMap.containsKey(house.getArea())) {
                    areaMap.get(house.getArea()).add(house.getRoomNumber());
                } else {
                    List<Integer> roomNumber = new ArrayList<>();
                    roomNumber.add(house.getRoomNumber());
                    areaMap.put(house.getArea(), roomNumber);
                }
                SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
                xData.add(ft.format(house.getDate()));
            }
            //set集合去重，不打乱顺序
            Set<String> set = new HashSet<String>();
            List<String> newList = new ArrayList<String>();
            for (String cd : xData) {
                if (set.add(cd)) {
                    newList.add(cd);
                }
            }
           // System.out.println(newList);
           // List<String> newList = new ArrayList<String>(xData);
            houseDto.setXaData(newList);
            for (String areaRange : areaRangeData) {
                HouseDto.SeriesDataBean seriesDataBean = new HouseDto.SeriesDataBean();
                seriesDataBean.setData(areaMap.get(areaRange));
                seriesDataBean.setName(areaRange);
                seriesDataBean.setType("line");
                seriesData.add(seriesDataBean);
            }
            houseDto.setSeriesData(seriesData);
        }
        return GlobalResultGenerator.genSuccessResult(houseDto);
    }
}
