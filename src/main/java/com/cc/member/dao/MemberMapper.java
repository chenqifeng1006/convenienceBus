package com.cc.member.dao;

import java.util.List;

import com.cc.member.dto.Member;

public interface MemberMapper {
	
	public Long add(Member member);
	
	public void edit(Member member);
	
	public void delete(Long id);
	
	public Member getById(Long id);
	
	public Member getByPhone(String cellphone);
	
	public Member getByName(String username);
	
	public List<Member> query();
}
