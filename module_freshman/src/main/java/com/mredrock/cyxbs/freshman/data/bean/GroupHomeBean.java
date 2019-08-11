package com.mredrock.cyxbs.freshman.data.bean;

import androidx.databinding.BaseObservable;

import java.util.List;

/**
 * Created by Tree on 2019/8/11 13:45
 * @author 12466
 */
public class GroupHomeBean implements GroupBean{

    /**
     *
     * code : 200
     * info : ok
     * text : [{"name":"学院","data":"11111"},{"name":"学院","data":"11111"}]
     */

    private int code;
    private String info;
    private List<GroupStudentBean.TextBean> text;

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

    public List<GroupStudentBean.TextBean> getText() {
        return text;
    }

    public void setText(List<GroupStudentBean.TextBean> text) {
        this.text = text;
    }

    public static class TextBean extends BaseObservable {
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
