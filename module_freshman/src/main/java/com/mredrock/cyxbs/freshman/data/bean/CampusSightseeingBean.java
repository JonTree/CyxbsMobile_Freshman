package com.mredrock.cyxbs.freshman.data.bean;

import androidx.databinding.BaseObservable;

import java.util.List;

/**
 * Created by Tree on 2019/8/2 16:13
 */
public class CampusSightseeingBean extends BaseObservable {

    /**
     * code : 200
     * info : ok
     * text : {"title":"重邮2D地图","photo":"...","message":[{"name":"八十万","photo":"...."},{"name":"仰望八教","photo":"...."}]}
     */

    private int code;
    private String info;
    private TextBean text;

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

    public TextBean getText() {
        return text;
    }

    public void setText(TextBean text) {
        this.text = text;
    }

    public static class TextBean {
        /**
         * title : 重邮2D地图
         * photo : ...
         * message : [{"name":"八十万","photo":"...."},{"name":"仰望八教","photo":"...."}]
         */

        private String title;
        private String photo;
        private List<MessageBean> message;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public List<MessageBean> getMessage() {
            return message;
        }

        public void setMessage(List<MessageBean> message) {
            this.message = message;
        }

        public static class MessageBean {
            /**
             * name : 八十万
             * photo : ....
             */

            private String name;
            private String photo;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }
    }
}
