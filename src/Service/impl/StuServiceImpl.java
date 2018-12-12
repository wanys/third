package Service.impl;

import Model.PageBean;
import Model.Student;
import Service.StuService;
import dao.StuDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("StuService")
public class StuServiceImpl implements StuService {
    @Resource(name="StuDao")
    private StuDao Sd;
    public void setSd(StuDao sd){
        this.Sd=sd;
    }
    public StuDao getSd(){
        return Sd;
    }
    @Override
    public int getCountStu() {
        return Sd.getCountStu();
    }

    @Override
    public Student getStuById(Integer id) {
        return Sd.getStuById(id);
    }

    @Override
    public int deleteStuById(Integer id) {
        return Sd.deleteStuById(id);
    }

    @Override
    public int addStu(Student student) {
        return Sd.AddStu(student);
    }

    @Override
    public int upDataStu(Student student) {
        return Sd.UpDateStu(student);
    }

    @Override
    public int getCountStuByName(String StuName) {
        return Sd.getCountStuByName(StuName);
    }

    @Override
    public List<Student> getAll(Integer pageNum, Integer pageSize) {
        return Sd.getAll(pageNum,pageSize);
    }

    @Override
    public List<Student> getAllByName(String StuName, Integer pageNum, Integer PageSize) {
        return getSd().getAllByName(StuName,pageNum,PageSize);
    }

    @Override
    public PageBean<Student> getAllStuWithPage(Integer pageNum, Integer pageSize) {
        int totalRecord=Sd.getCountStu();
        PageBean pb=new PageBean(pageNum,pageSize,totalRecord);
        pb.setList(Sd.getAll(pb.getOffSet(),pageSize));
        return pb;
    }

    @Override
    public PageBean<Student> getAllStuByNameWithPage(String StuName, Integer pageNum, Integer pageSize) {
    int totalRecord= (int) Sd.getCountStuByName(StuName);
		if(totalRecord!=0)
    {
        PageBean pb=new PageBean(pageNum,pageSize,totalRecord);
        System.out.println(pageNum+"====="+pageSize+"===="+totalRecord);
        pb.setList(Sd.getAllByName(StuName,pb.getOffSet(),pageSize));
        return pb;
    }else
    {
        PageBean pb=new PageBean(0,pageSize,0);
        return pb;
    }
}
}


