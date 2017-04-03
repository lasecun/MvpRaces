package test.com.mvpraces.ui.presenter;

import java.util.List;

import test.com.mvpraces.MainView;
import test.com.mvpraces.model.Race;
import test.com.mvpraces.ui.interactor.IMainInteractor;
import test.com.mvpraces.ui.interactor.MainInteractor;

/**
 * Created by jmarti on 3/4/17.
 */

public class MainPresenter implements IMainPresenter {

    private MainView view;
    private IMainInteractor interactor;

    public MainPresenter(MainView view) {
        this.view = view;
        interactor = new MainInteractor(this);
    }

    @Override
    public void start() {
        view.showProgressBar();
        interactor.getRacesInfo();
    }

    @Override
    public void racesList(List<Race> raceList) {
        view.showRaceInfo(raceList);
        view.hideProgressBar();
    }
}
