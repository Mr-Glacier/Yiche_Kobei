package Analysis;

import Bean.Bean_T_YKouBei;

import java.util.ArrayList;

public class Analysis_KouBei {
    public ArrayList<Bean_T_YKouBei> Method_KouBei(String ModelURL){
        ArrayList<Bean_T_YKouBei> KouBeiList = new ArrayList<>();
        try{
            //https://dianping.yiche.com/zhixinghezibm600/koubei/
            //https://car.yiche.com/zhixinghezibm600/
            String KouBeiURL = ModelURL.replace("car.yiche.com", "dianping.yiche.com")+"koubei/";
            System.out.println("点评链接:  "+KouBeiURL);
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
        return KouBeiList;
    }
}
