package com.bw.movie.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseAcitvity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.view.SeatTable;

import butterknife.BindView;

public class XuanZuoActivity extends BaseAcitvity {
    @BindView(R.id.mSearchView)
    SeatTable mSearchView;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_xuan_zuo;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mSearchView.setScreenName("8号厅荧幕");//设置屏幕名称
        mSearchView.setMaxSelected(3);//设置最多选中
        mSearchView.setSeatChecker(new SeatTable.SeatChecker() {
            @Override
            public boolean isValidSeat(int row, int column) {
                if(column==2) {
                    return false;
                }
                return true;
            }
            @Override
            public boolean isSold(int row, int column) {
                if(row==4&&column==6){
                    return true;
                }else if(row==6&&column==6){
                    return true;
                }
                return false;
            }
            @Override
            public void checked(int row, int column) {
                Toast.makeText(XuanZuoActivity.this, "排"+row+"列"+column, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void unCheck(int row, int column) {

            }
            @Override
            public String[] checkedSeatTxt(int row, int column) {
                return null;
            }
        });
        mSearchView.setData(10,15);

    }
}
