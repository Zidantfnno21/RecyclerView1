package id.ac.ub.papb.recycler1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        String Nim = getIntent().getStringExtra("NIM");
        String Nama = getIntent().getStringExtra("Nama");

        TextView nim =findViewById(R.id.tvNim2);
        TextView nama =findViewById(R.id.tvNama2);

        nama.setText("Nama : " + Nama);
        nim.setText("NIM : " + Nim);

    }
}