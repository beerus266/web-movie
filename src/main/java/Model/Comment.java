package Model;

public class Comment {

    private int id ;
    private int MovieId ;
    private int UserId ;
    private String Username;
    private String Content;
    private int LikeQuantity;


    private int ReplyCmtId;
    private String Time;
    private int status;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return MovieId;
    }

    public void setMovieId(int movieId) {
        MovieId = movieId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public int getLikeQuantity() {
        return LikeQuantity;
    }

    public void setLikeQuantity(int likeQuantity) {
        LikeQuantity = likeQuantity;
    }

    public int getReplyCmtId() {
        return ReplyCmtId;
    }

    public void setReplyCmtId(int replyCmtId) {
        ReplyCmtId = replyCmtId;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
