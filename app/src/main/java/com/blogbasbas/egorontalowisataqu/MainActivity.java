package com.blogbasbas.egorontalowisataqu;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.blogbasbas.egorontalowisataqu._adapter.RecyclerViewAdapter;
import com.blogbasbas.egorontalowisataqu._sliders.FragmentSlider;
import com.blogbasbas.egorontalowisataqu._sliders.SliderIndicator;
import com.blogbasbas.egorontalowisataqu._sliders.SliderPagerAdapter;
import com.blogbasbas.egorontalowisataqu._sliders.SliderView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private SliderView sliderView;
    private LinearLayout mLinearLayout;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sliderView = (SliderView) findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) findViewById(R.id.pagesContainer);
        setupSlider();

        recyclerView= (RecyclerView) findViewById(R.id.listwisata);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        //menset setukuran
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }

    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("https://www.imageupload.co.uk/images/2017/09/28/boliyohutuo.jpg"));
        fragments.add(FragmentSlider.newInstance("https://www.imageupload.co.uk/images/2017/09/28/bugisa.jpg"));
        fragments.add(FragmentSlider.newInstance("https://www.imageupload.co.uk/images/2017/09/28/airterjun_taludaa.jpg"));
        fragments.add(FragmentSlider.newInstance("https://www.imageupload.co.uk/images/2017/09/28/botutonuo.jpg"));
        fragments.add(FragmentSlider.newInstance("https://www.imageupload.co.uk/images/2017/09/28/pulau_cinta.jpg"));
        fragments.add(FragmentSlider.newInstance("https://www.imageupload.co.uk/images/2017/09/28/otanaha.jpg"));
        fragments.add(FragmentSlider.newInstance("https://www.imageupload.co.uk/images/2017/09/28/olele.jpg"));
        fragments.add(FragmentSlider.newInstance("https://www.imageupload.co.uk/images/2017/09/28/pulau_saronde.jpg"));



        mAdapter = new SliderPagerAdapter(getSupportFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(this, mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(" Exit Konfirm");
        builder.setMessage("Apakah  Ingin Keluar ?");
        builder.setIcon(R.mipmap.ic_map);
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(0);
                moveTaskToBack(true);
            }
        });

        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.show();
    }
}
