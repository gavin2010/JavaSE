import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonAnalyze {
    public static void main(String[] args) {
        String line1 = "张飞\t女\t513023199205061254\t2017/12/20\t15112345678\n";
        String line2 = "男513023199205061254 张 大 飞 15112345678     2017/12/20";
        String line3 = "张 · 文  男 1992/6/23\t15187876543\t5130231999121383456\t女\n";

        PersonInfo personInfo = new PersonInfo();
        personInfo.setLine(line3);
        analyzeLine(personInfo);
        System.out.println(personInfo);
    }

    private static void analyzeLine(PersonInfo personInfo){
        //初始化字符串
        initLine(personInfo);

        //解析名字，由于英文名允许包含有空格，所以优先解析
        analyzeName(personInfo);

        //截取性别
        analyzeGender(personInfo);

        //截取出生日期
        analyzeBirthday(personInfo);

        //截取手机号码
        analyzeMobile(personInfo);

        //证件号码识别
        analyzeCardnum(personInfo);

        //成功与失败校验
        endLine(personInfo);
    }

    /**
     * 成功与失败校验
     * @param personInfo
     */
    private static void endLine(PersonInfo personInfo) {

    }

    //提取证件号码
    private static void analyzeCardnum(PersonInfo personInfo) {
        String theLine = personInfo.getTheLine();
        String pattern_cardnum = " (([\\d]{15})| (([\\d]{18}))) ";
        Matcher matcher = Pattern.compile(pattern_cardnum).matcher(theLine);
        if(matcher.find()){
            String cardnum = matcher.group(1);
            theLine = theLine.replace(cardnum," ");
            personInfo.setTheLine(theLine);

            // TODO 护照，与其它证件号码


            personInfo.setCardNum(cardnum.trim());
        }
    }

    /**
     * 提取手机号码
     * @param personInfo
     */
    private static void analyzeMobile(PersonInfo personInfo) {
        String theLine = personInfo.getTheLine();
        String pattern_mobile = " (1[\\d]{9,11}) ";
        Matcher matcher = Pattern.compile(pattern_mobile).matcher(theLine);
        if(matcher.find()){
            String mobile = matcher.group(1);
            theLine = theLine.replace(mobile," ");
            personInfo.setTheLine(theLine);

            // TODO 手机号码校验


            personInfo.setMobile(mobile.trim());
        }
    }

    /**
     * 截取生日
     * @param personInfo
     */
    private static void analyzeBirthday(PersonInfo personInfo) {
        String theLine = personInfo.getTheLine();
        String pattern_birth = "(([\\d]{2,4}[-/年][\\w]{1,3}[-/月][\\d]{1,4}))";
        Matcher matcher = Pattern.compile(pattern_birth).matcher(theLine);
        if(matcher.find()){
            String birthday = matcher.group(1);
            theLine = theLine.replace(birthday," ");
            personInfo.setTheLine(theLine);

            // TODO 生日校验正确性,并统一生日格式yyyy-mm-dd   personInfo.setBirthday_state();


            personInfo.setBirthday(birthday);
            personInfo.setBirthday_state(PersonConst.SUCCESS);
        }


        if(PersonConst.NOANALYZE == personInfo.getBirthday_state()){
             theLine = personInfo.getTheLine();
             pattern_birth = "((19|20)[\\d]{2}(0[1-9]|1[0-2])([012][0-9]|[3][01]))";
             matcher = Pattern.compile(pattern_birth).matcher(theLine);
            if(matcher.find()){
                String birthday = matcher.group(1);
                theLine = theLine.replace(birthday," ");
                personInfo.setTheLine(theLine);

                // TODO 生日校验正确性,并统一生日格式yyyy-mm-dd   personInfo.setBirthday_state();


                personInfo.setBirthday(birthday);
                personInfo.setBirthday_state(PersonConst.SUCCESS);
            }
        }
    }

    /**
     * 提取性别
     * @param personInfo
     */
    private static void analyzeGender(PersonInfo personInfo) {
        String theLine = personInfo.getTheLine();
        String pattern_gender = "[a-zA-Z0-9 ]([男女])[a-zA-Z0-9 ]";
        Matcher matcher = Pattern.compile(pattern_gender).matcher(theLine);
        if(matcher.find()){
            String gender = matcher.group(1);
            theLine = theLine.replace(gender," ");
            personInfo.setTheLine(theLine);
            if("男".equals(gender)){
                personInfo.setGender(PersonConst.GENDER_MALE);
                personInfo.setGender_state(PersonConst.SUCCESS);
            }else if("女".endsWith(gender)){
                personInfo.setGender(PersonConst.GENDER_FEMALE);
                personInfo.setGender_state(PersonConst.SUCCESS);
            }
        }
    }

    /**
     * 解析姓名
     * @param personInfo
     */
    private static void analyzeName(PersonInfo personInfo) {
        String theLine= personInfo.getTheLine();
        String pattern_name = "[ 0-9]([\\u4e00-\\u9fa5 a-zA-Z·]*)[ 0-9]";
        Matcher matcher = Pattern.compile(pattern_name).matcher(theLine);
        if(matcher.find()){
            String name = "";
            name = matcher.group(1);
            //裁剪匹配成功的字符
            theLine = theLine.replace(name," ");
            personInfo.setTheLine(theLine);
            //解析性别
            if(name.startsWith(" 男 ")){
                name = name.substring(3);
                personInfo.setGender(PersonConst.GENDER_MALE);
                personInfo.setGender_state(PersonConst.SUCCESS);
            }else if(name.endsWith(" 男 ")){
                name = name.substring(0,name.length()-3);
                personInfo.setGender(PersonConst.GENDER_MALE);
                personInfo.setGender_state(PersonConst.SUCCESS);
            }if(name.startsWith(" 女 ")){
                name = name.substring(3);
                personInfo.setGender(PersonConst.GENDER_FEMALE);
                personInfo.setGender_state(PersonConst.SUCCESS);
            }else if(name.endsWith(" 女 ")){
                name = name.substring(0,name.length()-3);
                personInfo.setGender(PersonConst.GENDER_FEMALE);
                personInfo.setGender_state(PersonConst.SUCCESS);
            }

            //全是中文要将中间的空格去掉
            if(name.matches("[\\u4e00-\\u9fa5 ·]*")){
                name = name.replaceAll(" ","");
            }
            personInfo.setName(name);
            personInfo.setName_state(PersonConst.SUCCESS);
        }
    }


    /**
     * 每行字符初始化
     * @return
     */
    private static void initLine(PersonInfo personInfo){
        String line = personInfo.getLine();
        if(null == line || line.trim().length() == 0){
            personInfo.setFail(PersonConst.LINE_NULL);
        }

        //若存在换行符，取第一个换行符之前的内容
        int end = -1;
        if((end = line.indexOf("\n"))>=0){
            line = line.substring(0,end).trim();
        }

        //若单行长度大于500，就取500以前的数据
        if(line.length() > 500){
            line = line.substring(0,500);
        }

        //去除多余空格和tab符号
        List<String> wordList = new ArrayList();
        String[] arrs = line.split(" |\t");
        for(String arr : arrs){
            if(arr.trim().length()>0){
                wordList.add(arr.trim());
            }
        }
        //添加空格便于正则取值
        personInfo.setTheLine(" "+ StringUtils.join(wordList," ")+" ");
    }

}
