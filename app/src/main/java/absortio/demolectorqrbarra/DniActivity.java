package absortio.demolectorqrbarra;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import absortio.demolectorqrbarra.model.Product;
import absortio.demolectorqrbarra.utils.Service;
import absortio.demolectorqrbarra.utils.ServiceInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ruggi on 12/15/17.
 */

public class DniActivity extends AppCompatActivity {
    EditText etDni;
    TextView tvCodeBar;
    Context context;
    ServiceInterface serviceInterface;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        List<Product> customs;
        customs=  new ArrayList<>();

        serviceInterface= Service.userService();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dni);
        etDni= this.findViewById(R.id.etdni);
        tvCodeBar = this.findViewById(R.id.codeBar);
        Intent intent= getIntent();
        Bundle bundle = intent.getExtras();
        String codeBar="lol";
        if(bundle!=null)
        {
            codeBar =(String) bundle.get("extra");

        }
        tvCodeBar.setText(codeBar);
        /*serviceInterface.getProduct().enqueue(new Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {

            }

            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {

            }
        });
          */
    }

}
