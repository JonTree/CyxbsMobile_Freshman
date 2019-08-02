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
     * text : [{"title":"宿舍","message":[{"name":"...","detail":"...","photo":"..."},{"name":"...","detail":"...","photo":"..."}]},{"title":"食堂","message":[{"name":"...","detail":"...","photo":"..."},{"name":"...","detail":"...","photo":"..."}]},{"title":"快递","message":[{"name":"...","detail":"...","photo":"..."},{"name":"...","detail":"...","photo":"..."}]}]
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

    public static class TextBean extends BaseObservable{
        /**
         * title : 宿舍
         * message : [{"name":"...","detail":"...","photo":"..."},{"name":"...","detail":"...","photo":"..."}]
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

        public static class MessageBean extends BaseObservable{
            /**
             * name : ...
             * detail : ...
             * photo : ...
             */

            private String name;
            private String detail;
            private String photo;

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

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }
    }
}
