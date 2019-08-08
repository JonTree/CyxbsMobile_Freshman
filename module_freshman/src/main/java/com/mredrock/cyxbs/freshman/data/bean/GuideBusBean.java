package com.mredrock.cyxbs.freshman.data.bean;

import androidx.databinding.BaseObservable;

import java.util.List;

/**
 * Created by Tree on 2019/8/2 16:12
 */
public class GuideBusBean extends BaseObservable {


    /**
     * code : 200
     * info : ok
     * text_1 : {"title":"重庆邮电大学地址:","message":"重庆市南岸区南山街道崇文路2号重庆邮电大学"}
     * text_2 : {"title":"推荐线路:","message":[{"name":"重庆火车北站北广场/南广场","route":["...","...."]},{"name":"江北机场","route":["....","......"]}]}
     */

    private int code;
    private String info;
    private Text1Bean text_1;
    private Text2Bean text_2;

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

    public Text1Bean getText_1() {
        return text_1;
    }

    public void setText_1(Text1Bean text_1) {
        this.text_1 = text_1;
    }

    public Text2Bean getText_2() {
        return text_2;
    }

    public void setText_2(Text2Bean text_2) {
        this.text_2 = text_2;
    }

    public static class Text1Bean {
        /**
         * title : 重庆邮电大学地址:
         * message : 重庆市南岸区南山街道崇文路2号重庆邮电大学
         */

        private String title;
        private String message;

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
    }

    public static class Text2Bean {
        /**
         * title : 推荐线路:
         * message : [{"name":"重庆火车北站北广场/南广场","route":["...","...."]},{"name":"江北机场","route":["....","......"]}]
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
             * name : 重庆火车北站北广场/南广场
             * route : ["...","...."]
             */

            private String name;
            private List<String> route;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<String> getRoute() {
                return route;
            }

            public void setRoute(List<String> route) {
                this.route = route;
            }
        }
    }
}
