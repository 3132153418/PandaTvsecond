package com.example.administrator.pandatvsecond.model.bean.live;

import java.util.List;

/**
 * Created by lenovo on 2017/8/1.
 */

public class AllLiveFragmentBean {


    private List<TablistBean> tablist;

    public List<TablistBean> getTablist() {
        return tablist;
    }

    public void setTablist(List<TablistBean> tablist) {
        this.tablist = tablist;
    }

    public static class TablistBean {
        /**
         * id : TITE1451020547008725
         * order : 1
         * title : 直播
         * url : http://www.ipanda.com/kehuduan/PAGE14501769230331752/index.json
         */

        private String id;
        private String order;
        private String title;
        private String url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
