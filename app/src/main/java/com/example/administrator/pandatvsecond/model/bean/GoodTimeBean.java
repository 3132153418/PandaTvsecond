package com.example.administrator.pandatvsecond.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lenovo on 2017/7/31.
 */

public class GoodTimeBean {


    /**
     * videoset : {"0":{"vsid":"VSET100167216881","relvsid":"","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""},"count":"4555"}
     * video : [{"vsid":"VSET100167216881","order":"4559","vid":"890982baf79a4405a153652deb1d194b","t":"《精彩一刻》 20170731 小扫帚你好，小扫帚再见~","url":"http://tv.cntv.cn/video/VSET100167216881/890982baf79a4405a153652deb1d194b","ptime":"2017-07-31 10:32:15","img":"http://p3.img.cctvpic.com/fmspic/2017/07/31/890982baf79a4405a153652deb1d194b-20.jpg?p=2&h=120","len":"00:00:20","em":"CM01"},{"vsid":"VSET100167216881","order":"4557","vid":"49d704ca3b9940c1a61838d21f1690c3","t":"《精彩一刻》 20170731 乔伊：我不相信这就是结局","url":"http://tv.cntv.cn/video/VSET100167216881/49d704ca3b9940c1a61838d21f1690c3","ptime":"2017-07-31 10:30:08","img":"http://p5.img.cctvpic.com/fmspic/2017/07/31/49d704ca3b9940c1a61838d21f1690c3-34.jpg?p=2&h=120","len":"00:00:49","em":"CM01"},{"vsid":"VSET100167216881","order":"4556","vid":"6bd1bdb386dd4076a875e2ee3d977fb1","t":"《精彩一刻》 20170731 发发式翻滚，你值得拥有~","url":"http://tv.cntv.cn/video/VSET100167216881/6bd1bdb386dd4076a875e2ee3d977fb1","ptime":"2017-07-31 10:27:33","img":"http://p2.img.cctvpic.com/fmspic/2017/07/31/6bd1bdb386dd4076a875e2ee3d977fb1-9.jpg?p=2&h=120","len":"00:00:18","em":"CM01"},{"vsid":"VSET100167216881","order":"4558","vid":"666d13dff25647dd979998a8a51cdb0f","t":"《精彩一刻》 20170731 蹭痒痒，吃笋笋，抬脚脚","url":"http://tv.cntv.cn/video/VSET100167216881/666d13dff25647dd979998a8a51cdb0f","ptime":"2017-07-31 10:23:08","img":"http://p4.img.cctvpic.com/fmspic/2017/07/31/666d13dff25647dd979998a8a51cdb0f-34.jpg?p=2&h=120","len":"00:00:48","em":"CM01"},{"vsid":"VSET100167216881","order":"4554","vid":"7315f56e269b435e9109d7d933867810","t":"《精彩一刻》 20170731 甩的两眼发晕","url":"http://tv.cntv.cn/video/VSET100167216881/7315f56e269b435e9109d7d933867810","ptime":"2017-07-31 09:36:34","img":"http://p2.img.cctvpic.com/fmspic/2017/07/31/7315f56e269b435e9109d7d933867810-9.jpg?p=2&h=120","len":"00:00:14","em":"CM01"},{"vsid":"VSET100167216881","order":"4555","vid":"fa273b1f3a534d96a4827dc128e8651a","t":"《精彩一刻》 20170731 怎么感觉是三只猪跑出来了","url":"http://tv.cntv.cn/video/VSET100167216881/fa273b1f3a534d96a4827dc128e8651a","ptime":"2017-07-31 09:35:35","img":"http://p3.img.cctvpic.com/fmspic/2017/07/31/fa273b1f3a534d96a4827dc128e8651a-9.jpg?p=2&h=120","len":"00:00:16","em":"CM01"},{"vsid":"VSET100167216881","order":"4553","vid":"ee115c1e2626446c986fec8ff78df11c","t":"《精彩一刻》 20170731 大战神与小战神的pk","url":"http://tv.cntv.cn/video/VSET100167216881/ee115c1e2626446c986fec8ff78df11c","ptime":"2017-07-31 09:34:16","img":"http://p3.img.cctvpic.com/fmspic/2017/07/31/ee115c1e2626446c986fec8ff78df11c-50.jpg?p=2&h=120","len":"00:01:12","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public VideosetBean getVideoset() {
        return videoset;
    }

    public void setVideoset(VideosetBean videoset) {
        this.videoset = videoset;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideosetBean {
        /**
         * 0 : {"vsid":"VSET100167216881","relvsid":"","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""}
         * count : 4555
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private String count;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public static class _$0Bean {
            /**
             * vsid : VSET100167216881
             * relvsid :
             * name : 熊猫频道-精彩一刻
             * img : http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100167216881
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl :
             * sbsj : 2013-05-01
             * sbpd : 其他
             * desc : 精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。
             * playdesc :
             * zcr :
             * fcl :
             */

            private String vsid;
            private String relvsid;
            private String name;
            private String img;
            private String enname;
            private String url;
            private String cd;
            private String zy;
            private String bj;
            private String dy;
            private String js;
            private String nf;
            private String yz;
            private String fl;
            private String sbsj;
            private String sbpd;
            private String desc;
            private String playdesc;
            private String zcr;
            private String fcl;

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }
        }
    }

    public static class VideoBean {
        /**
         * vsid : VSET100167216881
         * order : 4559
         * vid : 890982baf79a4405a153652deb1d194b
         * t : 《精彩一刻》 20170731 小扫帚你好，小扫帚再见~
         * url : http://tv.cntv.cn/video/VSET100167216881/890982baf79a4405a153652deb1d194b
         * ptime : 2017-07-31 10:32:15
         * img : http://p3.img.cctvpic.com/fmspic/2017/07/31/890982baf79a4405a153652deb1d194b-20.jpg?p=2&h=120
         * len : 00:00:20
         * em : CM01
         */

        private String vsid;
        private String order;
        private String vid;
        private String t;
        private String url;
        private String ptime;
        private String img;
        private String len;
        private String em;

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }
    }
}
