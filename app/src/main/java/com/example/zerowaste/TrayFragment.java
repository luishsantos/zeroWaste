package com.example.zerowaste;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.SupportMapFragment;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrayFragment}  method to
 * create an instance of this fragment.
 */
public class TrayFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String MORADA = "morada";
    private static final String MAGIC_BOX = "magic_box";
    private static final String PRECO = "preco";
    private static final String TEL = "tel";
    private static final String TAG = "TRAY" ;

    // TODO: Rename and change types of parameters
    private String morada;
    private String magic_box;
    private String preco;
    private String tel;

    private TextView vMorada;
    private TextView vMagic_box;
    private TextView vPreco;
    private Button pagamento;


    public TrayFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tray, container, false);

        vMagic_box = (TextView) rootView.findViewById(R.id.tray_box);
        vMorada    = (TextView) rootView.findViewById(R.id.tray_address);
        vPreco     = (TextView) rootView.findViewById(R.id.tray_price);
        pagamento  = (Button) rootView.findViewById(R.id.payment_button);

        if (getArguments() != null) {
            magic_box = getArguments().getString(MAGIC_BOX);
            morada    = getArguments().getString(MORADA);
            preco     = getArguments().getString(PRECO);
            tel       = getArguments().getString(TEL);

        }



        vMagic_box.setText("Categoria:" + magic_box);
        vMorada.setText(morada);
        vPreco.setText(preco);

        pagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Fragment TrayFragmentFinal = new TrayFragmentFinal();
                Bundle bundle = new Bundle();
                bundle.putString(MAGIC_BOX, magic_box);
                bundle.putString(PRECO,preco);
                bundle.putString(MORADA,morada);
                bundle.putString(TEL,tel);
                updateDetail();
                TrayFragmentFinal.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.content1_frame,TrayFragmentFinal).
                        addToBackStack(null).commit();


            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }
    public void updateDetail() {
        Intent intent = new Intent(getActivity(), DashBoard.class);
        intent.putExtra(MORADA,morada);
        intent.putExtra(MAGIC_BOX,magic_box);
        intent.putExtra(TEL,tel);
        intent.putExtra(PRECO,preco);
        startActivity(intent);
    }


}