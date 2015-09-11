package project.hackerton.day;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import me.relex.circleindicator.CircleIndicator;
import project.hackerton.day.DB.TagDBManager;
import project.hackerton.day.mainfragment.FirstFragment;
import project.hackerton.day.mainfragment.FiveFragment;
import project.hackerton.day.mainfragment.FourthFragment;
import project.hackerton.day.mainfragment.SecondFragment;
import project.hackerton.day.mainfragment.SixFragment;
import project.hackerton.day.mainfragment.ThirdFragment;



public class diaryWriteActivity extends FragmentActivity {

    private static final String MSG = "diaryWriteActivity";

    private TagDBManager db = new TagDBManager(this);

    private int pos = 0;

    private ViewPager pager;

    public void setPos(int pos){
        this.pos = pos;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TagDBManager db = new TagDBManager(this);
        db.initmunjang();
        setContentView(R.layout.activity_diarywrite);
        pager = (ViewPager) findViewById(R.id.viewPager);
        MyPagerAdapter ma = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(ma);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 5){
                    pager.getAdapter().notifyDataSetChanged();
                }
                pos = position;

                // TODO: 페이지가 변경되었을 때 처리 -> 툴바 메뉴 변경.
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });





        CircleIndicator defaultIndicator = (CircleIndicator) findViewById(R.id.indicator_default);
        defaultIndicator.setViewPager(pager);

        //pager.setCurrentItem(1);//초기 페이지 설정
    }


    private class MyPagerAdapter extends FragmentPagerAdapter {

        FirstFragment firstF = new FirstFragment();
        SecondFragment secondF = new SecondFragment();
        ThirdFragment thirdF = new ThirdFragment();
        FourthFragment fourthF = new FourthFragment();
        FiveFragment fiveF = new FiveFragment();



        public MyPagerAdapter(FragmentManager fm) {
            super(fm);

        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }


        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;

            switch(position) {
                case 0: fragment = firstF; break;
                case 1: fragment =  secondF; break;
                case 2: fragment =  thirdF; break;
                case 3: fragment =  fourthF; break;
                case 4: fragment =  fiveF; break;
                case 5: return SixFragment.newInstance(position+"");
            }


            return fragment;
        }

        @Override
        public int getCount() {
            return 6;
        }
    }

    public void updateQuery(String str){
        Log.w(pos+"",str);
        if(pos == 0){
            db.updateMunjang0(str);
        }else if(pos == 1){
            db.updateMunjang1(str);
        }else if(pos == 2){
            db.updateMunjang2(str);
        }else if(pos == 3){
            db.updateMunjang3(str);
        }else if(pos == 4){
            db.updateMunjang4(str);

        }
    }

    public void deleteQuery(String str){
        Log.w("asdfffff", pos+"");
        if(pos == 1){
            db.deleteWhere(str);
        }else if(pos == 2){
            db.deleteWho(str);
        }else if(pos == 3){
            db.deleteWhat(str);
        }else if(pos == 4) {
            db.deleteHow(str);
        }
    }

}