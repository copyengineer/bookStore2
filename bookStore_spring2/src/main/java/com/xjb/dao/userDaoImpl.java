package com.xjb.dao;
import com.xjb.bean.user;
public class userDaoImpl extends basicDao<user> {

    public user getOneUser(String userName) {
        String sql = "select * from user_info where userName = ?";
        try {
            user user = getbean(sql, new Object[]{userName});
            return user;
        } catch (Exception e) {
            System.out.println("按用户名查找用户出错了!");
            e.printStackTrace();
            return null;
        }
    }

    public int addUser(user user1) {
        String sql = "insert into user_info values(?,?,?)";
        try {
            int update = update(sql, new Object[]{user1.getUserName(), user1.getPassWord(), user1.getPhoneNumber()});
            return update;
        } catch (Exception e) {
            System.out.println("添加用户出错了!");
            e.printStackTrace();
            return 0;
        }
    }

    public user cheackUser(user user1) {

        String sql = "select * from user_info where userName=? and passWord=? and phoneNumber=?";
        try {
            user bean = getbean(sql, new Object[]{user1.getUserName(), user1.getPassWord(), user1.getPhoneNumber()});
            return bean;
        } catch (Exception e) {
            System.out.println("验证用户出错了!");
            e.printStackTrace();
            return null;
        }
    }
}


