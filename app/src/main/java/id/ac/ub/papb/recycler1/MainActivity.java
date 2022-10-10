package id.ac.ub.papb.recycler1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {
    ListView listView;
    public static ArrayList<Mahasiswa> data;
    RecyclerView rv1;
    EditText inputNIM,inputNama;
    Button enter;

    public static String TAG = "RV1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv1 = findViewById(R.id.rv1);
        data = getData();
        MahasiswaAdapter adapter = new MahasiswaAdapter(this, data , this);
        rv1.setAdapter(adapter);
        rv1.setLayoutManager(new LinearLayoutManager(this));


        inputNIM = findViewById(R.id.etNim);
        inputNama = findViewById(R.id.editTextTextPersonName2);
        enter = findViewById(R.id.bt1);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = inputNIM.getText().toString();
                String text1 = inputNama.getText().toString();
                if (text1 == null || text1.length() == 0 || text == null || text.length() == 0) {
                    Toast.makeText(MainActivity.this, "Please fill the entire form", Toast.LENGTH_SHORT).show();

                } else {
                    inputNIM.setText("");
                    inputNama.setText("");
                    addItem(text, text1);
                    rv1.setAdapter(adapter);
                    Toast.makeText(MainActivity.this, "Added", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public static void addItem(String NIM,String Nama){
        Mahasiswa mhsNew = new Mahasiswa();
        mhsNew.nim = NIM;
        mhsNew.nama = Nama;
        data.add(mhsNew);
    }


    public ArrayList getData() {
        ArrayList<Mahasiswa> data = new ArrayList<>();
        List<String> nim = Arrays.asList(getResources().getStringArray(R.array.nim));
        List<String> nama = Arrays.asList(getResources().getStringArray(R.array.nama));
        for (int i = 0; i < nim.size(); i++) {
            Mahasiswa mhs = new Mahasiswa();
            mhs.nim = nim.get(i);
            mhs.nama = nama.get(i);
            Log.d(TAG,"getData "+mhs.nim);
            data.add(mhs);
        }
        return data;
    }


    @Override
    public void onItemClick(int Position) {
        Intent intent = new Intent(MainActivity.this, Activity2.class);

        intent.putExtra("NIM", data.get(Position).nim);
        intent.putExtra("Nama", data.get(Position).nama);

        startActivity(intent);
    }
}