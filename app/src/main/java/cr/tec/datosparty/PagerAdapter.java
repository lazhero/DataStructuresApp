package cr.tec.datosparty;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class PagerAdapter extends FragmentStatePagerAdapter{
    List<Fragment> Fragments;
    public PagerAdapter(FragmentManager fm,List<Fragment> Fragments){
        super(fm);
        this.Fragments=Fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
       return Fragments.get(position);

    }
    @Override
    public int getCount() {

        return Fragments.size();
    }
}
