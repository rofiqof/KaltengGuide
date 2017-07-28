package apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.seruyan.fragmenttab.hotel;

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
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.seruyan.fragmenttab.hotel.data.ItemHotel;

/**
 * TODO: Replace the implementation with code for your data type.
 */
public class MyHotelRecyclerViewAdapter extends RecyclerView.Adapter<MyHotelRecyclerViewAdapter.ViewHolder> {

    private List<ItemHotel> mValues;
    private Activity activity;

    public MyHotelRecyclerViewAdapter(Activity activity, List<ItemHotel> items) {
        this.mValues = items;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.fragment_hotelfragment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.mNamaHotel.setText(mValues.get(position).getNamaHotel());
        holder.mAlamat.setText(mValues.get(position).getAlamatHotel());

        Glide.with(activity)
                .load("http://palangkarayaguide.pe.hu/" + mValues.get(position).getGambarKonten())
                .crossFade()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.mGambarKonten);

        holder.cardview.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String sNama = mValues.get(position).getNamaHotel();
                        String sAlamat = mValues.get(position).getAlamatHotel();
                        String sDeskripsi = mValues.get(position).getDeskripsiHotel();
//                        String sVideo = mValues.get(position).getVideoHotel();
                        String sLat = mValues.get(position).getLatHotel();
                        String sLang = mValues.get(position).getLangHotel();
                        String sGambar = mValues.get(position).getGambarKonten();
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

        private TextView mNamaHotel;
        private TextView mAlamat;
        private ImageView mGambarKonten;
        private View cardview;

        public ViewHolder(View view) {
            super(view);

            mNamaHotel = (TextView) view.findViewById(R.id.text_nama_hotel_barito);
            mAlamat = (TextView) view.findViewById(R.id.text_alamat_hotel_barito);
            mGambarKonten = (ImageView) view.findViewById(R.id.image_content_hotel_barito);
            cardview = view.findViewById(R.id.cardview_hotel_barito);

        }
    }
}
