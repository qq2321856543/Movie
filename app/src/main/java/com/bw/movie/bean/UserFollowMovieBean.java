package com.bw.movie.bean;

import java.util.List;

public class UserFollowMovieBean {

    /**
     * result : [{"director":"吕乐","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/zdn/zdn1.jpg","movieId":21,"name":"找到你","score":8.5,"starring":"姚晨,马伊琍,袁文康,吴昊宸"},{"director":"\r\n李仁港","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/pdz/pdz1.jpg","movieId":25,"name":"攀登者","score":9.4,"starring":"吴京,章子怡,井柏然,胡歌"},{"director":"克里斯托弗·麦奎里","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg","movieId":16,"name":"碟中谍6：全面瓦解","score":8.9,"starring":"汤姆·克鲁斯,亨利·卡维尔,丽贝卡·弗格森,西蒙·佩吉"},{"director":"曾国祥","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/sndn/sndn1.jpg","movieId":22,"name":"少年的你","score":9.5,"starring":"周冬雨,易烊千玺,张耀,周也,尹昉"},{"director":"\r\n刘伟强","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/zgjz/zgjz1.jpg","movieId":24,"name":"中国机长","score":9.4,"starring":"张涵予,欧豪,袁泉,张天爱,李沁"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * director : 吕乐
         * imageUrl : http://mobile.bwstudent.com/images/movie/stills/zdn/zdn1.jpg
         * movieId : 21
         * name : 找到你
         * score : 8.5
         * starring : 姚晨,马伊琍,袁文康,吴昊宸
         */

        private String director;
        private String imageUrl;
        private int movieId;
        private String name;
        private double score;
        private String starring;

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getStarring() {
            return starring;
        }

        public void setStarring(String starring) {
            this.starring = starring;
        }
    }
}
