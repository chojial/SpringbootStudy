package springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import springboot.entity.Category;
@Mapper
public interface CategoryMapper {
	@Select("select * from category_")
	List<Category> findAll();
	
	@Select("select * from  category_ where id = #{id}")
	public Category get(int id);
	
	@Insert("insert into category_ ( name ) values (#{name})")
	public int save(Category category);
	
	@Delete("delete from category_ where id = #{id}")
	public void delete(int id);
	
	@Update("update category_ set name = #{name} where id = #{id}")
	public int update(Category category);
}
