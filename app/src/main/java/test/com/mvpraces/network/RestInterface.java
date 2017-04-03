package test.com.mvpraces.network;


import retrofit2.Call;
import retrofit2.http.GET;
import test.com.mvpraces.model.RaceResponse;

/**
 * Created by jmarti on 25/4/16.
 */
public interface RestInterface {

    String prefix = "/api";

    @GET(prefix + "/races")
    Call<RaceResponse> loadRaces();

}
