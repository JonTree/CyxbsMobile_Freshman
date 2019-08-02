package com.mredrock.cyxbs.freshman.data.bean;

import java.util.List;

/**
 * Created by Tree on 2019/8/2 16:16
 */
public class GroupStudentBean {


    /**
     *
     * code : 200
     * info : ok
     * text : [{"name":"学院","data":"11111"},{"name":"学院","data":"11111"}]
     */

    private int code;
    private String info;
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

    public List<TextBean> getText() {
        return text;
    }

    public void setText(List<TextBean> text) {
        this.text = text;
    }

    public static class TextBean {
        /**
         * name : 学院
         * data : 11111
         */

        private String name;
        private String data;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}
