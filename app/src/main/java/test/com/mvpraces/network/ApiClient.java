package test.com.mvpraces.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jmarti on 3/4/17.
 */

public class ApiClient {

    private static RestInterface restInterface;

    // TEST LOCAL
    //private static String baseUrl = "http://panel-app.local.sportmaniacs.com";

    // PRODUCCIÓN
    private static String baseUrl = "https://api-aws.sportmaniacs.com";

    //PRE-PRODUCCIÓN
//    private static String baseUrl = "https://api-tests.sportmaniacs.com";

    public static RestInterface getSportmaniacsClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(new AddHeaderInterceptor()).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(RestInterface.class);
    }

}


class AddHeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request.Builder builder = chain.request().newBuilder();
        builder.addHeader("x-client", "android-native");

        return chain.proceed(builder.build());
    }
}
