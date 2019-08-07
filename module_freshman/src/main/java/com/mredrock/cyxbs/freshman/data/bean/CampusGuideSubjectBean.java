package com.mredrock.cyxbs.freshman.data.bean;

import androidx.databinding.BaseObservable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Tree on 2019/8/2 16:03
 * @author 12466
 */
public class CampusGuideSubjectBean extends BaseObservable implements Serializable{


    /**
     * code : 200
     * info : ok
     * title : 最难科目
     * text : [{"name":"学院","message":[{"subject":"....","data":"...."},{"subject":"....","data":"...."},{"subject":"....","data":"...."}]},{"name":"学院","message":[{"subject":".....","data":"...."},{"subject":".....","data":"....."},{"subject":".....","data":"....."}]}]
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

    public static class TextBean extends BaseObservable implements Serializable{
        /**
         * name : 学院
         * message : [{"subject":"....","data":"...."},{"subject":"....","data":"...."},{"subject":"....","data":"...."}]
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

        public static class MessageBean extends BaseObservable implements Serializable {
            /**
             * subject : ....
             * data : ....
             */

            private String subject;
            private String data;

            public String getSubject() {
                return subject;
            }

            public void setSubject(String subject) {
                this.subject = subject;
            }

            public String getData() {
                return data;
            }

            public void setData(String data) {
                this.data = data;
            }
        }
    }
}
