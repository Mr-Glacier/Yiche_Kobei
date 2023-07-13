import Bean.Bean_T_YBrand;
import Bean.Bean_T_YModel;
import Dao.Method_web_down;
import Analysis.*;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class DownJSON {
    public static void main(String[] args) {
        try {
            Analysis_Brand ASBrand = new Analysis_Brand();
            Analysis_Model ASModel = new Analysis_Model();
            Analysis_Pages ASPage = new Analysis_Pages();
            //Analysis_KouBei ASKB = new Analysis_KouBei();


            ArrayList<Bean_T_YBrand> Brandlist = ASBrand.Method_AS_Brand();
            int modelnumber = 0;
            for (int i = 0; i < Brandlist.size(); i++) {
//                System.out.println(Brandlist.get(i).get_C_BrandURL());
//                System.out.println(Brandlist.size());    //622检查无误
                String BrandURL = Brandlist.get(i).get_C_BrandURL();
                String BrandName = Brandlist.get(i).get_C_BrandName();
                ArrayList<Bean_T_YModel> ModelList = ASModel.Method_Model(BrandURL, BrandName);
                Thread.sleep(300);
                //System.out.println(ModelList.size());
                for (int j = 0; j < ModelList.size(); j++) {
                    //System.out.println(ModelList.get(j).get_C_ModelURL());
                    String ModelURL = ModelList.get(j).get_C_ModelURL();
                    String ModelName = ModelList.get(j).get_C_ModelName();

                    String KouBeiURL = ModelURL.replace("car.yiche.com", "dianping.yiche.com") + "koubei/";
//                    //初步访问口碑网页,进行检查是否具有分页
//                    Document documentpageKB = Jsoup.parse(new URL(KouBeiURL).openStream(),"UTF-8",KouBeiURL);
//                    Elements pageItems1 = documentpageKB.select(".link-list.pg-item");
//                    Elements pageItems2 = pageItems1.select("");
                    ArrayList<String> PageList = ASPage.Method_Pages(KouBeiURL);
                    for (int k = 0; k < PageList.size(); k++) {
                        String DownURL = PageList.get(k);
                        Method_web_down downDate = new Method_web_down();
                        String KouBeiContent = downDate.Method_FindYCWB(DownURL);
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("F:/A_易车数据/口碑JSON/" + ModelName + k + "口碑.text", true), 165537);//165537
                        bufferedOutputStream.write(KouBeiContent.getBytes());
                        bufferedOutputStream.close();
                        System.out.println("完成一次下载");
                        Thread.sleep(500);
                    }
                    System.out.println("进入下一个车型");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
