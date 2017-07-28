package apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.gunungmas.fragmenttab.wisata.wisatabelanja;

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
import apps.kaltengguide.rofiqoff.com.kaltengguide.detail.view.DetailActivity;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.gunungmas.fragmenttab.wisata.wisatabelanja.data.ItemWisataBelanja;

/**
 * TODO: Replace the implementation with code for your data type.
 */
public class MyWisataBelanjaRecyclerViewAdapter extends RecyclerView.Adapter<MyWisataBelanjaRecyclerViewAdapter.ViewHolder> {

    private List<ItemWisataBelanja> mValues;
    private Activity activity;

    public MyWisataBelanjaRecyclerViewAdapter(Activity activity, List<ItemWisataBelanja> items) {
        this.mValues = items;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.fragment_wisatabelanja, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mTextNama.setText(mValues.get(position).getNamaWisataBelanja());
        holder.mTextAlamat.setText(mValues.get(position).getAlamatWisataBelanja());

        Glide.with(activity)
                .load("http://palangkarayaguide.pe.hu/" + mValues.get(position).getGambarWisataBelanja())
                .crossFade()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.mGambarBelanja);
        holder.mContainer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String sNama = mValues.get(position).getNamaWisataBelanja();
                        String sAlamat = mValues.get(position).getAlamatWisataBelanja();
                        String sDeskripsi = mValues.get(position).getDeskripsiWisataBelanja();
                        String sVideo = mValues.get(position).getVideoWisataBelanja();
                        String sLat = mValues.get(position).getLatWisataBelanja();
                        String sLang = mValues.get(position).getLangWisataBelanja();
                        String sGambar = mValues.get(position).getGambarWisataBelanja();
                        String sWeb = mValues.get(position).getWebsite();

                        Intent intent = new Intent(activity, DetailActivity.class);

                        intent.putExtra("nama", sNama);
                        intent.putExtra("alamat", sAlamat);
                        intent.putExtra("deskripsi", sDeskripsi);
                        intent.putExtra("video", sVideo);
                        intent.putExtra("lat", sLat);
                        intent.putExtra("lang", sLang);
                        intent.putExtra("gambar", sGambar);
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
        private TextView mTextNama;
        private TextView mTextAlamat;
        private ImageView mGambarBelanja;
        private View mContainer;

        public ViewHolder(View view) {
            super(view);

            mTextNama = (TextView) view.findViewById(R.id.text_nama_wisataBelanja_barito);
            mTextAlamat = (TextView) view.findViewById(R.id.text_alamat_wisataBelanja_barito);
            mGambarBelanja = (ImageView) view.findViewById(R.id.image_content_wisatabelanja_barito);
            mContainer = view.findViewById(R.id.cardview_wisataBelanja_barito);
        }

    }
}
