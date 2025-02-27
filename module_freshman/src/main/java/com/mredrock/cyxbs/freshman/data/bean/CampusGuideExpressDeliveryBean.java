package com.mredrock.cyxbs.freshman.data.bean;

import java.util.List;

/**
 * Created by Tree on 2019/8/4 17:39
 */
public class CampusGuideExpressDeliveryBean {

    /**
     * code : 200
     * info : ok
     * text : [{"name":"顺丰","message":[{"title":"樱花园","detail":".....................","photo":"...."}]},{"name":"圆通","message":[{"title":"樱花园","detail":"..............","photo":"...."},{"title":"樱花园","detail":"........","photo":"...."}]}]
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
         * name : 顺丰
         * message : [{"title":"樱花园","detail":".....................","photo":"...."}]
         */

        private String name;
        private List<MessageBean> message;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<MessageBean> getMessage() {
            return message;
        }

        public void setMessage(List<MessageBean> message) {
            this.message = message;
        }

        public static class MessageBean {
            /**
             * title : 樱花园
             * detail : .....................
             * photo : ....
             */

            private String title;
            private String detail;
            private String photo;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
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
