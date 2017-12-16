package absortio.demolectorqrbarra;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ruggi on 12/15/17.
 */

public class DniActivity extends AppCompatActivity {
    EditText etDni;
    TextView tvCodeBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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
    }
}
