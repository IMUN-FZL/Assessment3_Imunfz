package imun.hacktiv8.assessment3_imunfz.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api  {
    @GET("covid-info")
    Call<List<CovidActivity>>getData();
}
