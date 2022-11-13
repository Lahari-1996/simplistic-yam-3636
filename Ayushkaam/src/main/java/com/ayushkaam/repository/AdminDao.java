package com.ayushkaam.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ayushkaam.model.Admin;
@Repository
public interface AdminDao extends JpaRepository<Admin, Integer>{
//<<<<<<< HEAD
    public Optional<Admin> findByAdminId(Integer adminId);
//=======
//	 public Optional<Admin> findByAdminId(Integer adminId);
//>>>>>>> 73aa0a895f826e9e26155a0fe2bacb33cfbfd304
	
	public Optional<Admin> findByAdminName(String mobileNo);
	
	
	
}