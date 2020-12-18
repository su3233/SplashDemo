package com.aline.splashdemo.entity;

import android.os.Parcelable;

import java.util.List;

/**
 * @author SuTs
 * @create 2020/11/20 9:41
 * @Describe
 */
class TestBean {

    /**
     * Data : [{"autoid":"108","ReplyTime":"2020/11/16 10:47:56","ReplyTxt":"ggjh","ReplyEmployeeID":"7f1d5e4a-3586-4415-973e-dea4b232b1ef","ReplyEmployeeName":"数字测试01","ReplyFile":"b05898a582cf61d2464b84b2da2e9195,4fdfe212fd63fea41daf1e5e231384ef,cf2aa10143ad605e94a973646507e6f1","ReplyFile_filename":"Screenshot_2019-12-27-17-51-47-939_com.pkpm.huaxi.png,Screenshot_2019-12-27-17-50-50-988_com.pkpm.huaxi.png,1605494871127404.png"},{"autoid":"107","ReplyTime":"2020/11/16 10:35:22","ReplyTxt":"fghvvh","ReplyEmployeeID":"7f1d5e4a-3586-4415-973e-dea4b232b1ef","ReplyEmployeeName":"数字测试01","ReplyFile":"982f1f211c697de1b6687a072d2547c6,72a7d3a5c36ce0259242d117facdda46,6df0e5c4c2936f3b808d04e180ce6c24,562acadd976c60999142228987083e9f","ReplyFile_filename":"1605494106539974.JPEG,1605494107328488.JPEG,1605494107786326.JPEG,1605494108194808.JPEG"},{"autoid":"98","ReplyTime":"2020/11/16 10:13:26","ReplyTxt":"问题还存在","ReplyEmployeeID":"e35330cb-1468-4cb2-ad32-efccc5755e2f","ReplyEmployeeName":"超级管理员","ReplyFile":"0189daa0cb4399fb535ee7d38f9a877d,da96ac1ef191d8270274eb64c0ee41af","ReplyFile_filename":"defaultPrj_pic.png,pkpm.png"},{"autoid":"78","ReplyTime":"2020/11/13 16:33:43","ReplyTxt":"问题还存在","ReplyEmployeeID":"e35330cb-1468-4cb2-ad32-efccc5755e2f","ReplyEmployeeName":"超级管理员","ReplyFile":"0189daa0cb4399fb535ee7d38f9a877d,da96ac1ef191d8270274eb64c0ee41af","ReplyFile_filename":"defaultPrj_pic.png,pkpm.png"},{"autoid":"76","ReplyTime":"2020/11/13 10:55:24","ReplyTxt":"3333","ReplyEmployeeID":"e35330cb-1468-4cb2-ad32-efccc5755e2f","ReplyEmployeeName":"超级管理员","ReplyFile":"0caed38daef96c5fbd70f7228dce81dc","ReplyFile_filename":"feedbackImage.jpg"},{"autoid":"75","ReplyTime":"2020/11/13 10:33:07","ReplyTxt":"2222","ReplyEmployeeID":"e35330cb-1468-4cb2-ad32-efccc5755e2f","ReplyEmployeeName":"超级管理员","ReplyFile":"157533e31fe4920b89da06cc7a44df3d","ReplyFile_filename":"feedbackImage.jpg"},{"autoid":"73","ReplyTime":"2020/11/13 10:25:02","ReplyTxt":"111111","ReplyEmployeeID":"e35330cb-1468-4cb2-ad32-efccc5755e2f","ReplyEmployeeName":"超级管理员","ReplyFile":"dd831b2c6b3c107b3e563746709005da,d82dfa0a950ff7872c20da4225d019fc","ReplyFile_filename":"feedbackImage.jpg,feedbackImage.jpg"},{"autoid":"72","ReplyTime":"2020/11/13 10:12:43","ReplyTxt":"00000000","ReplyEmployeeID":"e35330cb-1468-4cb2-ad32-efccc5755e2f","ReplyEmployeeName":"超级管理员","ReplyFile":"dd831b2c6b3c107b3e563746709005da","ReplyFile_filename":"feedbackImage.jpg"},{"autoid":"71","ReplyTime":"2020/11/13 10:08:34","ReplyTxt":"999999","ReplyEmployeeID":"e35330cb-1468-4cb2-ad32-efccc5755e2f","ReplyEmployeeName":"超级管理员","ReplyFile":"dd831b2c6b3c107b3e563746709005da","ReplyFile_filename":"feedbackImage.jpg"},{"autoid":"70","ReplyTime":"2020/11/13 10:03:38","ReplyTxt":"88888","ReplyEmployeeID":"e35330cb-1468-4cb2-ad32-efccc5755e2f","ReplyEmployeeName":"超级管理员","ReplyFile":"dd831b2c6b3c107b3e563746709005da,d82dfa0a950ff7872c20da4225d019fc","ReplyFile_filename":"feedbackImage.jpg,feedbackImage.jpg"},{"autoid":"68","ReplyTime":"2020/11/13 9:39:47","ReplyTxt":"7777777","ReplyEmployeeID":"e35330cb-1468-4cb2-ad32-efccc5755e2f","ReplyEmployeeName":"超级管理员","ReplyFile":"bb79800522a330696db095f30faff564","ReplyFile_filename":"feedbackImage.jpg"},{"autoid":"67","ReplyTime":"2020/11/13 9:05:53","ReplyTxt":"66666","ReplyEmployeeID":"e35330cb-1468-4cb2-ad32-efccc5755e2f","ReplyEmployeeName":"超级管理员","ReplyFile":"4c26362a73f576d82c0c9c5af2c5fdab,e6ff4f34bdafb42f5ea350ddde75096f","ReplyFile_filename":"0_image.jpg,1_image.jpg"},{"autoid":"66","ReplyTime":"2020/11/13 9:02:52","ReplyTxt":"4444","ReplyEmployeeID":"e35330cb-1468-4cb2-ad32-efccc5755e2f","ReplyEmployeeName":"超级管理员","ReplyFile":"350353a407e113dca92072710056ab5d","ReplyFile_filename":"0_image.jpg"},{"autoid":"65","ReplyTime":"2020/11/13 9:01:23","ReplyTxt":"3333","ReplyEmployeeID":"e35330cb-1468-4cb2-ad32-efccc5755e2f","ReplyEmployeeName":"超级管理员","ReplyFile":"350353a407e113dca92072710056ab5d","ReplyFile_filename":"0_image.jpg"},{"autoid":"64","ReplyTime":"2020/11/13 9:01:23","ReplyTxt":"3333","ReplyEmployeeID":"e35330cb-1468-4cb2-ad32-efccc5755e2f","ReplyEmployeeName":"超级管理员","ReplyFile":"350353a407e113dca92072710056ab5d","ReplyFile_filename":"0_image.jpg"},{"autoid":"63","ReplyTime":"2020/11/12 11:16:30","ReplyTxt":"2222","ReplyEmployeeID":"e35330cb-1468-4cb2-ad32-efccc5755e2f","ReplyEmployeeName":"超级管理员","ReplyFile":"2bbd2a0aae173e3946b230111a2f9cd7,bf8fe459c13802d1f4d5cdcea4c18bd3","ReplyFile_filename":"0_image.jpg,1_image.jpg"},{"autoid":"62","ReplyTime":"2020/11/12 11:16:30","ReplyTxt":"2222","ReplyEmployeeID":"e35330cb-1468-4cb2-ad32-efccc5755e2f","ReplyEmployeeName":"超级管理员","ReplyFile":"2bbd2a0aae173e3946b230111a2f9cd7,bf8fe459c13802d1f4d5cdcea4c18bd3","ReplyFile_filename":"0_image.jpg,1_image.jpg"},{"autoid":"60","ReplyTime":"2020/11/11 16:48:37","ReplyTxt":"1111","ReplyEmployeeID":"e35330cb-1468-4cb2-ad32-efccc5755e2f","ReplyEmployeeName":"超级管理员","ReplyFile":"","ReplyFile_filename":""},{"autoid":"59","ReplyTime":"2020/11/11 16:48:37","ReplyTxt":"1111","ReplyEmployeeID":"e35330cb-1468-4cb2-ad32-efccc5755e2f","ReplyEmployeeName":"超级管理员","ReplyFile":"","ReplyFile_filename":""},{"autoid":"58","ReplyTime":"2020/11/11 16:11:35","ReplyTxt":"222","ReplyEmployeeID":"e35330cb-1468-4cb2-ad32-efccc5755e2f","ReplyEmployeeName":"超级管理员","ReplyFile":"2bbd2a0aae173e3946b230111a2f9cd7","ReplyFile_filename":"0_image.jpg"},{"autoid":"2","ReplyTime":"2020/10/27 9:45:12","ReplyTxt":"还有问题","ReplyEmployeeID":"e35330cb-1468-4cb2-ad32-efccc5755e2f","ReplyEmployeeName":"超级管理员","ReplyFile":"9c7fccbcc1832b680b400818a51c7d9b","ReplyFile_filename":"uncheck.png"},{"autoid":"1","ReplyTime":"2020/10/27 9:40:30","ReplyTxt":"好了","ReplyEmployeeID":"e35330cb-1468-4cb2-ad32-efccc5755e2f","ReplyEmployeeName":"超级管理员","ReplyFile":"7cbab96eb8b77807b8b25ce667ee7df3","ReplyFile_filename":"banner.png"}]
     * IsSuccess : 1
     * Message : 查询成功!
     * RowCount : 22
     * SqlName : 我的反馈回复明细
     * strSql : select autoid,ReplyTime,ReplyTxt,ReplyEmployeeID,ReplyEmployeeName,ReplyFile,ReplyFile_filename from T_E_App_Help_sub where mainid='1' order by autoid desc
     */

    private String IsSuccess;
    private String Message;
    private int RowCount;
    private String SqlName;
    private String strSql;
    private List<DataBean> Data;

    public String getIsSuccess() {
        return IsSuccess;
    }

    public void setIsSuccess(String IsSuccess) {
        this.IsSuccess = IsSuccess;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public int getRowCount() {
        return RowCount;
    }

    public void setRowCount(int RowCount) {
        this.RowCount = RowCount;
    }

    public String getSqlName() {
        return SqlName;
    }

    public void setSqlName(String SqlName) {
        this.SqlName = SqlName;
    }

    public String getStrSql() {
        return strSql;
    }

    public void setStrSql(String strSql) {
        this.strSql = strSql;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * autoid : 108
         * ReplyTime : 2020/11/16 10:47:56
         * ReplyTxt : ggjh
         * ReplyEmployeeID : 7f1d5e4a-3586-4415-973e-dea4b232b1ef
         * ReplyEmployeeName : 数字测试01
         * ReplyFile : b05898a582cf61d2464b84b2da2e9195,4fdfe212fd63fea41daf1e5e231384ef,cf2aa10143ad605e94a973646507e6f1
         * ReplyFile_filename : Screenshot_2019-12-27-17-51-47-939_com.pkpm.huaxi.png,Screenshot_2019-12-27-17-50-50-988_com.pkpm.huaxi.png,1605494871127404.png
         */

        private String autoid;
        private String ReplyTime;
        private String ReplyTxt;
        private String ReplyEmployeeID;
        private String ReplyEmployeeName;
        private String ReplyFile;
        private String ReplyFile_filename;

        public String getAutoid() {
            return autoid;
        }

        public void setAutoid(String autoid) {
            this.autoid = autoid;
        }

        public String getReplyTime() {
            return ReplyTime;
        }

        public void setReplyTime(String ReplyTime) {
            this.ReplyTime = ReplyTime;
        }

        public String getReplyTxt() {
            return ReplyTxt;
        }

        public void setReplyTxt(String ReplyTxt) {
            this.ReplyTxt = ReplyTxt;
        }

        public String getReplyEmployeeID() {
            return ReplyEmployeeID;
        }

        public void setReplyEmployeeID(String ReplyEmployeeID) {
            this.ReplyEmployeeID = ReplyEmployeeID;
        }

        public String getReplyEmployeeName() {
            return ReplyEmployeeName;
        }

        public void setReplyEmployeeName(String ReplyEmployeeName) {
            this.ReplyEmployeeName = ReplyEmployeeName;
        }

        public String getReplyFile() {
            return ReplyFile;
        }

        public void setReplyFile(String ReplyFile) {
            this.ReplyFile = ReplyFile;
        }

        public String getReplyFile_filename() {
            return ReplyFile_filename;
        }

        public void setReplyFile_filename(String ReplyFile_filename) {
            this.ReplyFile_filename = ReplyFile_filename;
        }
    }
}
