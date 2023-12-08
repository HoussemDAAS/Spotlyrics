package service;



import model.Music;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MusicService {
    @GET("/search")
    public Call<Music> SearchMusic(@Query("q") String query);
}
