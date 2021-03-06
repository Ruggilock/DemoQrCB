package absortio.demolectorqrbarra;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import absortio.demolectorqrbarra.model.Client;
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
    List<Product> products;
    ArrayList<Client> clients;

    EditText etDni;
    TextView tvCodeBar;
    TextView tvNombre;
    TextView tvEmpresa;
    Button btClient;
    TextView tvNombreCliente;
    TextView tvApellidoCliente;

    Context context;
    ServiceInterface serviceInterface;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        products = new ArrayList<>();
        clients = new ArrayList<>();
        serviceInterface = Service.userService();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dni);
        etDni = this.findViewById(R.id.etdni);
        tvCodeBar = this.findViewById(R.id.codeBar);
        tvNombre = this.findViewById(R.id.nombre);
        tvEmpresa = this.findViewById(R.id.empresa);
        tvEmpresa = this.findViewById(R.id.empresa);
        btClient = this.findViewById(R.id.buttonClient);
        tvNombreCliente = this.findViewById(R.id.nombreCliente);
        tvApellidoCliente = this.findViewById(R.id.apellidoCliente);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String codeBar = "lol";
        if (bundle != null) {
            codeBar = (String) bundle.get("extra");

        }
        tvCodeBar.setText(codeBar);
        serviceInterface.getProduct(codeBar).enqueue(new Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                products = response.body();
            }

            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {
            }
        });
        tvNombre.setText(products.get(0).getName());
        tvEmpresa.setText(products.get(0).getEnterprise());

        btClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                serviceInterface.getClient(etDni.getText().toString()).enqueue(new Callback<ArrayList<Client>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Client>> call, Response<ArrayList<Client>> response) {
                        clients = response.body();
                        tvNombreCliente.setText(clients.get(0).getName());
                        tvApellidoCliente.setText(clients.get(0).getLastName());
                    }
                    @Override
                    public void onFailure(Call<ArrayList<Client>> call, Throwable t) {
                    }
                });
            }

        });

    }

}
