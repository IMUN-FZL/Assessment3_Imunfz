package imun.hacktiv8.assessment3_imunfz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import imun.hacktiv8.assessment3_imunfz.network.ApiService;
import imun.hacktiv8.assessment3_imunfz.network.CovidActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView=findViewById(R.id.textViewResult);

        getDataFromApi();


    }

    private void getDataFromApi() {

        ApiService.endpoint().getData()
                        .enqueue(new Callback<List<CovidActivity>>() {
                            @Override
                            public void onResponse(Call<List<CovidActivity>> call, Response<List<CovidActivity>> response) {
                                if (response.isSuccessful()) {
                                    List<CovidActivity> results = response.body();
                                    showresult(results);

                                }
                            }
                            @Override
                            public void onFailure(Call<List<CovidActivity>> call, Throwable t) {
                                Log.d( TAG, t.toString());

                            }
                        });



    }
    private void showresult (List<CovidActivity> covidActivities){
        CovidActivity result = covidActivities.get(0);
        float textSize = 20;
        txtView.setTextSize(textSize);
        txtView.setText(
                "Total Casses In The World : " +result.getCasses() + "\n"+
                        "\nTotal Recovered In The World  : " +result.getRecovered() +"\n"+
                        "\nTotal Deaths In The World  : " +result.getDeaths()
        );
    }
}