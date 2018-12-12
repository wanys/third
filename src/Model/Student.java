package Model;

public class Student {
    private int id;
    private String stuname;
    private int stuage;
    private String stusex;
    private String stumark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStuage(){
        return stuage;
    }
    public void setStuage(int stuage){
        this.stuage=stuage;
    }

    public String getStuname(){
        return stuname;
    }
    public void setStuname(String stuname){
        this.stuname=stuname;
    }

    public String getStusex(){
        return stusex;
    }
    public void setStusex(String stusex){
        this.stusex=stusex;
    }

    public String getStumark(){
        return stumark;
    }
    public void setStumark(String stuscore){
        this.stumark=stuscore;
    }
}

