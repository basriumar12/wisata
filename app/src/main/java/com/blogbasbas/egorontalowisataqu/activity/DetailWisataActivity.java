package com.blogbasbas.egorontalowisataqu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogbasbas.egorontalowisataqu.R;

public class DetailWisataActivity extends AppCompatActivity {

    ImageView imgWisata;

    TextView txtnama;

    TextView txtdetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

        imgWisata =(ImageView) findViewById(R.id.imgwisata);
        txtnama = (TextView) findViewById(R.id.txtnama);
        txtdetail = (TextView) findViewById(R.id.txtdetail);

        Intent getData = getIntent();
        txtnama.setText(getData.getStringExtra("nama"));
        txtdetail.setText(getData.getStringExtra("desk"));
        imgWisata.setImageResource(getData.getIntExtra("img",0));
    }
}
