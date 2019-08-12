package com.mredrock.cyxbs.freshman.data.bean;

import androidx.databinding.BaseObservable;

import java.util.List;
/**
 * Created by Tree on 2019/8/2 16:17
 * @author 12466
 */
public class OnlineActivitiesBean extends BaseObservable {


    /**
     * code : 200
     * info : ok
     * text : [{"name":"学长学姐帮帮忙","photo":"....","message":"....","QR":"...."},{"name":"学长学姐帮帮忙","photo":"....","message":"....","QR":"...."}]
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
         * name : 学长学姐帮帮忙
         * photo : ....
         * message : ....
         * QR : ....
         */

        private String name;
        private String photo;
        private String message;
        private String QR;

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

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getQR() {
            return QR;
        }

        public void setQR(String QR) {
            this.QR = QR;
        }
    }
}
