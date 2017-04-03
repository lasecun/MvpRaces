package test.com.mvpraces;

import java.util.List;

import test.com.mvpraces.model.Race;

/**
 * Created by jmarti on 3/4/17.
 */

public interface MainView {

    void showProgressBar();
    void hideProgressBar();
    void showRaceInfo(List<Race> raceList);

}
