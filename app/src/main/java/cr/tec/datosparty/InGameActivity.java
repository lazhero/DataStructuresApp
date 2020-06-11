package cr.tec.datosparty;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import cr.tec.datosparty.Fragments.DiceFrag;
import cr.tec.datosparty.Fragments.Stadistic_Frame;

public class InGameActivity extends AppCompatActivity  {
    PagerAdapter pagerAdapter;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);
        List<Fragment> list=new ArrayList<>();
        list.add(new DiceFrag());
        list.add(new Stadistic_Frame());
        viewPager=(ViewPager)findViewById(R.id.Pager);
        pagerAdapter=new PagerAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(pagerAdapter);

    }
}
