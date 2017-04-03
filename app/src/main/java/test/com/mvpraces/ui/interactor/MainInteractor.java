package test.com.mvpraces.ui.interactor;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.com.mvpraces.model.Race;
import test.com.mvpraces.model.RaceResponse;
import test.com.mvpraces.network.ApiClient;
import test.com.mvpraces.network.RestInterface;
import test.com.mvpraces.ui.presenter.IMainPresenter;

/**
 * Created by jmarti on 3/4/17.
 */

public class MainInteractor implements IMainInteractor{

    IMainPresenter presenter;

    public MainInteractor(IMainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getRacesInfo() {
        RestInterface service = ApiClient.getSportmaniacsClient();

        Call<RaceResponse> raceResponseCall = service.loadRaces();

        raceResponseCall.enqueue(new Callback<RaceResponse>() {
            @Override
            public void onResponse(Call<RaceResponse> call, Response<RaceResponse> response) {
                List<Race> data = response.body().data;
                presenter.racesList(data);

            }

            @Override
            public void onFailure(Call<RaceResponse> call, Throwable t) {

            }
        });
    }
}
