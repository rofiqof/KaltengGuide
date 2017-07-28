package apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.bandara.fragmentab.asan;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import apps.kaltengguide.rofiqoff.com.kaltengguide.R;
import apps.kaltengguide.rofiqoff.com.kaltengguide.detail.view.DetailBandaraActivity;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.bandara.fragmentab.asan.data.ItemAsan;

/**
 * TODO: Replace the implementation with code for your data type.
 */
public class MyAsanRecyclerViewAdapter extends RecyclerView.Adapter<MyAsanRecyclerViewAdapter.ViewHolder> {

    private List<ItemAsan> mValues;
    private Activity activity;

    public MyAsanRecyclerViewAdapter(Activity activity, List<ItemAsan> items) {
        this.mValues = items;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.fragment_asan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mJam.setText(mValues.get(position).getJam());
        holder.mPesawat.setText(mValues.get(position).getPesawat());
        holder.mTujuan.setText(mValues.get(position).getTujuan());

        Glide.with(activity)
                .load("http://palangkarayaguide.pe.hu/" + mValues.get(position).getGambarPesawat())
                .crossFade()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.mGambarPesawat);

        holder.cardview.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String sNama = mValues.get(position).getPesawat();
                        String sDeskripsi = mValues.get(position).getDeskripsiPesawat();
                        String sGambar = mValues.get(position).getGambarPesawat();
                        String sAlamat = "Jl. Muchran Ali, Baamang Hulu, Baamang, Kabupaten Kotawaringin Timur, Kalimantan Tengah 74313";
                        String sLat = "-2.502458";
                        String sLang = "112.976737";
                        String sRute = "bla bla bla";
                        String sWebsite = mValues.get(position).getWebsite();

                        Intent intent = new Intent(activity, DetailBandaraActivity.class);

                        intent.putExtra("nama", sNama);
                        intent.putExtra("deskripsi", sDeskripsi);
                        intent.putExtra("gambar", sGambar);
                        intent.putExtra("alamat", sAlamat);
                        intent.putExtra("lat", sLat);
                        intent.putExtra("lang", sLang);
                        intent.putExtra("website", sWebsite);

                        activity.startActivity(intent);
                    }
                }
        );
    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTujuan;
        private TextView mPesawat;
        private TextView mJam;
        private ImageView mGambarPesawat;
        private View cardview;

        public ViewHolder(View view) {
            super(view);

            mTujuan = (TextView) itemView.findViewById(R.id.text_tujuan_asan);
            mPesawat = (TextView) itemView.findViewById(R.id.text_nama_pesawat_asan);
            mJam = (TextView) itemView.findViewById(R.id.text_jadwal_asan);
            mGambarPesawat = (ImageView) itemView.findViewById(R.id.gambar_pesawat_asan);

            cardview = itemView.findViewById(R.id.cardview_bandara_asan);
        }

    }
}
