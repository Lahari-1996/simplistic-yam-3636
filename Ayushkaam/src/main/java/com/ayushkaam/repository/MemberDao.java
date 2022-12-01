package com.ayushkaam.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ayushkaam.model.Member;


@Repository
public interface MemberDao extends JpaRepository<Member, Integer>{

	
	//public  Optional<Member> findByMobileNumber(String mobileNumber);
	
	//public Optional<Member> findByAadharNumber(Long aadharNumber);
	
	@Query("select m from Member m where m.idcard.id=(select i.id from Idcard i where i.adharCard.aadharNumber=?1)")
	public Member getByAdharNo(Long aadharNo);

	@Query("select m from Member m where m.idcard.id=(select i.id from Idcard i where i.panCard.panNo=?1)")
	public Member getByPanNo(String panNo);
}
