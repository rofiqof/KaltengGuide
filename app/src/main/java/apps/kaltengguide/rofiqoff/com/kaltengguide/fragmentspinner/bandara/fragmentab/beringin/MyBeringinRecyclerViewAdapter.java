package apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.bandara.fragmentab.beringin;

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
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.bandara.fragmentab.beringin.data.ItemBeringin;

/**
 * TODO: Replace the implementation with code for your data type.
 */
public class MyBeringinRecyclerViewAdapter extends RecyclerView.Adapter<MyBeringinRecyclerViewAdapter.ViewHolder> {

    private List<ItemBeringin> mValues;
    private Activity activity;

    public MyBeringinRecyclerViewAdapter(Activity activity, List<ItemBeringin> items) {
        this.mValues = items;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.fragment_beringin, parent, false);
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
                        String sAlamat = "Jl. Pendreh, KM. 1, Muara Teweh, Kel. Melayu, Kec.Teweh Tengah, Melayu, Teweh Tengah, Kabupaten Barito Utara, Kalimantan Tengah 73814";
                        String sLat = "-0.941789";
                        String sLang = "114.893516";
                        String sWeb = mValues.get(position).getWebsite();

                        Intent intent = new Intent(activity, DetailBandaraActivity.class);

                        intent.putExtra("nama", sNama);
                        intent.putExtra("deskripsi", sDeskripsi);
                        intent.putExtra("gambar", sGambar);
                        intent.putExtra("alamat", sAlamat);
                        intent.putExtra("lat", sLat);
                        intent.putExtra("lang", sLang);
                        intent.putExtra("website", sWeb);

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

            mTujuan = (TextView) itemView.findViewById(R.id.text_tujuan_beringin);
            mPesawat = (TextView) itemView.findViewById(R.id.text_nama_pesawat_beringin);
            mJam = (TextView) itemView.findViewById(R.id.text_jadwal_beringin);
            mGambarPesawat = (ImageView) itemView.findViewById(R.id.gambar_pesawat_beringin);

            cardview = itemView.findViewById(R.id.cardview_bandara_beringin);
        }

    }
}
