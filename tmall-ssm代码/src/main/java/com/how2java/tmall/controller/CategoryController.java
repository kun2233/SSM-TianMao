package com.how2java.tmall.controller;
/*
 Controller实现类包含了对用户请求的处理逻辑，是用户请求和业务逻辑之间的“桥梁,负责具体的业务逻辑处理
 在Spring MVC中使用扫描机制找到应用中所有基于注解的控制器类
 */
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.util.ImageUtil;
import com.how2java.tmall.util.Page;
import com.how2java.tmall.util.UploadedImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
////使用org.springframework.web.bind.annotation.RequestMapping注解类型将请求与处理方法一一对应。
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;



//注解@Controller声明当前类是一个控制器
@Controller
//注解@RequestMapping("")表示访问的时候无需额外的地址
@RequestMapping("")
public class CategoryController {
    //注解@Autowired把CategoryServiceImpl自动装配进了CategoryService 接口
    @Autowired
    CategoryService categoryService;
    //注解@RequestMapping("admin_category_list") 映射admin_category_list路径的访问

    /*@RequestMapping("admin_category_list")
    public String list(Model model,Page page){ //为方法list增加参数Page用于获取浏览器传递过来的分页信息
        List<Category> cs = categoryService.list(page); //获取当前页的分类集合
        int total = categoryService.total(); //获取分类总数
        page.setTotal(total);  //为分页对象设置总数
        model.addAttribute("cs",cs);//把分类集合放在"cs"中
        model.addAttribute("page",page); //把分页对象放在 "page“ 中
        return "admin/listCategory"; //跳转到listCategory.jsp页面
    }*/
    @RequestMapping("admin_category_list")
    public String list(Model model,Page page){
        //通过分页插件PageHelper指定分页参数
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Category> cs= categoryService.list(); //调用list() 获取对应分页的数据
        int total = (int) new PageInfo<>(cs).getTotal(); //通过PageInfo获取总数
        page.setTotal(total);
        model.addAttribute("cs", cs);
        model.addAttribute("page", page);
        return "admin/listCategory";
    }

    @RequestMapping("admin_category_add")
    public String add(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        System.out.println(c.getId());
        categoryService.add(c);
        System.out.println(c.getId());
        File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,c.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        System.out.println(uploadedImageFile);
        System.out.println(uploadedImageFile.getImage());
        System.out.println(file);
        uploadedImageFile.getImage().transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);

        return "redirect:/admin_category_list";
    }

    @RequestMapping("admin_category_delete")
    public String delete(int id,HttpSession session) throws IOException {
        categoryService.delete(id);

        File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,id+".jpg");
        file.delete();

        return "redirect:/admin_category_list";
    }

    @RequestMapping("admin_category_edit")
    public String edit(int id,Model model) throws IOException {
        Category c= categoryService.get(id);
        model.addAttribute("c", c);
        return "admin/editCategory";
    }

    @RequestMapping("admin_category_update")
    public String update(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        categoryService.update(c);
        MultipartFile image = uploadedImageFile.getImage();
        if(null!=image &&!image.isEmpty()){
            File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
            File file = new File(imageFolder,c.getId()+".jpg");
            image.transferTo(file);
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img, "jpg", file);
        }
        return "redirect:/admin_category_list";
    }
}