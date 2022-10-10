package id.ac.ub.papb.recycler1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    LayoutInflater inflater;
    Context _context;
    ArrayList<Mahasiswa> data;

    public MahasiswaAdapter(Context _context, ArrayList<Mahasiswa> data, RecyclerViewInterface recyclerViewInterface) {
        this._context = _context;
        this.data = data;
        this.inflater = LayoutInflater.from(this._context);
        this.recyclerViewInterface = recyclerViewInterface;

    }



    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row, parent, false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {
        Mahasiswa mhs = data.get(position);
        Log.d(MainActivity.TAG,"data "+position);
        Log.d(MainActivity.TAG,"nim "+mhs.nim);
        Log.d(MainActivity.TAG,"nama "+mhs.nama);

        holder.tvNim.setText(mhs.nim);
        holder.tvNama.setText(mhs.nama);
    }

    @Override
    public int getItemCount() {
        Log.d(MainActivity.TAG,"Jumlah data "+data.size());
        return data.size();
    }

    class MahasiswaViewHolder extends RecyclerView.ViewHolder {
        TextView tvNim;
        TextView tvNama;

        public MahasiswaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNim = itemView.findViewById(R.id.tvNim);
            tvNama = itemView.findViewById(R.id.tvNama);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}