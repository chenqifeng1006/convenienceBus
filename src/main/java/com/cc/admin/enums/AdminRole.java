package com.cc.admin.enums;

public enum AdminRole {
	superAdmin,//超级管理员，可新建管理员，维护司机信息，维护个人信息
	commonAdmin,//普通管理员，可维护司机信息，维护个人信息
	driverAdmin,//司机管理员，仅可维护司机信息
	memberAdmin//个人管理员，仅可维护个人信息
}
