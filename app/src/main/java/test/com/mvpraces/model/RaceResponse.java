package test.com.mvpraces.model;

import java.util.List;

/**
 * Created by jmarti on 3/4/17.
 */

public class RaceResponse {

    public List<Race> data;
    public String status;
    public long totalPages;
    public long pastPages;
    public long futurePages;

    public RaceResponse() {
    }

    public List<Race> getData() {
        return data;
    }

    public void setData(List<Race> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public long getPastPages() {
        return pastPages;
    }

    public void setPastPages(long pastPages) {
        this.pastPages = pastPages;
    }

    public long getFuturePages() {
        return futurePages;
    }

    public void setFuturePages(long futurePages) {
        this.futurePages = futurePages;
    }

}
