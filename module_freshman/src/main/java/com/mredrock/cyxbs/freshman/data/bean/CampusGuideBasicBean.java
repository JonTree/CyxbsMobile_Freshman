package com.mredrock.cyxbs.freshman.data.bean;

import androidx.databinding.BaseObservable;

import java.util.List;

/**
 * Created by Tree on 2019/8/2 16:07
 */
public class CampusGuideBasicBean extends BaseObservable {

    /**
     * code : 200
     * info : ok
     * text : [{"title":"宿舍","message":[{"name":"明理苑","detail":".....","photos":["...","..."]},{"name":"宁静苑","detail":".....","photos":["...","..."]}]},{"title":"食堂","message":[{"name":"红高粱","detail":"....","photos":["...","..."]},{"name":"中心食堂","detail":"....","photos":["...","..."]}]}]
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
         * title : 宿舍
         * message : [{"name":"明理苑","detail":".....","photos":["...","..."]},{"name":"宁静苑","detail":".....","photos":["...","..."]}]
         */

        private String title;
        private List<MessageBean> message;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<MessageBean> getMessage() {
            return message;
        }

        public void setMessage(List<MessageBean> message) {
            this.message = message;
        }

        public static class MessageBean {
            /**
             * name : 明理苑
             * detail : .....
             * photos : ["...","..."]
             */

            private String name;
            private String detail;
            private List<String> photos;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public List<String> getPhotos() {
                return photos;
            }

            public void setPhotos(List<String> photos) {
                this.photos = photos;
            }
        }
    }
}
