package com.mredrock.cyxbs.freshman.data.bean;

import android.util.Log;
import androidx.databinding.BaseObservable;
import com.mredrock.cyxbs.common.utils.LogUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Tree on 2019/8/2 16:01
 */
public class NecessityBean extends BaseObservable implements Serializable {

    /**
     * code : 200
     * info : ok
     * text : [{"title":"报道必备","data":[{"name":"录取通知书","detail":"...."},{"name":"高考准考证","detail":"...."}]},{"title":"军训必备","data":[{"name":"花露水","detail":"...."},{"name":"防暑药","detail":"...."}]},{"title":"*以下为非必需","data":[{"name":"*学籍档案","detail":"...."},{"name":"*本人户口本内页","detail":"...."}]}]
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
         * title : 报道必备
         * data : [{"name":"录取通知书","detail":"...."},{"name":"高考准考证","detail":"...."}]
         */

        private String title;
        private List<DataBean> data;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
            notifyChange();
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
            notifyChange();
        }

        public void removeData(List<DataBean> data){
            this.data.removeAll(data);
            notifyChange();
        }
        public void addData(List<DataBean> data){
            this.data.addAll(data);
            notifyChange();
        }

        public static class DataBean extends BaseObservable{
            /**
             * name : 录取通知书
             * detail : ....
             */
            public void changeOpenState(){
                if(openAble){
                    open = !open;
                    notifyChange();
                }
            }
            private String name;
            private String detail;
            private boolean open = false;
            private boolean openAble;
            private boolean choosed = false;
            public void onCheckBoxClicked(){
                choosed = !choosed;
                notifyChange();
            }

            public boolean getOpenAble() {
                return openAble;
            }

            public void setOpenAble(boolean openAble) {
                this.openAble = openAble;
                notifyChange();
            }

            public boolean getChoosed() {
                return choosed;
            }

            public void setChoosed(boolean choosed) {
                this.choosed = choosed;
                Log.d("TestTag","setchoosed");
                notifyChange();
            }

            public boolean getOpen() {
                return open;
            }

            public void setOpen(boolean open) {
                this.open = open;
                notifyChange();
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
                notifyChange();
            }

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
                notifyChange();
            }
        }
    }
}
