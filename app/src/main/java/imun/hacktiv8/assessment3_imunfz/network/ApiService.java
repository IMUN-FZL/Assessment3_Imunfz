package imun.hacktiv8.assessment3_imunfz.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static String BASE_URL = "https://651ebf3344a3a8aa4768ed57.mockapi.io/api/mocksample/";
    private static Retrofit retrofit = null;
    public static Api endpoint(){

        retrofit = new Retrofit.Builder()
                .baseUrl( BASE_URL )
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create( Api.class );
    }
}
