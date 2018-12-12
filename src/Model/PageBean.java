package Model;

import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public class PageBean<T> {
    private int pageNum;//当前页，从请求那边传过来
    private int pageSize;//每页的条数
    private int totalRecord;//数据库查询到的总记录数

    private int offSet;//数据库的偏移
    private int totalPage;//总页数，需计算得来
    private int startIndex;//开始索引，既在数据库中要从第几行数据开始，有了startIndex和pageSize。
    //知道了limit语句的两个数据，就能获得每页需要显示的数据了
    private List<T> list;//每页显示的数据放在List集合中

    private int start;//一共展示5页，所展示的最左边显示的页数
    private int end;//最右边
    public PageBean(int pageNum,int pageSize,int totalRecord){
        this.pageNum=pageNum;
        this.pageSize=pageSize;
        this.totalRecord=totalRecord;

        if(totalRecord%pageSize==0){
            this.totalPage=totalRecord/pageSize;
        }else{
            this.totalPage=(totalRecord/pageSize)+1;
        }

        this.startIndex=(pageNum-1)*pageSize;//展示的这一页第一条数据
        //显示5页
        this.start=1;//一共展示5页，所展示的
        this.end=5;

        if(totalPage<=5){
            this.end=this.totalPage;
        }else{
            this.start=pageNum-2;
            this.end=pageNum+2;
            if(start<0){
                this.start=1;
                this.end=5;
            }
            if(end>this.totalPage){
                this.end=totalPage;
                this.start=end-5;
            }
        }
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    //get、set方法。

    public int getOffSet() {
        return (pageNum-1)*pageSize;
    }

    public void setOffSet(int offSet) {
        this.offSet = offSet;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
