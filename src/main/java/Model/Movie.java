package Model;

public class Movie {

    private int id;
    private String Title;
    private String TitleSub;
    private String Summary;
    private float IMDBRank;
    private String Producer;
    private int Year;
    private String Time;
    private String Quality;
    private String UrlImg;
    private String UrlMovie;
    private int status;

    public Movie(int id, String title, String titleSub, String summary, float IMDBRank, String producer, int year, String time, String quality, String urlImg, String urlMovie) {
        this.id = id;
        Title = title;
        TitleSub = titleSub;
        this.IMDBRank = IMDBRank;
        Producer = producer;
        Year = year;
        Time = time;
        Quality = quality;
        UrlImg = urlImg;
        UrlMovie = urlMovie;
        Summary = summary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTitleSub() {
        return TitleSub;
    }

    public void setTitleSub(String titleSub) {
        TitleSub = titleSub;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public float getIMDBRank() {
        return IMDBRank;
    }

    public void setIMDBRank(float IMDBRank) {
        this.IMDBRank = IMDBRank;
    }

    public String getProducer() {
        return Producer;
    }

    public void setProducer(String producer) {
        Producer = producer;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getQuality() {
        return Quality;
    }

    public void setQuality(String quality) {
        Quality = quality;
    }

    public String getUrlImg() {
        return UrlImg;
    }

    public void setUrlImg(String urlImg) {
        UrlImg = urlImg;
    }

    public String getUrlMovie() {
        return UrlMovie;
    }

    public void setUrlMovie(String urlMovie) {
        UrlMovie = urlMovie;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
