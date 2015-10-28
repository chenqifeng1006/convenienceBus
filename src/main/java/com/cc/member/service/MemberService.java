package com.cc.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.member.dao.MemberMapper;
import com.cc.member.dto.Member;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	public List<Member> query(){
		return this.memberMapper.query();
	}
	
	public Member getById(Long id){
		return this.memberMapper.getById(id);
	}
	
	public Member getByName(String username){
		return this.memberMapper.getByName(username);
	}
	
	public Member getByPhone(String cellphone){
		return this.memberMapper.getByPhone(cellphone);
	}
	
	public void add(Member member){
		this.memberMapper.add(member);
	}
	
	public void edit(Member member){
		this.memberMapper.edit(member);
	}
	
	public void delete(Long id){
		this.memberMapper.delete(id);
	}
}
