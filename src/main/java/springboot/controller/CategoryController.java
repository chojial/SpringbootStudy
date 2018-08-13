package springboot.controller;

import java.util.List;

import org.hibernate.boot.archive.scan.spi.PackageInfoArchiveEntryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import springboot.Dao.CategoryDAO;
import springboot.entity.Category;
import springboot.mapper.CategoryMapper;


@Controller
public class CategoryController {
	@Autowired 
	private CategoryMapper categoryMapper;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	/*@RequestMapping("/listCategory")
    public String listCategory(Model m) throws Exception {
       List<Category> cs=categoryDAO.findAll();
          
        m.addAttribute("cs", cs);
          
        return "listCategory";
    }*/
	
	/*@RequestMapping("/listCategory2")
    public String listCategory2(Model m) throws Exception {
       List<Category> cs=categoryMapper.findAll();
          
        m.addAttribute("cs", cs);
          
        return "listCategory";
    }*/
	
	
	/*@RequestMapping("/listCategory3")
    public String listCategory3(Model m) throws Exception {
       List<Category> cs=categoryMapper.findAll();
          
        m.addAttribute("cs", cs);
          
        return "listCategory";
    }*/
	
	/*@RequestMapping("/addCategory")
	public String addCategory(Category c) throws Exception {
		categoryDAO.save(c);
		return "redirect:listCategory";
	}
	
	@RequestMapping("/deleteCategory")
	public String deleteCategory(Category c) throws Exception {
		categoryDAO.delete(c);
		return "redirect:listCategory";
	}
	@RequestMapping("/updateCategory")
	public String updateCategory(Category c) throws Exception {
		categoryDAO.save(c);
		return "redirect:listCategory";
	}
	@RequestMapping("/editCategory")
	public String editCategory(int id,Model m) throws Exception {
		Category c= categoryDAO.getOne(id);
		m.addAttribute("c", c);
		return "editCategory";
	}*/
	
	/*@RequestMapping("/listCategory4")
	public String listCategory4(Model m,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
		start = start<0?0:start;
		Sort sort = new Sort(Sort.Direction.ASC, "id");
		Pageable pageable = new PageRequest(start, size, sort);
		Page<Category> page =categoryDAO.findAll(pageable);
		m.addAttribute("page", page);
	    return "listCategory4";
	}*/
	
	@RequestMapping("/addCategory")
	public String listCategory(Category c) throws Exception {
		categoryMapper.save(c);
		return "redirect:listCategory";
	}
	@RequestMapping("/deleteCategory")
	public String deleteCategory(Category c) throws Exception {
		categoryMapper.delete(c.getId());
		return "redirect:listCategory";
	}
	@RequestMapping("/updateCategory")
	public String updateCategory(Category c) throws Exception {
		categoryMapper.update(c);
		return "redirect:listCategory";
	}
	@RequestMapping("/editCategory")
	public String listCategory(int id,Model m) throws Exception {
		Category c= categoryMapper.get(id);
		m.addAttribute("c", c);
		return "editCategory";
	}
	
	
	@RequestMapping("/listCategory")
	public String listCategory(Model m,@RequestParam(value="start",defaultValue="0")int start,
			@RequestParam(value="size",defaultValue="5")int size) {
		PageHelper.startPage(start, size,"id asc");
		List<Category> cs=categoryMapper.findAll();
		PageInfo<Category> page = new PageInfo<>(cs);
		m.addAttribute("page", page);
		return "listCategory2";
	}

	
}
