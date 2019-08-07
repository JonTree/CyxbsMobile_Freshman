package com.mredrock.cyxbs.freshman.data.bean;

import java.util.List;

/**
 * Created by Tree on 2019/8/7 17:32
 */
public class CampusGuideManAndWomanBean {

    /**
     * code : 200
     * info : ok
     * title : 男女比例
     * text : [{"name":"学院","boy":"11%","girl":"11%"},{"name":"学院","boy":"11%","girl":"11%"}]
     */

    private int code;
    private String info;
    private String title;
    private List<TextBean> text;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TextBean> getText() {
        return text;
    }

    public void setText(List<TextBean> text) {
        this.text = text;
    }

    public static class TextBean {
        /**
         * name : 学院
         * boy : 11%
         * girl : 11%
         */

        private String name;
        private String boy;
        private String girl;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBoy() {
            return boy;
        }

        public void setBoy(String boy) {
            this.boy = boy;
        }

        public String getGirl() {
            return girl;
        }

        public void setGirl(String girl) {
            this.girl = girl;
        }
    }
}
