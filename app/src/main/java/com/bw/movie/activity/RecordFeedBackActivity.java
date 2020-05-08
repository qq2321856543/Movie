package com.bw.movie.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseAcitvity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.icoolor.ICoolor_RecordFeedBack;
import com.bw.movie.presenter.Presenter_RecordFeedBack;

import butterknife.BindView;

public class RecordFeedBackActivity extends BaseAcitvity implements ICoolor_RecordFeedBack.IVew {

    @BindView(R.id.iv_shape)
    ImageView iv_shape;
    @BindView(R.id.et)
    EditText et;
    @BindView(R.id.bt_ok)
    Button bt_ok;
    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_RecordFeedBack(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_record_feed_back;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        iv_shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BasePresenter presenter = getPresenter();
                if (presenter != null) {
                    ((ICoolor_RecordFeedBack.IPersenter)presenter).getRecordFeedBack(et.getText().toString());
                }
            }
        });
    }

    @Override
    public void getRecordFeedBackSuccess(LoginBean loginBean) {
        Toast.makeText(this, ""+loginBean.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
