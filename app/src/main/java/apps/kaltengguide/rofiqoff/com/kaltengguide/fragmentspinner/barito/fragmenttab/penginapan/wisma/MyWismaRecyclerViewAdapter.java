package apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.barito.fragmenttab.penginapan.wisma;

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
import apps.kaltengguide.rofiqoff.com.kaltengguide.detail.view.DetailHotelActivity;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.barito.fragmenttab.penginapan.wisma.data.ItemWisma;

/**
 * TODO: Replace the implementation with code for your data type.
 */
public class MyWismaRecyclerViewAdapter extends RecyclerView.Adapter<MyWismaRecyclerViewAdapter.ViewHolder> {

    private final List<ItemWisma> mValues;
    private Activity activity;

    public MyWismaRecyclerViewAdapter(Activity activity, List<ItemWisma> items) {
        this.mValues = items;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.fragment_wisma, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.mNamaWisma.setText(mValues.get(position).getNamaWisma());
        holder.mAlamat.setText(mValues.get(position).getAlamatWisma());

        Glide.with(activity)
                .load("http://palangkarayaguide.pe.hu/" + mValues.get(position).getGambarKontentWisma())
                .crossFade()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.mGambarKonten);

        holder.cardview.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String sNama = mValues.get(position).getNamaWisma();
                        String sAlamat = mValues.get(position).getAlamatWisma();
                        String sDeskripsi = mValues.get(position).getDeskripsiWisma();
//                        String sVideo = mValues.get(position).getVideoWisma();
                        String sLat = mValues.get(position).getLatWisma();
                        String sLang = mValues.get(position).getLangWisma();
                        String sGambar = mValues.get(position).getGambarKontentWisma();
                        String sWeb = mValues.get(position).getWebsite();

                        Intent intent = new Intent(activity, DetailHotelActivity.class);

                        intent.putExtra("nama", sNama);
                        intent.putExtra("alamat", sAlamat);
                        intent.putExtra("deskripsi", sDeskripsi);
//                        intent.putExtra("video", sVideo);
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
        private TextView mNamaWisma;
        private TextView mAlamat;
        private ImageView mGambarKonten;
        private View cardview;

        public ViewHolder(View view) {
            super(view);

            mNamaWisma = (TextView) view.findViewById(R.id.text_nama_wisma);
            mAlamat = (TextView) view.findViewById(R.id.text_alamat_wisma);
            mGambarKonten = (ImageView) view.findViewById(R.id.image_content_wisma);
            cardview = view.findViewById(R.id.cardview_wisma);

        }
    }
}
