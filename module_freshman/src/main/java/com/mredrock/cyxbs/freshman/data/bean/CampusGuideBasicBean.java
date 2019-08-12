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
     * update_date : 2019-08-12 13:20:01
     * text : [{"title":"学生寝室","message":[{"name":"明理苑","detail":"明理苑（24\u201431,39）：位于千喜鹤食堂正街上，可以俯瞰全校以及南山的部分美丽景色，这里也是重邮夏天最凉爽的地方。可以坐私家车直达寝室，周围有两个超市和商铺，并且校车穿过。\r\n每个寝室都为6人间，并设有独立卫生间，每一栋楼里面配置有洗衣机可供大家使用，应有尽有，可以尽情满足同学们的平日生活需求。","photo":["3-1-1-1.jpg","3-1-1-2.JPG","3-1-1-3.JPG","3-1-1-4.JPG","3-1-1-5.jpg","3-1-1-6.jpg"]},{"name":"宁静苑","detail":"宁静苑（8\u201412，32--35）：坐落在美丽的情人坡旁，是妹子们散心聊天约会的好去处；篮球、网球、羽毛球这些周围球场为大家的锻炼提供了方便，与新校区紧连，周边分布有\u201c千喜鹤\u201d、\u201c延生\u201d等食堂。\r\n宿舍基本为6人间基本情况与22-24相同且有独立的阳台、卫浴，床铺是上下铺与上床下桌的混搭，人流量很少，环境比较清静。","photo":["3-1-2-1.JPG","3-1-2-2.JPG","3-1-2-3.JPG","3-1-2-4.JPG","3-1-2-5.JPG"]},{"name":"兴业苑","detail":"兴业苑（17--23栋）：屹立于悠悠重邮高处，周边风景秀丽，分布在太极运动场周围，，周边有学校的兴业苑食堂及众多的超市、商铺，校车从这里穿过。\r\n内部均设有独立卫生间，并在一些楼层设有洗衣机供大家使用，根据每栋宿舍不同，楼层不同分为4人间、6人间两种。4人间都是上床下铺，而6人间则是上下铺与上床下桌的混搭。","photo":["3-1-3-1.JPG","3-1-3-2.JPG","3-1-3-3.JPG","3-1-3-4.JPG"]},{"name":"知行苑","detail":"知行苑（1\u20146，15,16）：位于中心食堂附近的1,5,6栋是学校现存最老的寝室，住宿条件比较差，整体情况是每层楼设有公用的卫生间，洗澡间。但位于校园中心，上课，生活都极为便利。15.16栋寝室则在太极运动场旁边，楼下是商店和快递点，附近有红高粱和兴业苑食堂，十分便利。\r\n1.5.6栋寝室为6人间，上下均为床铺，内部没有独立卫生间和阳台。15.16栋则为学校标准的4人间，上床下桌，配有阳台，独立卫生间。\r\n","photo":["3-1-4-1.JPG","3-1-4-2.JPG","3-1-4-3.JPG","3-1-4-4.JPG"]}]},{"title":"学生食堂","message":[{"name":"大西北","detail":"大西北背靠中心食堂，面朝着宁静苑4舍，同中心食堂一般，因着优越的地理位置成为了学生上课早餐首选。靠着北方师傅的一手好厨艺，虽说是地处川渝地区，但也能品味到一两点奢侈的北方滋味。不同于其他食堂的是，大西北食堂的空间较小，堂食的学生较少，更多的青睐来自于它极为迅敏的打包速度。\r\n推荐菜品：羊肉泡馍，大盘鸡盖饭\r\n人均消费：8元","photo":["3-2-1-1.jpg","3-2-1-2.jpg","3-2-1-3.JPG"]},{"name":"红高粱","detail":"红高粱食堂伫立于兴业苑食堂上方，红高粱食堂总具有自己的风格，不断推陈出新，在这里你可以品尝到新的变化！\r\n推荐菜目：冒菜，花溪米线，土耳其烤肉饭\r\n人均消费：12元\r\n","photo":["3-2-2-1.jpg","3-2-2-2.jpg","3-2-2-3.jpg"]},{"name":"千喜鹤","detail":"千喜鹤怕是重邮最具重庆味道的食堂了，不过这品味的不是麻辣鲜香的那一味，而是重庆高低井然错落有致的建筑风格，除去对着明理苑的正门，你同时还可以从延生内部和楼下的楼梯直上。倘若说在食堂中挑一个最喜欢的，那千喜鹤一定是高居榜首的那一个，相比于食堂，千喜鹤更像是一个美食广场，从西式快餐到中式早点，从日常正餐到饭后甜点，可谓是应有尽有。\r\n推荐菜目：火锅米线，豆浆记忆，盐酥鸡\r\n人均消费：18元","photo":["3-2-3-1.jpg","3-2-3-2.jpg","3-2-3-3.jpg"]},{"name":"兴业苑","detail":"兴业苑食堂作为老一派的食堂，与中心食堂一样，不断沉淀自己的重庆味道，色香味俱全的家烧菜肴，总有一款美味属于家的味道。\r\n推荐菜目：青椒炒肉丝，回锅肉，辣子鸡丁\r\n人均消费：9元\r\n","photo":["3-2-4-1.jpg","3-2-4-2.jpg","3-2-4-3.JPG"]},{"name":"延生食堂","detail":"被宁静苑和知行苑两相环绕，算的是颇为优越的地理位置。没有富丽堂皇的过分修饰，多的是一览无余的简单明了。亲切，日常，这两个词来形容延生食堂最合适不过了，亲切的是带有两三分家长里短的味道，日常的是朝朝暮暮交错间穿梭的身影。\r\n推荐菜目：冒菜，鲜榨豆浆，羊肉粉\r\n人均消费：10元","photo":["3-2-5-1.jpg","3-2-5-2.jpg","3-2-5-3.jpg"]},{"name":"中心食堂","detail":"中心食堂：\r\n与雨红莲广场毗连，又与风华操场隔道相望的它，由于与二教距离甚近，也常常是同学们打包就餐的不二选择。它以低廉的价格和繁多的种类，在同学们的心中占有绝对地位。\r\n推荐菜目：早餐时段售卖的麻团，糍粑和荤素包子，糖醋里脊\r\n人均消费：8元","photo":["3-2-6-1.jpg","3-2-6-2.jpg","3-2-6-3.jpg"]}]}]
     */

    private int code;
    private String info;
    private String update_date;
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

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }

    public List<TextBean> getText() {
        return text;
    }

    public void setText(List<TextBean> text) {
        this.text = text;
    }

    public static class TextBean {
        /**
         * title : 学生寝室
         * message : [{"name":"明理苑","detail":"明理苑（24\u201431,39）：位于千喜鹤食堂正街上，可以俯瞰全校以及南山的部分美丽景色，这里也是重邮夏天最凉爽的地方。可以坐私家车直达寝室，周围有两个超市和商铺，并且校车穿过。\r\n每个寝室都为6人间，并设有独立卫生间，每一栋楼里面配置有洗衣机可供大家使用，应有尽有，可以尽情满足同学们的平日生活需求。","photo":["3-1-1-1.jpg","3-1-1-2.JPG","3-1-1-3.JPG","3-1-1-4.JPG","3-1-1-5.jpg","3-1-1-6.jpg"]},{"name":"宁静苑","detail":"宁静苑（8\u201412，32--35）：坐落在美丽的情人坡旁，是妹子们散心聊天约会的好去处；篮球、网球、羽毛球这些周围球场为大家的锻炼提供了方便，与新校区紧连，周边分布有\u201c千喜鹤\u201d、\u201c延生\u201d等食堂。\r\n宿舍基本为6人间基本情况与22-24相同且有独立的阳台、卫浴，床铺是上下铺与上床下桌的混搭，人流量很少，环境比较清静。","photo":["3-1-2-1.JPG","3-1-2-2.JPG","3-1-2-3.JPG","3-1-2-4.JPG","3-1-2-5.JPG"]},{"name":"兴业苑","detail":"兴业苑（17--23栋）：屹立于悠悠重邮高处，周边风景秀丽，分布在太极运动场周围，，周边有学校的兴业苑食堂及众多的超市、商铺，校车从这里穿过。\r\n内部均设有独立卫生间，并在一些楼层设有洗衣机供大家使用，根据每栋宿舍不同，楼层不同分为4人间、6人间两种。4人间都是上床下铺，而6人间则是上下铺与上床下桌的混搭。","photo":["3-1-3-1.JPG","3-1-3-2.JPG","3-1-3-3.JPG","3-1-3-4.JPG"]},{"name":"知行苑","detail":"知行苑（1\u20146，15,16）：位于中心食堂附近的1,5,6栋是学校现存最老的寝室，住宿条件比较差，整体情况是每层楼设有公用的卫生间，洗澡间。但位于校园中心，上课，生活都极为便利。15.16栋寝室则在太极运动场旁边，楼下是商店和快递点，附近有红高粱和兴业苑食堂，十分便利。\r\n1.5.6栋寝室为6人间，上下均为床铺，内部没有独立卫生间和阳台。15.16栋则为学校标准的4人间，上床下桌，配有阳台，独立卫生间。\r\n","photo":["3-1-4-1.JPG","3-1-4-2.JPG","3-1-4-3.JPG","3-1-4-4.JPG"]}]
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
             * detail : 明理苑（24—31,39）：位于千喜鹤食堂正街上，可以俯瞰全校以及南山的部分美丽景色，这里也是重邮夏天最凉爽的地方。可以坐私家车直达寝室，周围有两个超市和商铺，并且校车穿过。
             每个寝室都为6人间，并设有独立卫生间，每一栋楼里面配置有洗衣机可供大家使用，应有尽有，可以尽情满足同学们的平日生活需求。
             * photo : ["3-1-1-1.jpg","3-1-1-2.JPG","3-1-1-3.JPG","3-1-1-4.JPG","3-1-1-5.jpg","3-1-1-6.jpg"]
             */

            private String name;
            private String detail;
            private List<String> photo;

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

            public List<String> getPhoto() {
                return photo;
            }

            public void setPhoto(List<String> photo) {
                this.photo = photo;
            }
        }
    }
}
