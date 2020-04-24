package com.bw.movie.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
//正在上映
public class Movie_ReleaseMovieBean {


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

    public static class ResultBean implements Parcelable {
        /**
         * director : 曾国祥
         * imageUrl : http://mobile.bwstudent.com/images/movie/stills/sndn/sndn1.jpg
         * movieId : 22
         * name : 少年的你
         * score : 9.5
         * starring : 周冬雨,易烊千玺,张耀,周也,尹昉
         */

        private String director;
        private String imageUrl;
        private int movieId;
        private String name;
        private double score;
        private String starring;

        protected ResultBean(Parcel in) {
            director = in.readString();
            imageUrl = in.readString();
            movieId = in.readInt();
            name = in.readString();
            score = in.readDouble();
            starring = in.readString();
        }

        public static final Creator<ResultBean> CREATOR = new Creator<ResultBean>() {
            @Override
            public ResultBean createFromParcel(Parcel in) {
                return new ResultBean(in);
            }

            @Override
            public ResultBean[] newArray(int size) {
                return new ResultBean[size];
            }
        };

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(director);
            dest.writeString(imageUrl);
            dest.writeInt(movieId);
            dest.writeString(name);
            dest.writeDouble(score);
            dest.writeString(starring);
        }
    }
}
