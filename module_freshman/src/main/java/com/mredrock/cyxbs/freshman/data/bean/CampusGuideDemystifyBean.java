package com.mredrock.cyxbs.freshman.data.bean;

import java.util.List;

/**
 * Created by Tree on 2019/8/2 16:10
 */
public class CampusGuideDemystifyBean {

    /**
     * code : 200
     * info : ok
     * text : [{"name":"学院","message":[{"title":"最难科目","data":[{"subject_1":"数学","data":"80%"},{"subject_2":"物理","data":"80%"}]},{"title":"男女比例","boy":"20%","girl":"80%"}]},{"name":"学院","message":[{"title":"最难科目","data":[{"subject_1":"数学","data":"80%"},{"subject_2":"物理","data":"80%"}]},{"title":"男女比例","boy":"20%","girl":"80%"}]}]
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
         * message : [{"title":"最难科目","data":[{"subject_1":"数学","data":"80%"},{"subject_2":"物理","data":"80%"}]},{"title":"男女比例","boy":"20%","girl":"80%"}]
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
             * title : 最难科目
             * data : [{"subject_1":"数学","data":"80%"},{"subject_2":"物理","data":"80%"}]
             * boy : 20%
             * girl : 80%
             */

            private String title;
            private String boy;
            private String girl;
            private List<DataBean> data;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
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

            public List<DataBean> getData() {
                return data;
            }

            public void setData(List<DataBean> data) {
                this.data = data;
            }

            public static class DataBean {
                /**
                 * subject_1 : 数学
                 * data : 80%
                 * subject_2 : 物理
                 */

                private String subject_1;
                private String data;
                private String subject_2;

                public String getSubject_1() {
                    return subject_1;
                }

                public void setSubject_1(String subject_1) {
                    this.subject_1 = subject_1;
                }

                public String getData() {
                    return data;
                }

                public void setData(String data) {
                    this.data = data;
                }

                public String getSubject_2() {
                    return subject_2;
                }

                public void setSubject_2(String subject_2) {
                    this.subject_2 = subject_2;
                }
            }
        }
    }
}
