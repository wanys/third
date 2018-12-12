package controller;

import Model.PageBean;
import Model.Student;
import Model.User;
import Service.StuService;
import Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
@Controller
public class loginController {
    @Resource(name="UserService")
    private UserService us;
    @Resource(name="StuService")
    private StuService ss;
    public int pageSize=5;
    public String StuName;

    public UserService getUs() {
        return us;
    }

    public StuService getSs() {
        return ss;
    }

    public void setSs(StuService ss) {
        this.ss = ss;
    }

    public String getStuName() {
        return StuName;
    }

    public void setStuName(String stuName) {
        StuName = stuName;
    }

    public void setUs(UserService us) {
        this.us = us;
    }
    @RequestMapping(value="index.do",method= RequestMethod.GET)
    public String index(HttpServletRequest request){
        System.out.println("1 访问index经过后台");
        return "index";
    }
    @RequestMapping (value="index.do",method = RequestMethod.POST)
    public String index1(HttpServletRequest request, HttpServletResponse response){
        String  name=request.getParameter("account");
        String psw=request.getParameter("psw");
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("name",name);
        map.put("psw",psw);
        System.out.println(map);
        User u=us.getUserNameAndPsw(map);
        System.out.println(u);
        if(u!=null){
            return "redirect:login.do";
        }else{
            return "redirect:index.do";
        }

    }
  @RequestMapping(value = "login.do",method = RequestMethod.GET)
  public String login1(HttpServletRequest request){
      int pageNum=1;
      PageBean pb= ss.getAllStuWithPage(pageNum,pageSize);
      request.setAttribute("pageBean",pb);
      return "login";
  }

    @RequestMapping(value="login.do",method=RequestMethod.POST)
    public String FindAllWithPage(HttpServletRequest request){
        StuName= request.getParameter("stuname");
        PageBean pb= ss.getAllStuByNameWithPage(StuName,1,pageSize);
        request.setAttribute("pageBean",pb);
        return "login";
    }

    @RequestMapping(value="Paging.do",method=RequestMethod.GET)
    public String index1(HttpServletRequest request){
        int pageNum= Integer.valueOf(request.getParameter("pageNum"));
        if(pageNum>0)
        {
            PageBean pb= ss.getAllStuByNameWithPage(StuName,pageNum,pageSize);
            request.setAttribute("pageBean",pb);
        }
        else
        {
            PageBean pb= ss.getAllStuByNameWithPage(StuName,1,pageSize);
            request.setAttribute("pageBean",pb);
        }

        return "login";
    }
    @RequestMapping(value="deleteStu.do",method=RequestMethod.GET)
    public String deleteStu(HttpServletRequest request){
        Integer id= Integer.valueOf(request.getParameter("id"));
        int check=ss.deleteStuById(id);
        System.out.println(check);
        if(check==1)
        {
            return "redirect:login.do";
        }
        else
        {
            return "index";
        }
    }

    @RequestMapping(value="updateStu.do",method=RequestMethod.GET)
    public String updateStu(HttpServletRequest request){
        Integer id= Integer.valueOf(request.getParameter("id"));
        Student student=ss.getStuById(id);
        System.out.println(student);
        request.setAttribute("Student",student);
        return "UpDateStu";
    }

    @RequestMapping(value="updateStu.do",method=RequestMethod.POST)
    public String updateStu1(HttpServletRequest request,Student Stu){
        StuName=null;
        int check =ss.upDataStu(Stu);
        if(check==1)
        {
            return "redirect:login.do";
        }
        else
        {
            return "UpDateStu";
        }
    }
    @RequestMapping(value="AddStu.do",method=RequestMethod.GET)
    public String AddStu(HttpServletRequest request){

        return "AddStu";
    }

    @RequestMapping(value="AddStu.do",method=RequestMethod.POST)
    public String AddStu1(HttpServletRequest request,Student Stu){

        int check =ss.addStu(Stu);
        if(check==1)
        {
            return "redirect:login.do";
        }
        else
        {
            return "AddStu";
        }
    }
    @RequestMapping(value = "zhuce.do",method = RequestMethod.GET)
    public String zhuce(HttpServletRequest request){
        User u=new User();
        u.setPsw("123");
        u.setName("WYS");
        request.setAttribute("User", u);
      System.out.println("3 访问zhuce经过后台");
        return "zhuce";
  }
@RequestMapping(value = "zhuce.do",method = RequestMethod.POST)
  public String zhu(User u){
    System.out.println(u+"====================================");
    System.out.println(u.toString()+"-----------------------------");
    if (us.addUser(u)==1){
        return "redirect:index.do";
    }else{
          return "zhuce";

    }
  }

}
