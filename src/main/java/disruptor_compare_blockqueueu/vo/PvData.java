package disruptor_compare_blockqueueu.vo;

/*******************************************************************************
 * @date 2018-12-25 上午 11:58
 * @author: <a href=mailto:>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class PvData {

    private long index;

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "PvData{" +
                "index=" + index +
                '}';
    }
}
