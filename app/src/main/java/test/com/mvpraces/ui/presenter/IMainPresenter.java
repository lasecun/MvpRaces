package test.com.mvpraces.ui.presenter;

import java.util.List;

import test.com.mvpraces.model.Race;

/**
 * Created by jmarti on 3/4/17.
 */

public interface IMainPresenter {
    void start();

    void racesList(List<Race> racesList);
}
