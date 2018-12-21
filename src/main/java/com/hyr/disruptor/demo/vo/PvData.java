package com.hyr.disruptor.demo.vo;

/*******************************************************************************
 * @date 2018-12-21 上午 11:31
 * @author: <a href=mailto:>黄跃然</a>
 * @Description: 消费的传输对象
 ******************************************************************************/
public class PvData {

    private String pvid;
    private Long num;
    private String content;

    public PvData() {
    }

    public PvData(String pvid, Long num, String content) {
        this.pvid = pvid;
        this.num = num;
        this.content = content;
    }

    public String getPvid() {
        return pvid;
    }

    public void setPvid(String pvid) {
        this.pvid = pvid;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PvData{" +
                "pvid='" + pvid + '\'' +
                ", num=" + num +
                ", content='" + content + '\'' +
                '}';
    }
}
