package com.liulangf.tools;

/**
 * 
 *
 * @author liulangf
 *
 */
public class Git {
	
	/**
	 * git config --global http.proxy http://proxy-bj1.petrochina:8080
	 * proxy3.bj.petrochina:8080
	 */
	void git_config_proxy() {
	}

	/**
	 * git config --global --list
	 * 
	 * user.name
	 * user.email
	 * 
	 * git config --global user.name "liulangf"
	 * git config --global user.email "liulangf@163.com"
	 */
	void git_config_global() {
	}

	/**
	 * cd git_repository;
	 * git gui;
	 * 
	 * gitk --all;
	 */
	void git_gui() {
	}
	

	/**
	 * mkdir work;
	 * git init;
	 * git add index.md
	 * git commit -m "message"
	 * git remote add origin https://github.com/liulangf/liulangf-java.git
	 * git push -u origin master
	 * git log
	 * 
	 * git status
	 * 
	 */
	void git_repository() {
	}
	

	/**
	 * git branch branch_name master
	 * 
	 */
	void git_branch() {
	}
	
	
	/**
	 * git commit -m "message" -a  //提交所有的修改
	 * 
	 */
	void git_commit() {
	}
	

	/**
	 * git remote add <name> <remote-repository-url>
	 * 给远程版本库添加别名
	 * 
	 * git remote add origin git@github.com:liulangf/liulangf-java.git
	 * 设置liulangf-java。git 为本地仓库的远程仓库
	 * 
	 * git push -u origin master
	 * 推送当前分支下本地仓库的内容到远程仓库
	 * 
	 * git clone 获取远程仓库
	 * 
	 * git fetch
	 * git pull
	 * 与远程版本库同步
	 * 
	 * upstream repository:上游版本库 及公共版本库 及远程版本库
	 * git push 将本地版本库推入上游版本库
	 * 
	 * origin: 远程版本库的别名,用于区分本地版本库
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	void git_remote() {
	}

}
























