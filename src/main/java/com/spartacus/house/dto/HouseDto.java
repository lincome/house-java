package com.spartacus.house.dto;

import java.util.List;

public class HouseDto {
    /**
     * xaData : ["2022-10-29","2022-10-30","2022-10-31","2022-11-01","2022-11-02","2022-11-03","2022-11-04","2022-11-05","2022-11-06","2022-11-07","2022-11-08","2022-11-09","2022-11-10","2022-11-11","2022-11-12","2022-11-13","2022-11-14","2022-11-15","2022-11-16","2022-11-17","2022-11-18","2022-11-19","2022-11-20","2022-11-21","2022-11-22","2022-11-23","2022-11-24","2022-11-25","2022-11-26"]
     * yData : null
     * areaRange : [{"value":"闽侯","label":"闽侯"},{"value":"连江","label":"连江"},{"value":"罗源","label":"罗源"},{"value":"闽清","label":"闽清"},{"value":"永泰","label":"永泰"},{"value":"长乐","label":"长乐"},{"value":"福清","label":"福清"},{"value":"鼓楼区","label":"鼓楼区"},{"value":"台江区","label":"台江区"},{"value":"晋安区","label":"晋安区"},{"value":"马尾区","label":"马尾区"},{"value":"仓山区","label":"仓山区"}]
     * areaRangeData : ["闽侯","连江","罗源","闽清","永泰","长乐","福清","鼓楼区","台江区","晋安区","马尾区","仓山区"]
     * limitRange : [{"value":10,"label":10},{"value":20,"label":20},{"value":30,"label":30},{"value":40,"label":40},{"value":50,"label":50},{"value":60,"label":60},{"value":70,"label":70},{"value":80,"label":80},{"value":90,"label":90},{"value":100,"label":100},{"value":365,"label":365}]
     * groupData : [{"value":"day","label":"day"},{"value":"month","label":"month"},{"value":"year","label":"year"}]
     * seriesData : [{"name":"闽侯","data":[19,9,8,19,2,2,1,3,4,2,1,2,3,3,3,2,4,6,9,2,12,6,13,27,8,8,14,9],"type":"line"},{"name":"连江","data":[9,5,7,12,10,8,9,9,4,1,7,6,221,3,5,5,9,10,10,13,16,12,6,5,14,7,5,10],"type":"line"},{"name":"罗源","data":[0,0,0,1,0,0,0,0,0,1,1,2,3,1,0,2,1,2,2,1,2,2,1,0,4,6,2,1],"type":"line"},{"name":"闽清","data":[2,1,1,1,0,1,0,13,0,0,1,0,1,2,2,0,0,1,1,2,2,1,3,2,1,3,6,1],"type":"line"},{"name":"永泰","data":[6,12,4,2,10,11,0,1,1,2,2,0,3,3,0,0,0,1,8,5,0,6,8,20,11,9,9,3],"type":"line"},{"name":"长乐","data":[8,0,0,5,3,68,7,4,5,10,5,5,7,0,3,2,2,6,10,9,10,2,5,2,4,6,7,5],"type":"line"},{"name":"福清","data":[8,5,9,19,8,8,9,3,4,6,14,7,3,5,10,0,3,10,13,10,8,6,6,21,21,10,3,6],"type":"line"},{"name":"鼓楼区","data":[0,0,0,0,0,1,1,0,0,0,1,0,0,0,1,1,1,2,1,1,0,0,0,0,0,1,2,0,0],"type":"line"},{"name":"台江区","data":[1,0,0,0,0,1,1,0,1,0,0,0,0,0,0,0,0,2,0,1,1,0,1,0,0,2,2,0,0],"type":"line"},{"name":"晋安区","data":[23,11,27,2,6,2,3,0,1,2,6,0,3,5,4,1,4,6,8,3,9,19,6,12,4,14,8,15,14],"type":"line"},{"name":"马尾区","data":[1,1,1,0,0,0,0,7,2,8,3,0,3,3,0,4,5,3,3,7,4,1,1,1,3,2,0,7,3],"type":"line"},{"name":"仓山区","data":[17,7,18,4,2,7,2,5,4,4,5,3,3,3,4,4,4,10,6,6,12,8,9,8,13,7,7,22,11],"type":"line"}]
     */

//    private Object yData;
    private List<String> xaData;
    private List<AreaRangeBean> areaRange;
    private List<String> areaRangeData;
    private List<LimitRangeBean> limitRange;
    private List<GroupDataBean> groupData;
    private List<SeriesDataBean> seriesData;

//    public Object getYData() {
//        return yData;
//    }
//
//    public void setYData(Object yData) {
//        this.yData = yData;
//    }

    public List<String> getXaData() {
        return xaData;
    }

    public void setXaData(List<String> xaData) {
        this.xaData = xaData;
    }

    public List<AreaRangeBean> getAreaRange() {
        return areaRange;
    }

    public void setAreaRange(List<AreaRangeBean> areaRange) {
        this.areaRange = areaRange;
    }

    public List<String> getAreaRangeData() {
        return areaRangeData;
    }

    public void setAreaRangeData(List<String> areaRangeData) {
        this.areaRangeData = areaRangeData;
    }

    public List<LimitRangeBean> getLimitRange() {
        return limitRange;
    }

    public void setLimitRange(List<LimitRangeBean> limitRange) {
        this.limitRange = limitRange;
    }

    public List<GroupDataBean> getGroupData() {
        return groupData;
    }

    public void setGroupData(List<GroupDataBean> groupData) {
        this.groupData = groupData;
    }

    public List<SeriesDataBean> getSeriesData() {
        return seriesData;
    }

    public void setSeriesData(List<SeriesDataBean> seriesData) {
        this.seriesData = seriesData;
    }

    public static class AreaRangeBean {
        /**
         * value : 闽侯
         * label : 闽侯
         */

        private String value;
        private String label;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }

    public static class LimitRangeBean {
        /**
         * value : 10
         * label : 10
         */

        private int value;
        private int label;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }

    public static class GroupDataBean {
        /**
         * value : day
         * label : day
         */

        private String value;
        private String label;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }

    public static class SeriesDataBean {
        /**
         * name : 闽侯
         * data : [19,9,8,19,2,2,1,3,4,2,1,2,3,3,3,2,4,6,9,2,12,6,13,27,8,8,14,9]
         * type : line
         */

        private String name;
        private String type;
        private List<Object> data;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<Object> getData() {
            return data;
        }

        public void setData(List<Object> data) {
            this.data = data;
        }
    }
}
