package com.bw.movie.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Movie_HotMovieBean {


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


        private String director;
        private String horizontalImage;
        private String imageUrl;
        private int movieId;
        private String name;
        private double score;
        private String starring;
        int type=2;

        protected ResultBean(Parcel in) {
            director = in.readString();
            horizontalImage = in.readString();
            imageUrl = in.readString();
            movieId = in.readInt();
            name = in.readString();
            score = in.readDouble();
            starring = in.readString();
            type = in.readInt();
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

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getHorizontalImage() {
            return horizontalImage;
        }

        public void setHorizontalImage(String horizontalImage) {
            this.horizontalImage = horizontalImage;
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
            dest.writeString(horizontalImage);
            dest.writeString(imageUrl);
            dest.writeInt(movieId);
            dest.writeString(name);
            dest.writeDouble(score);
            dest.writeString(starring);
            dest.writeInt(type);
        }
    }
}
