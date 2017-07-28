package apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.palangkaraya.fragmenttab.penginapan.losmen;

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
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.palangkaraya.fragmenttab.penginapan.losmen.data.ItemLosmen;

/**
 * TODO: Replace the implementation with code for your data type.
 */
public class MyLosmenRecyclerViewAdapter extends RecyclerView.Adapter<MyLosmenRecyclerViewAdapter.ViewHolder> {

    private final List<ItemLosmen> mValues;
    private Activity activity;

    public MyLosmenRecyclerViewAdapter(Activity activity, List<ItemLosmen> items) {
        this.mValues = items;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity)
                .inflate(R.layout.fragment_losmen, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mNamaLosmen.setText(mValues.get(position).getNamaLosmen());
        holder.mAlamat.setText(mValues.get(position).getAlamatLosmen());

        Glide.with(activity)
                .load("http://palangkarayaguide.pe.hu/" + mValues.get(position).getGambarKontentLosmen())
                .crossFade()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.mGambarKonten);

        holder.cardview.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String sNama = mValues.get(position).getNamaLosmen();
                        String sAlamat = mValues.get(position).getAlamatLosmen();
                        String sDeskripsi = mValues.get(position).getDeskripsiLosmen();
//                        String sVideo = mValues.get(position).getVideoLosmen();
                        String sLat = mValues.get(position).getLatLosmen();
                        String sLang = mValues.get(position).getLangLosmen();
                        String sGambar = mValues.get(position).getGambarKontentLosmen();
                        String sWeb= mValues.get(position).getWebsite();

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
        private TextView mNamaLosmen;
        private TextView mAlamat;
        private ImageView mGambarKonten;
        private View cardview;

        public ViewHolder(View view) {
            super(view);

            mNamaLosmen = (TextView) view.findViewById(R.id.text_nama_losmen);
            mAlamat = (TextView) view.findViewById(R.id.text_alamat_losmen);
            mGambarKonten = (ImageView) view.findViewById(R.id.image_content_losmen);
            cardview = view.findViewById(R.id.cardview_losmen);

        }
    }
}
