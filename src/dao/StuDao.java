package dao;

import Model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("StuDao")
public interface StuDao {
    public int getCountStu();//获取全部学生数量
    public Student getStuById(@Param("id") Integer id);//查询
    public int deleteStuById(@Param("id") Integer id);//删除
    public int UpDateStu(Student student);//更新
    public int AddStu(Student student);//增加
    public int getCountStuByName(@Param("stuname") String StuName);//总数
    //获取全部数据分页
    public List<Student> getAll(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
    //搜索分页
    public List<Student> getAllByName(@Param("stuname") String StuName,@Param("pageNum") Integer pagNum,@Param("pageSize") Integer pageSize);
}
