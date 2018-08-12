package springboot.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.entity.Category;

public interface CategoryDAO extends JpaRepository<Category,Integer>{

}
