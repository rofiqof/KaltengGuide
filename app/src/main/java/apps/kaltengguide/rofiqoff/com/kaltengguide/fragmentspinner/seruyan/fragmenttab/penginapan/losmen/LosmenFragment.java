package apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.seruyan.fragmenttab.penginapan.losmen;

import android.app.ProgressDialog;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import apps.kaltengguide.rofiqoff.com.kaltengguide.R;
import apps.kaltengguide.rofiqoff.com.kaltengguide.database.Helper;
import apps.kaltengguide.rofiqoff.com.kaltengguide.fragmentspinner.seruyan.fragmenttab.penginapan.losmen.data.ItemLosmen;

/**
 * A fragment representing a list of Items.
 * <p/>
 * interface.
 */
public class LosmenFragment extends Fragment {

    // TODO: Customize parameters
    private int mColumnCount = 1;

    private ArrayList<ItemLosmen> itemLosmens;

    private RecyclerView recyclerView;
    private MyLosmenRecyclerViewAdapter recyclerViewAdapter;

    private AQuery aQuery;

    private Paint paint = new Paint();
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public LosmenFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_losmen_list, container, false);

        // Set the adapter
        itemLosmens = new ArrayList<>();

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_losmen);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);


        setData();
        return view;
    }

    private void setData() {
        String URL = Helper.BASE_URL + "tampil-data-wisata-losmen-seruyan.php";
        Map<String, String> param = new HashMap<>();

        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setInverseBackgroundForced(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Loading . . .");
        progressDialog.show();

        aQuery = new AQuery(getContext());
        try {
            aQuery.progress(progressDialog).ajax(URL, param, String.class, new AjaxCallback<String>() {
                @Override
                public void callback(String url, String object, AjaxStatus status) {

                    if (object != null) {
                        try {
                            JSONObject jsonObject = new JSONObject(object);
                            String result = jsonObject.getString("result");
                            String msg = jsonObject.getString("msg");

                            if (result.equalsIgnoreCase("true")) {
//                                Helper.pesan(getContext(), msg);
                                JSONArray jsonArray = jsonObject.getJSONArray("data");
                                for (int a = 0; a < jsonArray.length(); a++) {
                                    JSONObject object1 = jsonArray.getJSONObject(a);
                                    ItemLosmen losmen = new ItemLosmen();

                                    losmen.setNamaLosmen(object1.getString("Nama"));
                                    losmen.setAlamatLosmen(object1.getString("Alamat"));
                                    losmen.setGambarKontentLosmen(object1.getString("Gambar"));
                                    losmen.setDeskripsiLosmen(object1.getString("Deskripsi"));
//                                    losmen.setVideoLosmen(object1.getString("Video"));
                                    losmen.setLatLosmen(object1.getString("Lat"));
                                    losmen.setLangLosmen(object1.getString("Lang"));
                                    losmen.setKategoriLosmen(object1.getString("Kategori"));
                                    losmen.setWebsite(object1.getString("Website"));

                                    itemLosmens.add(losmen);
                                    recyclerViewAdapter = new MyLosmenRecyclerViewAdapter(getActivity(), itemLosmens);
                                    recyclerView.setAdapter(recyclerViewAdapter);
                                    recyclerViewAdapter.notifyDataSetChanged();
                                }
                            } else {
                                Helper.pesan(getContext(), msg);
                            }
                        } catch (JSONException e) {
//                            Helper.pesan(getContext(), "Data belum ada");
                        }
                    }
                }
            });

        } catch (Exception e) {
            Helper.pesan(getContext(), "Gagal mengembil data");
        }
    }
}
