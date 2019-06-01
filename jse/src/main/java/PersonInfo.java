/**
 * 个人基本信息
 */
public class PersonInfo {
    private String name="";   //姓名
    private String gender="";  //性别 0女，1男
    private String cardType="";//证件类型：1身份证,2护照,3其它
    private String cardNum=""; //证件号
    private String birthday=""; //生日
    private String mobile=""; //手机号

    //字段正确解析状态:  0未解析，1成功解析，2解析失败
    private int name_state;   //姓名是否解析成功
    private int gender_state;  //性别是否解析成功
    private int cardType_state;//证件类型：1身份证,2护照,3其它  是否解析成功
    private int cardNum_state; //证件号是否解析成功
    private int birthday_state; //生日是否解析成功
    private int mobile_state; //手机号是否解析成功

    //整行解析状态
    private boolean success; //整行成功解析标志
    private String errmsg; //失败原因
    private String line; //解析之前的行,用于解析错误时返回给前端
    private String theLine; //正在被解析的行,该行随着解析，内容会发生变化

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getName_state() {
        return name_state;
    }

    public void setName_state(int name_state) {
        this.name_state = name_state;
    }

    public int getGender_state() {
        return gender_state;
    }

    public void setGender_state(int gender_state) {
        this.gender_state = gender_state;
    }

    public int getCardType_state() {
        return cardType_state;
    }

    public void setCardType_state(int cardType_state) {
        this.cardType_state = cardType_state;
    }

    public int getCardNum_state() {
        return cardNum_state;
    }

    public void setCardNum_state(int cardNum_state) {
        this.cardNum_state = cardNum_state;
    }

    public int getBirthday_state() {
        return birthday_state;
    }

    public void setBirthday_state(int birthday_state) {
        this.birthday_state = birthday_state;
    }

    public int getMobile_state() {
        return mobile_state;
    }

    public void setMobile_state(int mobile_state) {
        this.mobile_state = mobile_state;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getTheLine() {
        return theLine;
    }

    public void setTheLine(String theLine) {
        this.theLine = theLine;
    }

    public void setFail(String errmsg){
        this.success = false;
        this.errmsg = errmsg;
    }
    @Override
    public String toString() {
        return "PersonInfo{" +
                "name='" + name + '\'' +
                ", gender='" + ("1".equals(gender)?"男":("0".equals(gender)?"女":"")) + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardNum='" + cardNum + '\'' +
                ", birthday='" + birthday + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
