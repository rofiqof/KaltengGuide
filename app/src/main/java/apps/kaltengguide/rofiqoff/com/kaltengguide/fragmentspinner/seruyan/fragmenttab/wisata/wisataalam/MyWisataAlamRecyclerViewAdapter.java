package apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.seruyan.fragmenttab.wisata.wisataalam;

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
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.seruyan.fragmenttab.wisata.wisataalam.data.ItemWisataAlam;

/**
 * TODO: Replace the implementation with code for your data type.
 */
public class MyWisataAlamRecyclerViewAdapter extends RecyclerView.Adapter<MyWisataAlamRecyclerViewAdapter.ViewHolder> {
    private List<ItemWisataAlam> mValues;
    private Activity activity;

    public MyWisataAlamRecyclerViewAdapter(Activity activity, List<ItemWisataAlam> items) {
        this.mValues = items;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_wisataalam, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mTextNama.setText(mValues.get(position).getNamaWisataAlam());
        holder.mTextAlamat.setText(mValues.get(position).getAlamatWisataAlam());

        Glide.with(activity)
                .load("http://palangkarayaguide.pe.hu/" + mValues.get(position).getGambarWisataAlam())
                .crossFade()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.mGambarWisata);

        holder.mContainer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String sNama = mValues.get(position).getNamaWisataAlam();
                        String sAlamat = mValues.get(position).getAlamatWisataAlam();
                        String sDeskripsi = mValues.get(position).getDeskripsiWisataAlam();
                        String sVideo = mValues.get(position).getVideoWisataAlam();
                        String sLat = mValues.get(position).getLatWisataAlam();
                        String sLang = mValues.get(position).getLangWisataAlam();
                        String sGambar = mValues.get(position).getGambarWisataAlam();
                        String sWeb= mValues.get(position).getWebsite();

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
        private ImageView mGambarWisata;
        private View mContainer;


        public ViewHolder(View view) {
            super(view);
            mTextNama = (TextView) view.findViewById(R.id.text_nama_wisataAlam_barito);
            mTextAlamat = (TextView) view.findViewById(R.id.text_alamat_wisataAlam_barito);
            mGambarWisata = (ImageView) view.findViewById(R.id.image_content_wisataalam_barito);
            mContainer = view.findViewById(R.id.cardview_wisataAlam_barito);
        }



    }
}
