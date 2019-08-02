package com.mredrock.cyxbs.freshman.data.bean;

import java.util.List;

/**
 * Created by Tree on 2019/8/2 16:02
 */
public class ProcessBean {

    /**
     * code : 200
     * info : ok
     * test : [{"title":"报到时间","message":"9月5-6日","photo":"...","detail":""},{"title":"报到","message":"持通知书、身份证....","photo":"...","detail":"持通知书、身份证...."}]
     */

    private int code;
    private String info;
    private List<TestBean> test;

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

    public List<TestBean> getTest() {
        return test;
    }

    public void setTest(List<TestBean> test) {
        this.test = test;
    }

    public static class TestBean {
        /**
         * title : 报到时间
         * message : 9月5-6日
         * photo : ...
         * detail :
         */

        private String title;
        private String message;
        private String photo;
        private String detail;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }
}
