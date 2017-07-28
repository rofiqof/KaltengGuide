package apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.kotawaringinbarat.fragmenttab.wisata.wisatabudaya;

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
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.kotawaringinbarat.fragmenttab.wisata.wisatabudaya.data.ItemWisataBudaya;

/**
 * TODO: Replace the implementation with code for your data type.
 */
public class MyWisataBudayaRecyclerViewAdapter extends RecyclerView.Adapter<MyWisataBudayaRecyclerViewAdapter.ViewHolder> {

    private List<ItemWisataBudaya> mValues;
    private Activity activity;

    public MyWisataBudayaRecyclerViewAdapter(Activity activity, List<ItemWisataBudaya> items) {
        this.mValues = items;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.fragment_wisatabudaya, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mTextNama.setText(mValues.get(position).getNamaWisataBudaya());
        holder.mTextAlamat.setText(mValues.get(position).getAlamatWisataBudaya());

        Glide.with(activity)
                .load("http://palangkarayaguide.pe.hu/" + mValues.get(position).getGambarWisataBudaya())
                .crossFade()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.mGambarBudaya);

        holder.mContainer.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String sNama = mValues.get(position).getNamaWisataBudaya();
                        String sAlamat = mValues.get(position).getAlamatWisataBudaya();
                        String sDeskripsi = mValues.get(position).getDeskripsiWisataBudaya();
                        String sVideo = mValues.get(position).getVideoWisataBudaya();
                        String sLat = mValues.get(position).getLatWisataBudaya();
                        String sLang = mValues.get(position).getLangWisataBudaya();
                        String sGambar = mValues.get(position).getGambarWisataBudaya();
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
        private ImageView mGambarBudaya;
        private View mContainer;

        public ViewHolder(View view) {
            super(view);

            mTextNama = (TextView) view.findViewById(R.id.text_nama_wisataBudaya_barito);
            mTextAlamat = (TextView) view.findViewById(R.id.text_alamat_wisataBudaya_barito);
            mGambarBudaya = (ImageView) view.findViewById(R.id.image_content_wisatabudaya_barito);
            mContainer = view.findViewById(R.id.cardview_wisataBudaya_barito);
        }


    }
}
