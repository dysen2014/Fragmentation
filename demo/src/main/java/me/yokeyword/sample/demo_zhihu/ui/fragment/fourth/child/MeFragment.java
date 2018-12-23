package me.yokeyword.sample.demo_zhihu.ui.fragment.fourth.child;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.sample.R;
import me.yokeyword.sample.demo_zhihu.ui.fragment.fourth.ZhihuFourthFragment;

/**
 * Created by YoKeyword on 16/6/6.
 */
public class MeFragment extends SupportFragment implements View.OnClickListener {
    private TextView mTvBtnSettings, mTvBtnAbouts;

    public static MeFragment newInstance() {

        Bundle args = new Bundle();

        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zhihu_fragment_fourth_me, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mTvBtnSettings = (TextView) view.findViewById(R.id.tv_btn_settings);
        mTvBtnAbouts = (TextView) view.findViewById(R.id.tv_btn_about);
        mTvBtnSettings.setOnClickListener(this);
        mTvBtnAbouts.setOnClickListener(this);
    }

    @Override
    public boolean onBackPressedSupport() {
        // 这里实际项目中推荐使用 EventBus接耦
        ((ZhihuFourthFragment)getParentFragment()).onBackToFirstFragment();
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_btn_settings:
                start(SettingsFragment.newInstance());
                break;
            case R.id.tv_btn_about:
                start(AboutsFragment.newInstance());
                break;
        }
    }
}
