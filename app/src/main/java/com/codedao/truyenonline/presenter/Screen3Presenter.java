package com.codedao.truyenonline.presenter;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.codedao.truyenonline.adapter.TruyenAdapter;
import com.codedao.truyenonline.model.Chuong;
import com.codedao.truyenonline.model.TheLoai;
import com.codedao.truyenonline.model.Truyen;
import com.codedao.truyenonline.model.database.TruyenDatabaseHepler;
import com.codedao.truyenonline.view.ReaderActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DUNG-PTIT on 19/08/2017.
 */

public class Screen3Presenter implements TruyenAdapter.IOnItemTruyenListener {
    private TruyenAdapter mTruyenAdapter;
    private List<TheLoai> mTheLoais;
    private List<Truyen> mTruyens;
    private List<Chuong> mChuongs;
    private Context mContext;
    private TruyenDatabaseHepler mTruyenDatabaseHepler;

    List<TheLoai> theLoais = new ArrayList<>();
    List<Chuong> chuongs = new ArrayList<>();
    List<Truyen> truyens = new ArrayList<>();

    public Screen3Presenter(Context context) {
        this.mContext = context;
        init();
    }

    public TruyenAdapter getmTruyenAdapter() {
        return mTruyenAdapter;
    }

    public void init() {
        mTruyenDatabaseHepler = new TruyenDatabaseHepler(mContext);
        //initDatabase();
        mTruyens = new ArrayList<>();
//        Truyen truyen;
//        for (int i = 1; i < 100; i++) {
//            truyen = new Truyen();
//            truyen.setmIdTruyen(i);
//            truyen.setmTenTruyen("7 Chiến lược thịnh vượng");
//            truyen.setmTacGia("Jim Rohn");
//            truyen.setmSoLike(4500 + i);
//            mTruyens.add(truyen);
//        }

        mTruyens = mTruyenDatabaseHepler.getAllTruyen();
        mTruyenAdapter = new TruyenAdapter(mTruyens, mContext, this);

    }

    @Override
    public void onItemClick() {
        Toast.makeText(mContext, "Doc Truyen", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(mContext, ReaderActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    public void onOfflineClick() {
        Toast.makeText(mContext, "Da add offline", Toast.LENGTH_SHORT).show();
    }

    //TODO Them  chuong
    public List<TheLoai> themTheLoai() {
        TheLoai theLoai = new TheLoai(1, "Truyện cười");
        theLoais.add(theLoai);
        theLoai = new TheLoai(2, "Truyện ngắn");
        theLoais.add(theLoai);
        theLoai = new TheLoai(3, "Truyện kiếm hiệp");
        theLoais.add(theLoai);
        theLoai = new TheLoai(4, "Truyện ngụ ngôn");
        theLoais.add(theLoai);
        theLoai = new TheLoai(5, "Truyện người lớn");
        theLoais.add(theLoai);

        return  theLoais;
    }

    public List<Truyen> themTruyen(int idTheLoai) {
        Truyen truyen;
        for (int i = 1; i <= 10; i++) {
            truyen = new Truyen();
            truyen.setmIdTruyen(""+i);
            truyen.setmTenTruyen("7 Chiến lược thịnh vượng cua Dung");
            truyen.setmTacGia("Jim Rohn");
            truyen.setmIdTheLoai(""+idTheLoai);
            truyen.setmNgay("20/08/2017");
            truyen.setmNoiDung("Hôm nay thật là vui");
            truyen.setmSoChuong(""+1);
            truyen.setmSoLike(""+4500 + i+ idTheLoai);
            truyen.setmLuotXem(""+10000);
            truyen.setmAvatar(""+1);
            truyen.setmDanhGiau(""+1);
            truyens.add(truyen);
        }

        return truyens;

    }

    public List<Chuong> themChuong(int soChuong, int idTruyen) {
        Chuong chuong;
        for (int i = 1; i <= soChuong; i++) {
            chuong = new Chuong();
            chuong.setmIdChuong(i);
            chuong.setmIdTruyen(idTruyen);
            chuong.setmNoiDung("Tới tuổi trưởng thành, chị em nhà muỗi nọ chia tay nhau mỗi kẻ một phương trời kiếm ăn. Sau một thời gian, chúng gặp lại nhau, tay bắt mặt mừng rồi hàn huyên chuyện làm ăn.\n" +
                    "\n" +
                    "- Muỗi em hỏi muỗi chị: Dạo này sao trông chị gầy xác xơ thế?\n" +
                    "\n" +
                    "- Muỗi chị lắc đầu: Chán lắm em ạ! Vì lâu nay cặp vợ chồng nơi chị cư ngụ không… cãi nhau nữa.\n" +
                    "- Việc họ cãi nhau thì liên quan gì đến chị? – Muỗi em ngạc nhiên.\n" +
                    "\n" +
                    "- Muỗi chị giải thích: Sao em chậm hiểu thế! Họ mà cãi nhau, anh chồng bỏ ra ghế xa lông… ngủ thì chị mới có cơ hội “làm ăn” chứ!\n" +
                    "\n" +
                    "- Muỗi em thương hại: Hay là chị ra công viên với em đi! Ở đó có nhiều cặp tình nhân ôm nhau chẳng biết trời đâu đất đâu nữa. Lúc đó chúng mình tha hồ “làm ăn”…\n" +
                    "\n" +
                    "- Muỗi chị rụt vòi: Không dám đâu! Nghe nói ở đó lắm kẻ nghiện ngập lắm. Lỡ mình chích nhầm chúng rồi đâm nghiện lây, cứ phải tìm dân nghiện mà chích thì khổ cả một đời.");
            chuongs.add(chuong);
        }
        return chuongs;
    }

    public void initDatabase(){


        themTheLoai();

        for (int i = 0; i < theLoais.size(); i++) {
            themTruyen(theLoais.get(i).getmIdTheLoai());
        }

        for (int i = 0; i < truyens.size(); i++){
            themChuong(Integer.parseInt(truyens.get(i).getmSoChuong()),
                    Integer.parseInt(truyens.get(i).getmIdTruyen()));
        }

        //--------------------------------------
        for (int i = 0; i< theLoais.size() ; i++) {
            mTruyenDatabaseHepler.addTheLoai(theLoais.get(i));
        }

        for (int i = 0; i< truyens.size(); i++){
            mTruyenDatabaseHepler.addTruyen(truyens.get(i));
        }

        for (int i = 0; i < chuongs.size(); i++) {
            mTruyenDatabaseHepler.addChuong(chuongs.get(i));
        }

    }
}
