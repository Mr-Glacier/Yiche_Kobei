import Analysis.Analysis_Model;
import Analysis.Analysis_Pages;
import Bean.Bean_T_YModel;
import Dao.Method_web_down;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class buchong_Beantian {
    public static void main(String[] args) {
        try {
            //补充本田的数据
            Analysis_Pages ASPage = new Analysis_Pages();
            Analysis_Model ASModel = new Analysis_Model();
            ArrayList<Bean_T_YModel> ModelList = ASModel.Method_Model("https://car.yiche.com/xuanchegongju/?mid=26", "本田");
            Thread.sleep(300);
            for (int i = 0; i < ModelList.size(); i++) {
                String ModelURL = ModelList.get(i).get_C_ModelURL();
                String ModelName = ModelList.get(i).get_C_ModelName();
                String KouBeiURL = ModelURL.replace("car.yiche.com", "dianping.yiche.com") + "koubei/";
                ArrayList<String> PageList = ASPage.Method_Pages(KouBeiURL);
                for (int k = 0; k < PageList.size(); k++) {
                    String DownURL = PageList.get(k);
                    Method_web_down downDate = new Method_web_down();
                    String KouBeiContent = downDate.Method_FindYCWB(DownURL);
//                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("F:/A_易车数据/AAA/" + ModelName.replace(":", "_") + k + "口碑.text", true), 165537);//165537
//                    bufferedOutputStream.write(KouBeiContent.getBytes());
//                    bufferedOutputStream.close();
                    System.out.println("完成一次下载");
                    Thread.sleep(500);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }
}
