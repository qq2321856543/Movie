package com.bw.movie.activity;

import android.view.View;
import android.widget.Button;

import com.bw.movie.R;
import com.bw.movie.base.BaseAcitvity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.view.SeatTable;

import butterknife.BindView;

public class XuanZuoActivity extends BaseAcitvity {

//    private ImageView mIvWeichatSelect;
//    private ImageView mIvAliSelect;
//
//    private static final int PAY_TYPE_WECHAT = 0;  //微信支付,默认支付方式
//    private static final int PAY_TYPE_ALIBABA = 1;  //支付宝支付
//    private int payType = 0;

    @BindView(R.id.mSearchView)
    SeatTable mSearchView;
    @BindView(R.id.bt_ok)
    Button bt_ok;

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
        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
//        mSearchView.setScreenName("8号厅荧幕");//设置屏幕名称
//        mSearchView.setMaxSelected(3);//设置最多选中
//        mSearchView.setSeatChecker(new SeatTable.SeatChecker() {
//            @Override
//            public boolean isValidSeat(int row, int column) {
//                if(column==2) {
//                    return false;
//                }
//                return true;
//            }
//            @Override
//            public boolean isSold(int row, int column) {
//                if(row==4&&column==6){
//                    return true;
//                }else if(row==6&&column==6){
//                    return true;
//                }
//                return false;
//            }
//            @Override
//            public void checked(int row, int column) {
//                Toast.makeText(XuanZuoActivity.this, "排"+row+"列"+column, Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void unCheck(int row, int column) {
//
//            }
//            @Override
//            public String[] checkedSeatTxt(int row, int column) {
//                return null;
//            }
//        });
//        mSearchView.setData(10,15);

    }
    private void pay() {
//        View dialogView = getLayoutInflater().inflate(R.layout.dialog_pay_type, null);
//        //微信支付的选择
//        mIvWeichatSelect = dialogView.findViewById(R.id.iv_buy_weichat_select);
//        //支付宝的选择
//        mIvAliSelect = dialogView.findViewById(R.id.iv_buy_alipay_select);
//
//        PayBottomDialog dialog = new PayBottomDialog(XuanZuoActivity.this, dialogView, new int[]{R.id.ll_pay_weichat, R.id.ll_pay_ali, R.id.tv_confirm, R.id.tv_cancel});
//        dialog.bottmShow();
//        dialog.setOnBottomItemClickListener(new PayBottomDialog.OnBottomItemClickListener() {
//            @Override
//            public void onBottomItemClick(PayBottomDialog dialog, View view) {
//                switch (view.getId()) {
//                    case R.id.ll_pay_weichat:   //微信支付
//                        showToast("微信支付");
//                        if (PAY_TYPE_WECHAT != payType) {
////                            mIvWeichatSelect.setImageDrawable(getResources().getDrawable(R.mipmap.xuanzhong));
////                            mIvAliSelect.setImageDrawable(getResources().getDrawable(R.mipmap.wei_xuanzhong));
//                            payType = PAY_TYPE_WECHAT;
//                        }
//
//                        break;
//                    case R.id.ll_pay_ali:  //支付宝支付
//                        showToast("支付宝支付");
////                        if (PAY_TYPE_ALIBABA != payType) {
////                            mIvWeichatSelect.setImageDrawable(getResources().getDrawable(R.mipmap.wei_xuanzhong));
////                            mIvAliSelect.setImageDrawable(getResources().getDrawable(R.mipmap.xuanzhong));
////                            payType = PAY_TYPE_ALIBABA;
////                        }
//                        break;
//                    case R.id.tv_confirm:  //确认支付
//                        //TODO 支付
//                        showToast("确认支付");
//                        //重置
//                        payType = PAY_TYPE_WECHAT;
//                        dialog.cancel();
//                        break;
//                    case R.id.tv_cancel:  //取消支付
//                        showToast("取消支付");
//                        //重置
//                        payType = PAY_TYPE_WECHAT;
//                        dialog.cancel();
//                        break;
//                }
//            }
//        });
    }
//    private void showToast(String s){
//        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
//    }
}
