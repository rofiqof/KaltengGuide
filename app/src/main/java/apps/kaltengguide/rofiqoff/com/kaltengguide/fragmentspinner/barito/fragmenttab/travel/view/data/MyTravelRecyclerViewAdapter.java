package apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.barito.fragmenttab.travel.view.data;

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
import apps.kaltengguide.rofiqoff.com.kaltengguide.detail.view.DetailTravelActivity;

/**
 * TODO: Replace the implementation with code for your data type.
 */
public class MyTravelRecyclerViewAdapter extends RecyclerView.Adapter<MyTravelRecyclerViewAdapter.ViewHolder> {

    private List<ItemTravel> mValues;
    private Activity activity;

    public MyTravelRecyclerViewAdapter(Activity activity, List<ItemTravel> items) {
        this.mValues = items;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.fragment_travel, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.mNamaTravel.setText(mValues.get(position).getNamaTravel());
        holder.mDariTravel.setText(mValues.get(position).getDariTravel());
        holder.mTujuanTravel.setText(mValues.get(position).getTujuanTravel());

        Glide.with(activity)
                .load("http://palangkarayaguide.pe.hu/" + mValues.get(position).getGambarTravel())
                .crossFade()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.mGambarTravel);

        holder.cardview.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String sNama = mValues.get(position).getNamaTravel();
                        String sDeskripsi = mValues.get(position).getDeskripsiTravel();
                        String sGambar = mValues.get(position).getGambarTravel();
                        String sAlamat = mValues.get(position).getAlamatTravel();
                        String sLat = mValues.get(position).getLat();
                        String sLang = mValues.get(position).getLang();
                        String sWeb = mValues.get(position).getWebsite();

                        Intent intent = new Intent(activity, DetailTravelActivity.class);

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
        private TextView mTujuanTravel;
        private TextView mDariTravel;
        private TextView mNamaTravel;
        private ImageView mGambarTravel;
        private View cardview;

        public ViewHolder(View view) {
            super(view);

            mTujuanTravel = (TextView) view.findViewById(R.id.text_tujuan_travel);
            mDariTravel = (TextView) view.findViewById(R.id.text_dari_travel);
            mNamaTravel = (TextView) view.findViewById(R.id.text_nama_travel);
            mGambarTravel = (ImageView) view.findViewById(R.id.gambar_travel);
            cardview = view.findViewById(R.id.cardview_travel);

        }
    }
}
